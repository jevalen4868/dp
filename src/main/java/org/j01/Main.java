package org.j01;

import org.j01.knapsack.KnapsackSolution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int n = 4;
        int cap = 7;
        int[] w = {0, 1, 3, 4, 5};
        int[] v = {0, 1, 4, 5, 7};
        KnapsackSolution knSol = new KnapsackSolution(4, cap, w, v);
        knSol.solve();
    }
}