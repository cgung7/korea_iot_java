package org.example.chapter00;

public class Note3 {
    public static class B0 {
        public int v;
        public B0(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        B0 a = new B0(1);
        /// v == 1
        B0 b = new B0(2);
        /// v == 2
        B0 c = new B0(3);
        /// v == 3
        B0[] arr = { a, b, c }; /// { 1. 2. 3 }

        B0 t = arr[0]; /// t = a (v == 1)
        arr[0] = arr[2]; /// arr[0] = c (v == 3)
        arr[2] = t; /// arr[2] = a (v == 1)

        arr[1].v = arr[0].v; /// arr[1] == b // b.v = 3

        /// a.v(1) + "a" + b.v(3) + "b" + 3
        /// 1a3b3
        System.out.println(a.v + "a" + b.v + "b" + c.v);
    }
}
