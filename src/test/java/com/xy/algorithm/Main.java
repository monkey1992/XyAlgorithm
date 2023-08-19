package com.xy.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class Main {

    private boolean sort(int a, int b) {
        return a - b > 0;
    }

    private int[] filterAndSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        int length = arr.length;
        if (length < 2) {
            return arr;
        }
        int[] result = new int[length];
        int k = 0;
        for (int i = 0; i < length; i++) {
            int item = arr[i];
            boolean containItem = false;
            for (int j = 0; j < length; j++) {
                if (result[j] == item) {
                    containItem = true;
                    break;
                }
            }
            if (!containItem) {
                result[k] = item;
                k++;
            }
        }
        // 4, 3, 2, 1

        // 3, 2, 1, 4 (3)
        // 2, 1, 3, 4 (2)
        // 1, 2, 3, 4 (1)

        // 冒泡排序
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    @Test
    public void main() {
        int[] arr = new int[]{1, 2, 3, 6, 9, 10, 12, 19, 17, 13, 10, 9, 6, 5, 1};
        int[] result = filterAndSort(arr);
        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(Arrays.stream(arr).distinct().sorted().toArray()));
    }

    class A {
        public String name;
    }

    class B {
        public A a;

        public B() {
            a = new A();
            a.name = "AAA";
        }
    }

    class C {
        public A a;

        public C(A a) {
            this.a = a;
        }
    }

    @Test
    public void testParams() {
        B b = new B();
        System.out.println("b.a: " + b.a.name);
        C c = new C(b.a);
        System.out.println("c.a: " + c.a.name);
        c.a.name = "123";
        System.out.println("b.a: " + b.a.name);
        System.out.println("c.a: " + c.a.name);
    }

    @Test
    public void testParams2() {
        A a = new A();
        a.name = "AAA";
        System.out.println("a: " + a + ", " + a.name);
        trans(a);
        System.out.println("a: " + a + ", " + a.name);
    }

    public void trans(A a) {
        System.out.println("trans a: " + a + ", " + a.name);
        a.name = "123";
        A a2 = new A();
        a2.name = "a222";
        a = a2;
        System.out.println("trans a: " + a + ", " + a.name);
    }
}
