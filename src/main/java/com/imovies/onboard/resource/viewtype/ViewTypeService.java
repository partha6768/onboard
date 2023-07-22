package com.imovies.onboard.resource.viewtype;

import com.imovies.onboard.resource.viewtype.vo.ViewTypeUpdateVO;
import com.imovies.onboard.resource.viewtype.vo.ViewTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ViewTypeService {

    private final ViewTypeRepository viewTypeRepository;

    public ViewTypeService(ViewTypeRepository viewTypeRepository) {
        this.viewTypeRepository = viewTypeRepository;
    }

    public String save(ViewTypeVO vO) {
        ViewType bean = new ViewType();
        BeanUtils.copyProperties(vO, bean);
        bean = viewTypeRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        viewTypeRepository.deleteById(id);
    }

    public void update(String id, ViewTypeUpdateVO vO) {
        ViewType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        viewTypeRepository.save(bean);
    }

    public ViewTypeDTO getById(String id) {
        ViewType original = requireOne(id);
        return toDTO(original);
    }

    public Page<ViewType> query(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return viewTypeRepository.findAll(pageable);
    }

    private ViewTypeDTO toDTO(ViewType original) {
        ViewTypeDTO bean = new ViewTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ViewType requireOne(String id) {
        return viewTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
