package com.imovies.onboard.resource.audiotype;

import com.imovies.onboard.resource.audiotype.vo.AudioTypeUpdateVO;
import com.imovies.onboard.resource.audiotype.vo.AudioTypeVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/audio-type")
@Tag( name = "Audio Type API", description = "All APIs related to Audio Type")
public class AudioTypeController {

    private final AudioTypeService audioTypeService;

    public AudioTypeController(AudioTypeService audioTypeService) {
        this.audioTypeService = audioTypeService;
    }

    @PostMapping
    public String save(@Valid @RequestBody AudioTypeVO vO) {
        return audioTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        audioTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody AudioTypeUpdateVO vO) {
        audioTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AudioTypeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return audioTypeService.getById(id);
    }

    @GetMapping
    public Page<AudioType> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "name") String sortBy) {
        return audioTypeService.query(pageNo, pageSize, sortBy);
    }
}
