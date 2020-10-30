import java.util.*;

import javax.swing.RowFilter;

import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int Nbchemins(int[][] tab, int M, int N, int i, int j){
        //correspond tu ne peut pas aller
        if ((i >= M || j >= N) || tab[i][j] == 1){
            return 0;
        }
        //les cases final ont on commence par la fin pour arriver au debut
        if (i == M-1 && j == N-1){
            //on l'a nomme -1 pour eviter les conflit avec les cases non valide
            return -1;
        }

        //relation de recurrence
        tab[i][j] = Nbchemins(tab, M, N, i, j+1) + Nbchemins(tab, M, N, i+1, j);
        return tab[i][j];

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        //creation d'un tableau a 2 dimensions

        int[][] tab;
        //System.out.println(N+" "+M);

        tab = new int[M][N];

        if (in.hasNextLine()) {
            in.nextLine();
        }

        //insertion des valeur dans le tableau a 2 dimension
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();

            for (int j = 0; j < N; j++) {
                char s = ROW.charAt(j);
                tab[i][j] = Character.getNumericValue(s);


            }
        }

        Nbchemins(tab, M, N, 0, 0);
        System.out.println(Math.abs(tab[0][0]));



        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }
}
