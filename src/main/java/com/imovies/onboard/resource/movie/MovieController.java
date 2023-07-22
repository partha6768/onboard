package com.imovies.onboard.resource.movie;

import com.imovies.onboard.resource.movie.dto.MovieDTO;
import com.imovies.onboard.resource.movie.entity.Movie;
import com.imovies.onboard.resource.movie.vo.MovieUpdateVO;
import com.imovies.onboard.resource.movie.vo.MovieVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/movie")
@Tag( name = "Movie API", description = "All APIs related to Movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public String save(@Valid @RequestBody MovieVO vO) {
        return movieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MovieUpdateVO vO) {
        movieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MovieDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return movieService.getById(id);
    }

    @GetMapping
    public Page<Movie> query(@RequestParam(defaultValue = "0") Integer pageNo,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "id") String sortBy) {
        return movieService.query(pageNo, pageSize, sortBy);
    }
}
