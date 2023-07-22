package com.imovies.onboard.resource.movietype;

import com.imovies.onboard.resource.movietype.MovieTypeService;
import com.imovies.onboard.resource.movietype.vo.MovieTypeQueryVO;
import com.imovies.onboard.resource.movietype.vo.MovieTypeUpdateVO;
import com.imovies.onboard.resource.movietype.vo.MovieTypeVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/movieType")
@Tag( name = "Movie Type API", description = "All APIs related to Movie Type")
public class MovieTypeController {

    @Autowired
    private MovieTypeService movieTypeService;

    @PostMapping
    public String save(@Valid @RequestBody MovieTypeVO vO) {
        return movieTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        movieTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody MovieTypeUpdateVO vO) {
        movieTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MovieTypeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return movieTypeService.getById(id);
    }

    @GetMapping
    public Page<MovieType> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "name") String sortBy) {
        return movieTypeService.query(pageNo, pageSize, sortBy);
    }
}
