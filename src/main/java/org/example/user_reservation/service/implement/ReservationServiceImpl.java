package org.example.user_reservation.service.implement;

import org.example.user_reservation.dto.ReservationResponseDto;
import org.example.user_reservation.entity.Reservation;
import org.example.user_reservation.entity.User;
import org.example.user_reservation.repository.ReservationRepository;
import org.example.user_reservation.repository.UserRepository;
import org.example.user_reservation.service.ReservationService;
import org.example.user_reservation.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    // 사용자 비즈니스 로직 (사용자 저장소는 사용자 Service 에서만 접근)
    private final UserService userServiceImpl;
    private Long reservationIdSequence = 1L; // 예약번호(고유값)

    public ReservationServiceImpl(UserService userServiceImpl) {
        this.reservationRepository = new ReservationRepository();
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    public void cancelReservation(Long reservationId) {
        Optional<Reservation> optionalReservation =reservationRepository.findById(reservationId);

        if (optionalReservation.isEmpty()) {
            System.out.println("해당 예약 ID의 정보를 찾을 수 없습니다. 다시 시도해주세요.");
            return;
        }

        Reservation reservation = optionalReservation.get();

        if (!canCancel(reservation)) {
            System.out.println("취소 가능한 예약이 아닙니다.");
            return;
        }

        reservation.cancel(); // 실제 상태 변경은 Entity가 담당

    }

    public boolean canCancel(Reservation reservation) {
        // 예약 취소 정책 (예약일 하루 전까지만 가능)
        Date now = new Date();

        // A.after(Date): 인자값이 A보다 뒤인지 비교하여 boolean 반환
        return reservation.getReservationTime().after(now);
    }

    @Override
    public void createReservation(String userId) {
        // 로그인 된 사용자만 예약 가능
        if (userServiceImpl.isLoggedIn()) {
            System.out.println("로그인이 필요한 기능입니다.");
            return;
        }

        // 실제 사용자 ID와 일치하는지 확인
        Optional<User> optionalUser = userServiceImpl.findUserById(userId);
        if (optionalUser.isEmpty()) {
            System.out.println("존재하지 않는 사용자입니다. 예약할 수 없습니다.");
            return;
        }

            // 로그인 O
            Date reservationTime = new Date();
            Reservation newReservation = new Reservation(reservationIdSequence++, userId, reservationTime);
            reservationRepository.save(newReservation);
            System.out.println("예약 완료");

    }

    @Override
    public List<ReservationResponseDto> getReservationByUserId(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);

        if (reservations.isEmpty()) {
            System.out.println(userId + "님의 예약이 없습니다.");
        }
        List<ReservationResponseDto> dtos = reservations.stream()
                .map(res -> new ReservationResponseDto(
                        res.getReservationId(),
                        res.getUserId(),
                        res.getReservationTime(),
                        res.isActive() ? "예약 중 " : "예약 취소"
                ))
                .collect(Collectors.toList());

        return dtos;
    }
}
