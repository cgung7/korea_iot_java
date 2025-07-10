package org.example.chapter02;


public class C_GUGUDAN {
    public static void main(String[] args) {

        for(int i = 0; i < 8; i++) {
            int dan = i + 2;
            // 맨위는 단 조건 {구구단은 2단 부터 9단인 조건, 2단부터 시작, for in for 맨 위에 작성}
            if (dan > 5) {
                System.out.print("❤️");
            } else {
                System.out.print("👍");
            }
            // for 안에 if 넣으면 for 앞에 if문이 들어간다?
            System.out.println("[" + dan + "단]");

            for(int j = 0; j < 9; j++) {
                int number = j + 1;
                // 아래는 곱할 수를 작성, dan * number(1부터 9까지), 위에 번호 갱신되면 다시 1부터 시작
                System.out.println(dan + "X" + number + "=" + dan * number);
            }
        }

    }
}
