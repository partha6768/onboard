package com.imovies.onboard.resource.usertype;

import com.imovies.onboard.resource.usertype.vo.UserTypeUpdateVO;
import com.imovies.onboard.resource.usertype.vo.UserTypeVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/user-type")
@Tag( name = "User Type API", description = "All APIs related to User Type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping
    public String save(@Valid @RequestBody UserTypeVO vO) {
        return userTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        userTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UserTypeUpdateVO vO) {
        userTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserTypeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return userTypeService.getById(id);
    }

    @GetMapping
    public Page<UserType> query(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "name") String sortBy) {
        return userTypeService.query(pageNo, pageSize, sortBy);
    }
}
