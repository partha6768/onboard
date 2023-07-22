package com.imovies.onboard.resource.screen;

import com.imovies.onboard.resource.screen.dto.ScreenDTO;
import com.imovies.onboard.resource.screen.entity.Screen;
import com.imovies.onboard.resource.screen.vo.ScreenUpdateVO;
import com.imovies.onboard.resource.screen.vo.ScreenVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/screen")
@Tag( name = "Theater Screen API", description = "All APIs related to Theater Screen")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public String save(@Valid @RequestBody ScreenVO vO) {
        return screenService.save(vO).toString();
    }

    @DeleteMapping("/{theaterId}/{name}")
    public void delete(@Valid @NotNull @PathVariable("theaterId") Integer theaterId, @PathVariable("name")String name) {
        screenService.delete(theaterId, name);
    }

    @PutMapping("/{theaterId}/{name}")
    public void update(@Valid @NotNull @PathVariable("theaterId") Integer theaterId, @PathVariable("name")String name,
                       @Valid @RequestBody ScreenUpdateVO vO) {
        screenService.update(theaterId, name, vO);
    }

    @GetMapping("/{theaterId}/{name}")
    public ScreenDTO getById(@Valid @NotNull @PathVariable("theaterId") Integer id, @PathVariable("name")String name) {
        return screenService.getById(id,name);
    }

    @GetMapping("/{theaterId}")
    public List<Screen> getByTheaterId(@Valid @NotNull @PathVariable("theaterId") Integer theaterId) {
        return screenService.getByTheaterId(theaterId);
    }

    @GetMapping
    public Page<Screen> query(@RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "name") String sortBy) {
        return screenService.query(pageNo,pageSize,sortBy);
    }
}
