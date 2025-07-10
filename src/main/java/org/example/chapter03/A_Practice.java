package org.example.chapter03;

import java.util.ArrayList;

public class A_Practice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(20);
        //                                              크기 20 설정

        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }
        System.out.println("원본 리스트: " + list);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) % 2 != 0) {
                list.remove(i);
                i--;
            }

        }
        System.out.println("짝수 리스트: " + list);
    }
}
