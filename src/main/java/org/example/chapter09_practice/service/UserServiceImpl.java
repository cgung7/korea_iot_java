package org.example.chapter09_practice.service;

import org.example.chapter09_practice.exception.UserNotFoundException;
import org.example.chapter09_practice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    // 사용자 배열 생성 - ArrayList
    private final List<User> userList = new ArrayList<>();

    // cf) CRUD
    // : 개발에서 데이터(model) 처리의 기본적인 4가지 기능을 나타냄
    // C(Create): 데이터 생성 (EX. 회원가입)
    // R(Read): 데이터 조회 (EX> 게시글 목록 보기)
    // U(Update): 데이터 수정 (EX. 내 정보 수정)
    // d(Delete): 데이터 삭제 (EX. 게시글 삭제)

    public UserServiceImpl() {

    }

    @Override
    public void addUser(User user) {
        userList.add(user);

    }

    @Override
    public User getUserById(int id) {
        // 사용자 리스트를 순회하여 해당 id와 일치하는 사용자가 있는 경우 반환
        // +) 해당 id의 사용자가 없는 경우 UserNotFoundException 발생

        for (User user: userList) {
            // 순회하고있는 사용자와 메서드 매개변수의 id가 일치하면 해당 사용자를 반환
            // : for문 내에서 return 키워드를 만나지 않고 전체 순회가 끝나면 예외 발생
            if (user.getId() == id) {
                return user;
            }
        }

        throw new UserNotFoundException("사용자 Id에 " + id + "값이 없습니다. (조회 실패)");
    }

    @Override
    public List<User> getAllUsers() {
//        return userList;
        return new ArrayList<>(userList); // 방어적 복사

        // cf) 방어적 복사
        // : 객체(배열, 클래스타입)의 내부 상태를 외부에 노출하지 않고 보호하기 위한 프로그래밍 기법
        // - 원본 ArrayList 객체의 요소를 복사하여 새로운 리스트(주소값)를 생성

    }

    @Override
    public void updateUserEmail(int id, String newEmail) {
        // 사용자 특정 id 값으로 사용자 정보 반환 || 예외 발생
        User user = getUserById(id);
        user.setEmail(newEmail);

    }

    @Override
    public void deleteUser(int id) {
        // 리스트 요소 제거
        // 리스트.remove(제거할요소);
        // cf) 제거 할 요소의 타입은 리스트의 요소 타입과 일치
        User userToDelete = null; // 전체 리스트에서 특정 id와 일치하는 사용자 정보를 담을 변수 선언

        for (User user: userList) {
            if (user.getId() == id) {
                userToDelete = user;
                break; // 현재 for 문만 종료(반복문의 종료)

                // cf) return: 메서드의 종료
            }

            // 삭제 가능
            userList.remove(userToDelete);
        }

        if (userToDelete == null) {
            // 삭제하고자 하는 id의 사용자가 없음
            throw new UserNotFoundException("사용자 ID에 " + id + "값이 없습니다. (삭제 실패)");
        }

    }

    @Override
    public List<User> findUsersByName(String name) {
        // 반환값을 담을 변수 선언 & 초기화
        List<User> result = new ArrayList<>();

        for (User user:userList) {
            // 전체 사용자를 순회하며 매개변수의 이름값고 일치하는 경우 result에 삽입
            if (user.getName().equals(name)) {
                // 문자열A.equals(문자열B) - 결과값을 boolean으로 반환
                result.add(user);
            }

        }
        return result;

    }
}
