package com.imovies.onboard.resource.language;

import com.imovies.onboard.resource.language.vo.LanguageUpdateVO;
import com.imovies.onboard.resource.language.vo.LanguageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public String save(LanguageVO vO) {
        Language bean = new Language();
        BeanUtils.copyProperties(vO, bean);
        bean = languageRepository.save(bean);
        return bean.getName();
    }

    public void delete(String id) {
        languageRepository.deleteById(id);
    }

    public void update(String id, LanguageUpdateVO vO) {
        Language bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        languageRepository.save(bean);
    }

    public LanguageDTO getById(String id) {
        Language original = requireOne(id);
        return toDTO(original);
    }

    public Page<Language> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return languageRepository.findAll(pageable);
    }

    private LanguageDTO toDTO(Language original) {
        LanguageDTO bean = new LanguageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Language requireOne(String id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
