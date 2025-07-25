package org.example.z_project.user_reservation.service.implement;

import org.example.z_project.user_reservation.dto.UserLoginRequestDto;
import org.example.z_project.user_reservation.dto.UserRegisterRequestDto;
import org.example.z_project.user_reservation.entity.User;
import org.example.z_project.user_reservation.repository.UserRepository;
import org.example.z_project.user_reservation.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User loggedUser; // 로그인 된 사용자 정보를 저장하는 필드

    // 오류 수정을 위해 생성자 생성으로 초기화 진행
    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    @Override
    public void registerUser(UserRegisterRequestDto dto) {
        // dto 내부의 userId 값을 사용하여 기존의 데이터와 비교
        Optional<User> optionalUser = userRepository.findByUserId(dto.getUserId());

        // cf) 옵셔널데이터.get()
        // : Optional 내부의 데이터를 반환, 데이터가 없을 경우 null 반환
        // - 값이 존재하지 않을 때 NoSuchElementException 예외 발생
        Optional<String> optional = Optional.empty();
//        optional.get(); // NoSuchElementException

        // cf) .isPresent(), isEmpty()
        if (optionalUser. isPresent()) {
            // 해당 id의 유저가 존재 - 회원가입 불가
            System.out.println("해당 ID의 유저가 존재합니다. 다시 시도해주세요.");
            return; // 메서드 종료
        }

        // 회원가입 정상 로직 실행
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();
        // 비밀번호, 비밀번호 확인이 일치 하지 않음 - 회원가입 불가
        if (!password.equals(passwordCheck)) {
            System.out.println(" 비밀번호와 비말번호 확인이 일치하지 않습니다. 다시 시도해주세요.");
        }

        User newUser = new User(dto.getUserId(), password, dto.getName(), dto.getEmail());
        userRepository.save(newUser);
        System.out.println("사용자 회원가입 완료: " + dto.getName());

    }

    @Override
    public boolean isLoggedIn() {
        boolean result = loggedUser != null; // 불일치 여부 확인 연산자
        // 로그인 중: true, 로그인 X: false
        return result;
    }

    @Override
    public void login(UserLoginRequestDto dto) {
        String userId = dto.getUserId();
        String password = dto.getPassword();

        // ifPresentOrElse(a, b);
        // : 정보가 존재하는 경우 a 로직 실행, 존재하지 않을 경구 b 로직 실행
        userRepository.findByUserId(userId).ifPresentOrElse(user -> {
            // 데이터가 있는경우
            // user 값 내부의 password 값과 dto 요청 값 내부의 비밀번호 값의 일치 여부 확인
            if (user.getPassword().equals(password)) {
                loggedUser = user;
                System.out.println("로그인 성공: " + user.getName());
            } else {
                System.out.println("로그인 실패 : 비밀번호가 일치하지 않습니다.");
            }
        }, () -> System.out.println("로그인 실패: 사용자의 ID를 찾을 수 없습니다."));

    }

    @Override
    public void logout() {
        if (loggedUser != null) {
            // 로그인 중
            System.out.println("로그아웃 성공:" + loggedUser.getName());
            loggedUser = null;
        }else {
            System.out.println("로그인 상태가 아닙니다. 로그아웃 할 수 없습니다.");
        }

    }

    @Override
    public Optional<User> findUserById(String userId) {
        return userRepository.findByUserId(userId);
    }
}
