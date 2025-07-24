package org.example.user_reservation.repository;

import org.example.user_reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    // 예약 등록(CREATE),
    // : DB에 새로운 예약을 저장
    // +) 요청(예약 정보), 응답(X)
    public void save(Reservation reservation) {
        reservations.add(reservation);

    }

    // 조회(READ)
    // : 단건 예약에 대한 조회 (reservationId을 사용)
    // +) 요청(예약 고유번호), 응답(예약 정보)
    public Optional<Reservation> findById(Long reservationId) {
        return reservations.stream()
                .filter(res -> res.getReservationId().equals(reservationId))
                .findFirst(); // 검색된 조건에 일치하는 요소 중 제일 첫 번째 요소를 Optional로 반환

    }
    // : 예약자 정보와 일치하는 예약을 조회 (userId를 사용)
    // +) 요청(사용자 Id), 응답(예약 정보 리스트)
    public List<Reservation> findByUserId(String userId) {
        return reservations.stream()
                // 해당 예약자의 리스트 중 예약이 유효한 목록(isActive)만 확인
                .filter(res -> res.getUserId().equals(userId) && res.isActive())
                .collect(Collectors.toList());

    }

    // 취소(UPDATE)
    // - (현재 프로젝트에서는 DB 없이 객체 내부의 상태만 변경 - 취소 자체의 로직 X)


}
