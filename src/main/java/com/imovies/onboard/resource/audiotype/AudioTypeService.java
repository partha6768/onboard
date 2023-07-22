package com.imovies.onboard.resource.audiotype;

import com.imovies.onboard.resource.audiotype.vo.AudioTypeUpdateVO;
import com.imovies.onboard.resource.audiotype.vo.AudioTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AudioTypeService {

    private final AudioTypeRepository audioTypeRepository;

    public AudioTypeService(AudioTypeRepository audioTypeRepository) {
        this.audioTypeRepository = audioTypeRepository;
    }

    public String save(AudioTypeVO vO) {
        AudioType bean = new AudioType();
        BeanUtils.copyProperties(vO, bean);
        bean = audioTypeRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        audioTypeRepository.deleteById(id);
    }

    public void update(String id, AudioTypeUpdateVO vO) {
        AudioType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        audioTypeRepository.save(bean);
    }

    public AudioTypeDTO getById(String id) {
        AudioType original = requireOne(id);
        return toDTO(original);
    }

    public Page<AudioType> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return audioTypeRepository.findAll(pageable);
    }

    private AudioTypeDTO toDTO(AudioType original) {
        AudioTypeDTO bean = new AudioTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AudioType requireOne(String id) {
        return audioTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
