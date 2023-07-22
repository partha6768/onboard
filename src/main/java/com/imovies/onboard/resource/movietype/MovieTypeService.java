package com.imovies.onboard.resource.movietype;

import com.imovies.onboard.resource.movietype.vo.MovieTypeQueryVO;
import com.imovies.onboard.resource.movietype.vo.MovieTypeUpdateVO;
import com.imovies.onboard.resource.movietype.vo.MovieTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MovieTypeService {

    @Autowired
    private MovieTypeRepository movieTypeRepository;

    public String save(MovieTypeVO vO) {
        MovieType bean = new MovieType();
        BeanUtils.copyProperties(vO, bean);
        bean = movieTypeRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        movieTypeRepository.deleteById(id);
    }

    public void update(String id, MovieTypeUpdateVO vO) {
        MovieType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        movieTypeRepository.save(bean);
    }

    public MovieTypeDTO getById(String id) {
        MovieType original = requireOne(id);
        return toDTO(original);
    }

    public Page<MovieType> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return movieTypeRepository.findAll(pageable);
    }

    private MovieTypeDTO toDTO(MovieType original) {
        MovieTypeDTO bean = new MovieTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MovieType requireOne(String id) {
        return movieTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
