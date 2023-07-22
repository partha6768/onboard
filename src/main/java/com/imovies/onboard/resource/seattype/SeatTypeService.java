package com.imovies.onboard.resource.seattype;

import com.imovies.onboard.resource.seattype.vo.SeatTypeUpdateVO;
import com.imovies.onboard.resource.seattype.vo.SeatTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SeatTypeService {

    private final SeatTypeRepository seatTypeRepository;

    public SeatTypeService(SeatTypeRepository seatTypeRepository) {
        this.seatTypeRepository = seatTypeRepository;
    }

    public String save(SeatTypeVO vO) {
        SeatType bean = new SeatType();
        BeanUtils.copyProperties(vO, bean);
        bean = seatTypeRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        seatTypeRepository.deleteById(id);
    }

    public void update(String id, SeatTypeUpdateVO vO) {
        SeatType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        seatTypeRepository.save(bean);
    }

    public SeatTypeDTO getById(String id) {
        SeatType original = requireOne(id);
        return toDTO(original);
    }

    public Page<SeatType> query(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return seatTypeRepository.findAll(pageable);
    }

    private SeatTypeDTO toDTO(SeatType original) {
        SeatTypeDTO bean = new SeatTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SeatType requireOne(String id) {
        return seatTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
