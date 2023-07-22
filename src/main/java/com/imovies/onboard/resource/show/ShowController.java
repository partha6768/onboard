package com.imovies.onboard.resource.show;

import com.imovies.onboard.resource.show.dto.ShowDTO;
import com.imovies.onboard.resource.show.entity.Show;
import com.imovies.onboard.resource.show.vo.ShowUpdateVO;
import com.imovies.onboard.resource.show.vo.ShowVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/show")
@Tag( name = "Show API", description = "All APIs related to Show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public String save(@Valid @RequestBody ShowVO vO) {
        return showService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        showService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ShowUpdateVO vO) {
        showService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ShowDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return showService.getById(id);
    }

    @GetMapping
    public Page<Show> query(@RequestParam(defaultValue = "0") Integer pageNo,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "id") String sortBy) {
        return showService.query(pageNo, pageSize, sortBy);
    }
}
