package com.imovies.onboard.resource.show.repository;

import com.imovies.onboard.resource.show.entity.ShowCalendarSeatBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ShowCalendarSeatBookingRepository extends JpaRepository<ShowCalendarSeatBooking, Integer>, JpaSpecificationExecutor<ShowCalendarSeatBooking> {

    @Modifying
    @Query(value = "update show_calendar_seat_booking set seat_status=:status where booking_id=:bookingId",nativeQuery = true)
    int updateStatusByBookingId(@Param("bookingId") Integer bookingId, @Param("status") String status);

    @Query("select s from ShowCalendarSeatBooking s where s.showCalendarId in(:showCalendarIds) and s.seatStatus = 'RESERVED'")
    Set<ShowCalendarSeatBooking> getReservedSeatIdsByShowCalendarByShowCalendarIds(@Param("showCalendarIds") Set<Integer> showCalendarIds);
}