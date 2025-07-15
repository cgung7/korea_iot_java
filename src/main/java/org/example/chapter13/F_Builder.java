package org.example.chapter13;

/*
    == 빌더로 게임 케릭터 생성 ==
    1) 필수: 이름(String), 분류(String)
    2) 선택: 스킬(String), 아이템(String)
*/
class GameCharacter {
    private final String name;
    private final String sort;

    private final String skill;
    private final String item;

    // 1) 빌더 클래스 (내부클래스)
    public static class Builder {
        // 생성자에게 받음(super)
        private final String name;
        private final String sort;

        // 기본값이 지정되어 있음
        private String skill = "Basic Attack";
        private String item = "None";

        public Builder(String name, String sort) {
            this.name = name;
            this.sort = sort;
        }

        // 선택 필드에 대한 할당 메서드(필드명 그자체의 메서드명을 가짐)
        public Builder skill(String skill) {
            this.skill = skill;
            return this;
        }

        public Builder item(String item) {
            this.item = item;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }
    }

    // 생성자
    // Builder 객체를 받아 내부 필드를 생성
    public GameCharacter(Builder builder) {
        this.name = builder.name;
        this.sort = builder.sort;
        this.skill = builder.skill;
        this.item = builder.item;
    }
}

// 객체 생성
public class F_Builder {
    public static void main(String[] args) {
        GameCharacter pororo = new GameCharacter.Builder("뽀로로","팽귄")
                .skill("크롱놀리기")
                .item("안경")
                .build();

        GameCharacter loopy = new GameCharacter.Builder("루피","비버")
                .skill("정색")
                .item("잔망루피")
                .build();
    }
}
