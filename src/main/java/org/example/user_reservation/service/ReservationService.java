package org.example.user_reservation.service;

import org.example.user_reservation.dto.ReservationResponseDto;
import org.example.user_reservation.entity.Reservation;

import java.util.List;

public interface ReservationService {
    // 예약 등록, 조회, 취소
    void createReservation(String userId);
    List<ReservationResponseDto> getReservationByUserId(String userId);
    void cancelReservation(Long reservationId);
}
