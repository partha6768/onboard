package com.imovies.onboard.resource.seattype;

import com.imovies.onboard.resource.seattype.vo.SeatTypeUpdateVO;
import com.imovies.onboard.resource.seattype.vo.SeatTypeVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/seat-type")
@Tag( name = "Seat Type API", description = "All APIs related to Seat Type")
public class SeatTypeController {

    private final SeatTypeService seatTypeService;

    public SeatTypeController(SeatTypeService seatTypeService) {
        this.seatTypeService = seatTypeService;
    }

    @PostMapping
    public String save(@Valid @RequestBody SeatTypeVO vO) {
        return seatTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        seatTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody SeatTypeUpdateVO vO) {
        seatTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SeatTypeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return seatTypeService.getById(id);
    }

    @GetMapping
    public Page<SeatType> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "name") String sortBy) {
        return seatTypeService.query(pageNo, pageSize, sortBy);
    }
}
