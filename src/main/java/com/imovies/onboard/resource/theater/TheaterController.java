package com.imovies.onboard.resource.theater;

import com.imovies.onboard.resource.theater.vo.TheaterUpdateVO;
import com.imovies.onboard.resource.theater.vo.TheaterVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/theater")
@Tag( name = "Theater API", description = "All APIs related to Theater")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping
    public String save(@Valid @RequestBody TheaterVO vO) {
        return theaterService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        theaterService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody TheaterUpdateVO vO) {
        theaterService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TheaterDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return theaterService.getById(id);
    }

    @GetMapping
    public Page<Theater> query(@RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "id") String sortBy) {
        return theaterService.query(pageNo, pageSize, sortBy);
    }
}
