package com.imovies.onboard.resource.movie;

import com.imovies.onboard.resource.movie.dto.MovieDTO;
import com.imovies.onboard.resource.movie.dto.MovieViewTypeDTO;
import com.imovies.onboard.resource.movie.entity.Movie;
import com.imovies.onboard.resource.movie.entity.MovieViewType;
import com.imovies.onboard.resource.movie.repository.MovieRepository;
import com.imovies.onboard.resource.movie.vo.MovieUpdateVO;
import com.imovies.onboard.resource.movie.vo.MovieVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Integer save(MovieVO movieVO) {
        Movie movieEntity = toEntity(movieVO);
        log.info("movie entity: {}", movieEntity);
        movieEntity = movieRepository.save(movieEntity);
        return movieEntity.getId();
    }

    private static Movie toEntity(MovieVO movieVO) {
        Movie movieEntity = new Movie();
        BeanUtils.copyProperties(movieVO, movieEntity);
        List<MovieViewType> movieViewTypes = new ArrayList<>();
        movieVO.getMovieViewType().stream()
                        .forEach( movieViewTypeVO -> {
                            MovieViewType movieViewTypeEntity = new MovieViewType();
                            movieViewTypeEntity.setViewTypeName(movieViewTypeVO.getViewTypeName());
                            movieViewTypeEntity.setLanguageName(movieViewTypeVO.getLanguageName());
                            movieViewTypes.add(movieViewTypeEntity);
                        });
        movieEntity.setMovieViewTypes(movieViewTypes);
        return movieEntity;
    }

    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }

    public void update(Integer id, MovieUpdateVO movieUpdateVO) {
        Movie movieEntity = requireOne(id);
        BeanUtils.copyProperties(movieUpdateVO, movieEntity);
        movieRepository.save(movieEntity);
    }

    public MovieDTO getById(Integer id) {
        Movie movieEntity = requireOne(id);
        return toDTO(movieEntity);
    }

    public Page<Movie> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return movieRepository.findAll(pageable);
    }

    private MovieDTO toDTO(Movie original) {
        MovieDTO bean = new MovieDTO();
        List<MovieViewTypeDTO> movieViewTypeDTOList = new ArrayList<>();
        original.getMovieViewTypes()
                .stream()
                        .forEach( x -> {
                            MovieViewTypeDTO movieViewTypeDTO = new MovieViewTypeDTO();
                            BeanUtils.copyProperties(x, movieViewTypeDTO);
                            movieViewTypeDTOList.add(movieViewTypeDTO);
                        });
        BeanUtils.copyProperties(original, bean);
        bean.setMovieViewType(movieViewTypeDTOList);
        return bean;
    }

    private Movie requireOne(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
