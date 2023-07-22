package com.imovies.onboard.resource.city;

import com.imovies.onboard.resource.city.vo.CityUpdateVO;
import com.imovies.onboard.resource.city.vo.CityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Integer save(CityVO vO) {
        City bean = new City();
        BeanUtils.copyProperties(vO, bean);
        bean = cityRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    public void update(Integer id, CityUpdateVO vO) {
        City bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cityRepository.save(bean);
    }

    public CityDTO getById(Integer id) {
        City original = requireOne(id);
        return toDTO(original);
    }

    public List<CityDTO> query(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<City> pagedResult = cityRepository.findAll(pageable);
        if(pagedResult.hasContent()) {
            return toDTO(pagedResult);
        } else {
            return new ArrayList<>();
        }
    }

    private List<CityDTO> toDTO(Page pagedResult) {
        List<City> list = pagedResult.getContent();
        return list.stream()
                .map( x -> toDTO(x) )
                .collect(Collectors.toList());

    }

    private CityDTO toDTO(City original) {
        CityDTO bean = new CityDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private City requireOne(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
