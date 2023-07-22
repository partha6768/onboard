package com.imovies.onboard.resource.usertype;

import com.imovies.onboard.resource.usertype.vo.UserTypeUpdateVO;
import com.imovies.onboard.resource.usertype.vo.UserTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public String save(UserTypeVO vO) {
        UserType bean = new UserType();
        BeanUtils.copyProperties(vO, bean);
        bean = userTypeRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        userTypeRepository.deleteById(id);
    }

    public void update(String id, UserTypeUpdateVO vO) {
        UserType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userTypeRepository.save(bean);
    }

    public UserTypeDTO getById(String id) {
        UserType original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserType> query(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return userTypeRepository.findAll(pageable);
    }

    private UserTypeDTO toDTO(UserType original) {
        UserTypeDTO bean = new UserTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserType requireOne(String id) {
        return userTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
