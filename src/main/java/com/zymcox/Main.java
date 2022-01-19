package com.zymcox;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(rom(1999));
        int[] lonely = {1, 1, 2, 5, 5, 9, 8, 9, 8};
        System.out.println(Lonely(lonely));
    }

    // Fakulteten av x
    private static long factorial(int x) {
        if (x < 2) return 1;
        long f = 2;
        for (int i = 3; i <= x; i++) f = f * i;
        return f;
    }

    // Romerska siffror
    @org.jetbrains.annotations.NotNull
    private static String rom(int x) {
        StringBuilder r = new StringBuilder();
        String[] rs = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] val = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        for (int i = val.length - 1; i >= 0; i--) {
            while (x - val[i] >= 0) {
                x = x - val[i];
                r.append(rs[i]);
            }
        }
        return r.toString();
    }

    // Det ensamma numret.
    private static int Lonely(int[] x) {
        int sum = 0;
        Arrays.sort(x);
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i] * (i % 2 == 0 ? 1 : -1);
        }
        return Math.abs(sum);
    }

}
