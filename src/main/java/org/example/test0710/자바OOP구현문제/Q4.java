package org.example.test0710.자바OOP구현문제;

/*
### Q4. 인터페이스 구현

> Playable이라는 인터페이스를 만든다.

play() 메서드를 가진다.Piano, Guitar 클래스는 Playable을 구현하고 play() 메서드에서 각각 다른 악기 소리를 출력한다.

Main에서 다형성을 통해 모든 악기를 재생하라.
>
 */

interface Playable {
     default void play() {
        System.out.println("악기는 소리를 냅니다.");
    }
}

class Piano implements Playable {

    @Override
    public void play() {
        System.out.println("도래미파솔");
    }
}

class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("딩딩딩");
    }
}

public class Q4 {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Guitar guitar = new Guitar();
        guitar.play();
        piano.play();
    }

}
