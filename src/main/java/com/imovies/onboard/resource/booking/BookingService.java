package com.imovies.onboard.resource.booking;

import com.imovies.onboard.constants.OnboardingConstants.SeatStatus;
import com.imovies.onboard.constants.OnboardingConstants.RefundStatus;
import com.imovies.onboard.constants.OnboardingConstants.BookingStatus;
import com.imovies.onboard.resource.booking.dto.BookingDTO;
import com.imovies.onboard.resource.booking.entity.Booking;
import com.imovies.onboard.resource.booking.entity.BookingCancellation;
import com.imovies.onboard.resource.booking.repository.BookingCancellationRepository;
import com.imovies.onboard.resource.booking.repository.BookingRepository;
import com.imovies.onboard.resource.booking.vo.BookingStatusUpdateVO;
import com.imovies.onboard.resource.booking.vo.BookingUpdateVO;
import com.imovies.onboard.resource.booking.vo.BookingVO;
import com.imovies.onboard.resource.show.entity.ShowCalendarSeatBooking;
import com.imovies.onboard.resource.show.repository.ShowCalendarSeatBookingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowCalendarSeatBookingRepository showCalendarSeatBookingRepository;
    private final BookingCancellationRepository bookingCancellationRepository;

    public BookingService(BookingRepository bookingRepository, ShowCalendarSeatBookingRepository showCalendarSeatBookingRepository, BookingCancellationRepository bookingCancellationRepository) {
        this.bookingRepository = bookingRepository;
        this.showCalendarSeatBookingRepository = showCalendarSeatBookingRepository;
        this.bookingCancellationRepository = bookingCancellationRepository;
    }

    @Transactional
    public Integer save(BookingVO bookingVO) {
        //Make an Entry to Booking as Pending
        Booking bookingEntity = new Booking();
        BeanUtils.copyProperties(bookingVO, bookingEntity);
        bookingEntity.setStatus(BookingStatus.PENDING.toString());
        bookingEntity = bookingRepository.save(bookingEntity);

        //Make an entry to Seat Reservation as Pending
        Booking finalBookingEntity = bookingEntity;
        Set<ShowCalendarSeatBooking> showCalendarSeatBookings = bookingVO.getSeatIds()
                .stream()
                .map(seatId -> {
                    return ShowCalendarSeatBooking.builder()
                            .bookingId(finalBookingEntity.getId())
                            .seatId(seatId)
                            .seatStatus(finalBookingEntity.getStatus())
                            .showCalendarId(finalBookingEntity.getShowCalendarId())
                            .build();
                }).collect(Collectors.toSet());
        showCalendarSeatBookingRepository.saveAll(showCalendarSeatBookings);
        return bookingEntity.getId();
    }

    public void delete(Integer id) {
        bookingRepository.deleteById(id);
    }

    public void update(Integer id, BookingUpdateVO vO) {
        Booking bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bookingRepository.save(bean);
    }

    @Transactional
    public void updateStatus(Integer id, BookingStatusUpdateVO vO) {
        Booking bean = requireOne(id);
        bean.setStatus(vO.getStatus());
        bean.setPaymentTransactionId(vO.getPaymentTransactionId());
        bookingRepository.save(bean);

        String seatReservationStatus = vO.getStatus().equalsIgnoreCase(BookingStatus.SUCCESS.toString())?
                SeatStatus.RESERVED.toString() : SeatStatus.CANCELLED.toString();
        showCalendarSeatBookingRepository.updateStatusByBookingId(bean.getId(),seatReservationStatus);
    }


    @Transactional
    public void cancelBooking(Integer id) {
        Booking bookingEntity = requireOne(id);
        BookingCancellation bookingCancellation = BookingCancellation.builder()
                .bookingId(bookingEntity.getId())
                .totalPrice(bookingEntity.getTotalPrice())
                .cancellationCharges(bookingEntity.getTotalPrice() / 2)
                .refundAmount(bookingEntity.getTotalPrice() / 2)
                .refundStatus(RefundStatus.INITIATED.name())
                .userId(bookingEntity.getUserId()) // We should get UserId from Context to understand who initiated cancellation User or Support Staff
                .build();
        bookingCancellationRepository.save(bookingCancellation);
        bookingEntity.setStatus(BookingStatus.CANCELLED.name());
        bookingRepository.save(bookingEntity);
        showCalendarSeatBookingRepository.updateStatusByBookingId(bookingEntity.getId(),SeatStatus.CANCELLED.name());
    }

    public BookingDTO getById(Integer id) {
        Booking original = requireOne(id);
        return toDTO(original);
    }

    public Set<Booking> getByUserId(String userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    public Page<Booking> query(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return bookingRepository.findAll(pageable);
    }

    private BookingDTO toDTO(Booking original) {
        BookingDTO bean = new BookingDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Booking requireOne(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
