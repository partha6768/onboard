package com.imovies.onboard.resource.show;

import com.imovies.onboard.resource.show.dto.ShowCalendarDTO;
import com.imovies.onboard.resource.show.dto.ShowCalendarPriceDTO;
import com.imovies.onboard.resource.show.dto.ShowDTO;
import com.imovies.onboard.resource.show.entity.*;
import com.imovies.onboard.resource.show.repository.ShowCalendarSeatBookingRepository;
import com.imovies.onboard.resource.show.repository.ShowRepository;
import com.imovies.onboard.resource.show.vo.ShowUpdateVO;
import com.imovies.onboard.resource.show.vo.ShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    private final ShowCalendarSeatBookingRepository showCalendarSeatBookingRepository;

    public ShowService(ShowRepository showRepository, ShowCalendarSeatBookingRepository showCalendarSeatBookingRepository) {
        this.showRepository = showRepository;
        this.showCalendarSeatBookingRepository = showCalendarSeatBookingRepository;
    }

    public Integer save(ShowVO show) {
        Show showEntity = new Show();
        Set<ShowCalendar> showCalendars = new HashSet<>();
        show.getShowCalendars()
                .stream()
                .forEach( x -> {
                    ShowCalendar showCalendar = new ShowCalendar();
                    showCalendar.setShowRunDate(x.getShowRunDate());
                    showCalendar.setStartTime(x.getStartTime());
                    showCalendar.setEndTime(x.getEndTime());
                    Set<ShowCalendarPrice> showCalendarPrices = new HashSet<>();
                    x.getShowCalendarPrices()
                            .stream()
                            .forEach( y -> {
                                ShowCalendarPrice showCalendarPrice = new ShowCalendarPrice();
                                showCalendarPrice.setScreenSeatTypeId(y.getScreenSeatTypeId());
                                double price = y.getPrice().doubleValue();
                                showCalendarPrice.setPrice(price);
                                //TODO-Move 18 to constants or properties or database
                                double gst = price * 18/100;
                                showCalendarPrice.setGst(gst);
                                showCalendarPrice.setCgst(gst/2);
                                showCalendarPrice.setSgst(gst/2);
                                showCalendarPrice.setPriceBeforeTax(price-gst);
                                showCalendarPrices.add(showCalendarPrice);
                            });
                    showCalendar.setShowCalendarPrices(showCalendarPrices);
                    showCalendars.add(showCalendar);
                });
        BeanUtils.copyProperties(show, showEntity);
        showEntity.setShowCalendars(showCalendars);
        showEntity = showRepository.save(showEntity);
        return showEntity.getId();
    }

    public void delete(Integer id) {
        showRepository.deleteById(id);
    }

    public void update(Integer id, ShowUpdateVO vO) {
        Show bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        showRepository.save(bean);
    }

    public ShowDTO getById(Integer id) {
        Show showEntity = requireOne(id);
        //Get Booked seats
        Set<Integer> showCalendarIds = showEntity.getShowCalendars()
                .stream()
                .map(x -> x.getId())
                .collect(Collectors.toSet());
        Set<ShowCalendarSeatBooking> reservedSeats = showCalendarSeatBookingRepository.getReservedSeatIdsByShowCalendarByShowCalendarIds(showCalendarIds);
        Map<Integer, Set<Integer>> showCalendarSeatMapping = new HashMap<>();
        reservedSeats.stream().forEach( x -> {
            Set<Integer> seats = showCalendarSeatMapping.get(x.getShowCalendarId());
            if( seats == null) {
                seats = new HashSet<>();
                showCalendarSeatMapping.put(x.getShowCalendarId(), seats);
            }
            seats.add(x.getSeatId());
        });
        return toDTO(showEntity, showCalendarSeatMapping);
    }

    public Page<Show> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return showRepository.findAll(pageable);
    }

    private ShowDTO toDTO(Show showEntity, Map<Integer, Set<Integer>> showCalendarSeatMapping ) {
        ShowDTO showDTO = new ShowDTO();
        Set<ShowCalendarDTO> showCalendarDTOS = new HashSet<>();
        showEntity.getShowCalendars()
                .stream()
                .forEach( x -> {
                    ShowCalendarDTO showCalendarDTO = new ShowCalendarDTO();
                    BeanUtils.copyProperties(x, showCalendarDTO);
                    Set<ShowCalendarPriceDTO> showCalendarPriceDTOS = new HashSet<>();
                    x.getShowCalendarPrices()
                            .stream()
                            .forEach( y -> {
                                ShowCalendarPriceDTO showCalendarPriceDTO = new ShowCalendarPriceDTO();
                                BeanUtils.copyProperties(y, showCalendarPriceDTO);
                                showCalendarPriceDTOS.add(showCalendarPriceDTO);
                            });
                    showCalendarDTO.setShowCalendarPrices(showCalendarPriceDTOS);
                    showCalendarDTO.setReservedSeats(showCalendarSeatMapping.get(showCalendarDTO.getId()));
                    showCalendarDTOS.add(showCalendarDTO);
                });
        BeanUtils.copyProperties(showEntity, showDTO);
        showDTO.setShowCalendars(showCalendarDTOS);
        return showDTO;
    }

    private Show requireOne(Integer id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
