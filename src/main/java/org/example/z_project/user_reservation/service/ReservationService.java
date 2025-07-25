package org.example.z_project.user_reservation.service;

import org.example.z_project.user_reservation.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    // 예약 등록, 조회, 취소
    void createReservation(String userId);
    List<ReservationResponseDto> getReservationByUserId(String userId);
    void cancelReservation(Long reservationId);
}
