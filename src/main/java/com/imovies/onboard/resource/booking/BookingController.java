package com.imovies.onboard.resource.booking;

import com.imovies.onboard.resource.booking.BookingService;
import com.imovies.onboard.resource.booking.dto.BookingDTO;
import com.imovies.onboard.resource.booking.entity.Booking;
import com.imovies.onboard.resource.booking.vo.BookingQueryVO;
import com.imovies.onboard.resource.booking.vo.BookingStatusUpdateVO;
import com.imovies.onboard.resource.booking.vo.BookingUpdateVO;
import com.imovies.onboard.resource.booking.vo.BookingVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/booking")
@Tag( name = "Booking API", description = "All APIs related to Booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public String save(@Valid @RequestBody BookingVO vO) {
        return bookingService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        bookingService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody BookingUpdateVO vO) {
        bookingService.update(id, vO);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody BookingStatusUpdateVO vO) {
        bookingService.updateStatus(id, vO);
    }

    @PutMapping("/{id}/cancel")
    public void cancelBooking(@Valid @NotNull @PathVariable("id") Integer id) {
        bookingService.cancelBooking(id);
    }

    @GetMapping("/{id}")
    public BookingDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return bookingService.getById(id);
    }

    @GetMapping
    public Page<Booking> query(@RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "name") String sortBy) {
        return bookingService.query(pageNo, pageSize, sortBy);
    }
}
