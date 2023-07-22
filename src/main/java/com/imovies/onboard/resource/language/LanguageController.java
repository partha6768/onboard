package com.imovies.onboard.resource.language;

import com.imovies.onboard.resource.language.vo.LanguageUpdateVO;
import com.imovies.onboard.resource.language.vo.LanguageVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/language")
@Tag( name = "Language API", description = "All APIs related to Language")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public String save(@Valid @RequestBody LanguageVO vO) {
        return languageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody LanguageUpdateVO vO) {
        languageService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LanguageDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return languageService.getById(id);
    }

    @GetMapping
    public Page<Language> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "name") String sortBy) {
        return languageService.query(pageNo, pageSize, sortBy);
    }
}
