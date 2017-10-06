package com.ehsaniara.dataStructureSample;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * <p>
 * Minimum time required to rot all oranges
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 * <p>
 * 0: Empty cell
 * <p>
 * 1: Cells have fresh oranges
 * <p>
 * 2: Cells have rotten oranges
 * So we have to determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange then simply return -1.
 * <p>
 * Examples:
 * <p>
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {1, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges can become rotten in 2 time frames.
 * <p>
 * <p>
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {0, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges cannot be rotten.
 */
public class RotOrange {
    int[][] box;

    RotOrange(int[][] box) {
        this.box = box;
    }

    void calculate() {
        int total = 0, rottenNo = 0, preRottenNo = -1, attempt = 0, x = box.length, y = box[0].length;
        while (true) {
            total = 0;
            rottenNo = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (box[i][j] > 0)
                        total++;
                    if (box[i][j] == 2)
                        rottenNo++;
                    //System.out.println("i=:" + i + " j=:" + j + " -> " + box[i][j]);

                    if (box[i][j] == 2) {
                        if (i - 1 > -1 && i - 1 < x && box[i - 1][j] > 0)
                            box[i - 1][j] = 2;
                        if (i + 1 > -1 && i + 1 < x && box[i + 1][j] > 0)
                            box[i + 1][j] = 2;
                        if (j - 1 > -1 && j - 1 < y && box[i][j - 1] > 0)
                            box[i][j - 1] = 2;
                        if (j + 1 > -1 && j + 1 < y && box[i][j + 1] > 0)
                            box[i][j + 1] = 2;
                    }
                }
            }
            if (preRottenNo != rottenNo) {
                preRottenNo = rottenNo;
                attempt++;
            } else
                break;

        }

        System.out.println("There are " + total + " oranges all in total, Rotten:" + preRottenNo + " in " + attempt + " times.");
        if (total != preRottenNo) {
            System.out.println("All oranges cannot be rotten.");
        }

    }

    public static void main(String[] args) {

        int[][] box1 = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        new RotOrange(box1).calculate();

        System.out.println("----------------------------");

        int[][] box2 = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        new RotOrange(box2).calculate();

    }

}
