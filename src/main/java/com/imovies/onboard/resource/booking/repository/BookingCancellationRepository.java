package com.imovies.onboard.resource.booking.repository;

import com.imovies.onboard.resource.booking.entity.BookingCancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookingCancellationRepository extends JpaRepository<BookingCancellation, Integer>, JpaSpecificationExecutor<BookingCancellation> {

}