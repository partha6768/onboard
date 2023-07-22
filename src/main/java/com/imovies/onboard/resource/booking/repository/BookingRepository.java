package com.imovies.onboard.resource.booking.repository;

import com.imovies.onboard.resource.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface BookingRepository extends JpaRepository<Booking, Integer>, JpaSpecificationExecutor<Booking> {

    @Query("select b from Booking b where b.userId =:userId order by b.updatedTs desc")
    Set<Booking> findAllByUserId(@Param("userId") String userId);
}