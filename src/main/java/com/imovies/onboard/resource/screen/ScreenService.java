package com.imovies.onboard.resource.screen;

import com.imovies.onboard.resource.screen.dto.ScreenDTO;
import com.imovies.onboard.resource.screen.dto.ScreenSeatTypeDTO;
import com.imovies.onboard.resource.screen.dto.SeatDTO;
import com.imovies.onboard.resource.screen.entity.Screen;
import com.imovies.onboard.resource.screen.entity.ScreenPk;
import com.imovies.onboard.resource.screen.entity.ScreenSeatType;
import com.imovies.onboard.resource.screen.entity.Seat;
import com.imovies.onboard.resource.screen.repository.ScreenRepository;
import com.imovies.onboard.resource.screen.vo.ScreenUpdateVO;
import com.imovies.onboard.resource.screen.vo.ScreenVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public String save(ScreenVO screenVO) {
        Screen screenEntity = new Screen();
        Set<ScreenSeatType> screenSeatTypeSet = new HashSet<>();
        screenVO.getScreenSeatTypes()
                .stream()
                .forEach( screeSeatTypeVO -> {
                    ScreenSeatType screenSeatType = new ScreenSeatType();
                    screenSeatType.setSeatTypeName(screeSeatTypeVO.getSeatTypeName());
                    Set<Seat> seats = new HashSet<>();
                    screeSeatTypeVO.getSeats()
                            .stream()
                            .forEach( seatVO -> {
                                Seat seat = new Seat();
                                seat.setRowNum(seatVO.getRowNum());
                                seat.setColumnNum(seatVO.getColumnNum());
                                seat.setSpace(seatVO.getSpace());
                                seats.add(seat);
                            });
                    screenSeatType.setSeats(seats);
                    screenSeatTypeSet.add(screenSeatType);
                });
        BeanUtils.copyProperties(screenVO, screenEntity);
        screenEntity.setScreenSeatTypes(screenSeatTypeSet);
        screenEntity = screenRepository.save(screenEntity);
        return screenEntity.getName();
    }

    public void delete(Integer theaterId, String name) {
        ScreenPk screenPk = new ScreenPk();
        screenPk.setName(name);
        screenPk.setTheaterId(theaterId);
        screenRepository.deleteById(screenPk);
    }

    public void update(Integer theaterId, String name, ScreenUpdateVO vO) {
        ScreenPk screenPk = new ScreenPk();
        screenPk.setName(name);
        screenPk.setTheaterId(theaterId);
        Screen bean = requireOne(screenPk);
        BeanUtils.copyProperties(vO, bean);
        screenRepository.save(bean);
    }

    public ScreenDTO getById(Integer theaterId, String name) {
        ScreenPk screenPk = new ScreenPk();
        screenPk.setName(name);
        screenPk.setTheaterId(theaterId);
        Screen original = requireOne(screenPk);
        return toDTO(original);
    }

    public List<Screen> getByTheaterId(Integer theaterId) {
        return screenRepository.findAllByTheaterId(theaterId);
    }

    public Page<Screen> query(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return screenRepository.findAll(pageable);
    }

    private ScreenDTO toDTO(Screen original) {
        ScreenDTO bean = new ScreenDTO();
        Set<ScreenSeatTypeDTO> screenSeatTypeDTOS = new HashSet<>();
        original.getScreenSeatTypes()
                .stream()
                .forEach( x -> {
                    ScreenSeatTypeDTO screenSeatTypeDTO = new ScreenSeatTypeDTO();
                    BeanUtils.copyProperties(x, screenSeatTypeDTO);
                    Set<SeatDTO> seatDTOS = new HashSet<>();
                    x.getSeats().stream()
                            .forEach( y -> {
                                SeatDTO seatDTO = new SeatDTO();
                                BeanUtils.copyProperties(y, seatDTO);
                                seatDTOS.add(seatDTO);
                            });
                    screenSeatTypeDTO.setSeats(seatDTOS);
                    screenSeatTypeDTOS.add(screenSeatTypeDTO);
                });
        BeanUtils.copyProperties(original, bean);
        bean.setScreenSeatTypes(screenSeatTypeDTOS);
        return bean;
    }

    private Screen requireOne(ScreenPk screenPk) {
        return screenRepository.findById(screenPk)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + screenPk));
    }
}
