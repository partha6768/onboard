package com.imovies.onboard.resource.viewtype;

import com.imovies.onboard.resource.viewtype.vo.ViewTypeUpdateVO;
import com.imovies.onboard.resource.viewtype.vo.ViewTypeVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/view-type")
@Tag( name = "View Type API", description = "All APIs related to View Type")
public class ViewTypeController {

    private final ViewTypeService viewTypeService;

    public ViewTypeController(ViewTypeService viewTypeService) {
        this.viewTypeService = viewTypeService;
    }

    @PostMapping
    public String save(@Valid @RequestBody ViewTypeVO vO) {
        return viewTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        viewTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ViewTypeUpdateVO vO) {
        viewTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ViewTypeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return viewTypeService.getById(id);
    }

    @GetMapping
    public Page<ViewType> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "name") String sortBy) {
        return viewTypeService.query(pageNo, pageSize, sortBy);
    }
}
