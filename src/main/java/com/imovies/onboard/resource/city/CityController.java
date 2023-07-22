package com.imovies.onboard.resource.city;

import com.imovies.onboard.resource.city.vo.CityUpdateVO;
import com.imovies.onboard.resource.city.vo.CityVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/city")
@Tag( name = "City API", description = "All APIs related to City")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public String save(@Valid @RequestBody CityVO vO) {
        return cityService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        cityService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CityUpdateVO vO) {
        cityService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CityDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cityService.getById(id);
    }

    @GetMapping
    public List<CityDTO> query(@RequestParam(defaultValue = "0") Integer pageNo,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "id") String sortBy) {
        return cityService.query(pageNo, pageSize, sortBy);
    }
}
