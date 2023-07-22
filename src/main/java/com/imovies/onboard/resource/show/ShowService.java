package com.imovies.onboard.resource.show;

import com.imovies.onboard.resource.show.dto.ShowCalendarDTO;
import com.imovies.onboard.resource.show.dto.ShowCalendarPriceDTO;
import com.imovies.onboard.resource.show.dto.ShowDTO;
import com.imovies.onboard.resource.show.entity.Show;
import com.imovies.onboard.resource.show.entity.ShowCalendar;
import com.imovies.onboard.resource.show.entity.ShowCalendarPrice;
import com.imovies.onboard.resource.show.repository.ShowRepository;
import com.imovies.onboard.resource.show.vo.ShowUpdateVO;
import com.imovies.onboard.resource.show.vo.ShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
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
        Show original = requireOne(id);
        return toDTO(original);
    }

    public Page<Show> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return showRepository.findAll(pageable);
    }

    private ShowDTO toDTO(Show showEntity) {
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
