package com.imovies.onboard.resource.theater;

import com.imovies.onboard.resource.theater.vo.TheaterUpdateVO;
import com.imovies.onboard.resource.theater.vo.TheaterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Integer save(TheaterVO vO) {
        Theater bean = new Theater();
        BeanUtils.copyProperties(vO, bean);
        bean = theaterRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        theaterRepository.deleteById(id);
    }

    public void update(Integer id, TheaterUpdateVO vO) {
        Theater bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        theaterRepository.save(bean);
    }

    public TheaterDTO getById(Integer id) {
        Theater original = requireOne(id);
        return toDTO(original);
    }

    public Page<Theater> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return theaterRepository.findAll(pageable);
    }

    private TheaterDTO toDTO(Theater original) {
        TheaterDTO bean = new TheaterDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Theater requireOne(Integer id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
