package org.example.chapter16;

/*
    === ENUM 메서드 오버라이딩 ===
    : ENUM은 상수별 다른 동작 정의
        - abstract 메서드를 선언하고 상수별 구현 가능

 */

enum Operation {
    // enum은 상수값 정의가 먼저 (최상단)
    ADD {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    }
    ; // 상수값 종료 세미콜론


    public abstract int apply(int x, int y);

}

enum Season {
    SPRING("봄"),
    SUMMER("여름"),
    AUTUMN("가을"),
    WINTER("겨울");

    private final String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
}

public class C_Enum {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(3, 5)); // 8
        System.out.println(Operation.SUBTRACT.apply(3, 5)); // -2


        Season season = Season.SUMMER;


        switch (season) {
            case SPRING -> System.out.println("봄봄봄");

            case SUMMER -> System.out.println("여름여름여름");

            case AUTUMN -> System.out.println("가을가을가을");

            case WINTER -> System.out.println("겨울겨울겨울");

        }
        System.out.println(season.getSeasonName() + "이 왔어요!");

        if (season == Season.SPRING) {
            System.out.print(season.getSeasonName() + "이 왔어요 따뜻해요");
        } else if (season == Season.SUMMER) {
            System.out.print(season.getSeasonName() + "이 왔어요. 너무 더워요.");
        } else if (season == Season.AUTUMN) {
            System.out.print(season.getSeasonName() + "이 왔어요. 천고마비의 계절이에요!");
        } else {
            System.out.print(season.getSeasonName() + "이에요. 추워요.");
        }
    }
}
