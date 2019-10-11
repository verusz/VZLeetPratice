package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main in = new Main();
        int test [][]  = {{0, 0},{1, 1}, {0,0}};

//        in.uniquePathsWithObstacles(test);

        System.out.println(in.uniquePathsWithObstacles(test));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 ) {
            if (obstacleGrid[0][0] == 0) {
                return 1;
            } else if (obstacleGrid[0][0] == 1) {
                return 0;
            }
        }

        int[][] result = obstacleGrid;

        int topLineResult = 1;

        for (int i = 0; i < obstacleGrid[0].length; i++ ) {
            if ( topLineResult == 0) {
                result[0][i] = -1;
                continue;
            }
            if (result[0][i] != 1) {
                result[0][i] = 1;
            } else {
                result[0][i] = -1;
                topLineResult = 0;
            }
        }
        int leftLineResult = 1;

        for (int j = 1; j < obstacleGrid.length; j++ ) {
            if ( leftLineResult == 0) {
                result[j][0] = -1;
                continue;
            }
            if (result[j][0] != 1) {
                result[j][0] = 1;
            } else {
                result[j][0] = -1;
                leftLineResult = 0;
            }
        }

        if (obstacleGrid.length > 1 && obstacleGrid[0].length > 1) {
            if ( result[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 || result[0][0] == -1) {
                return 0;
            }
            for (int j = 1; j < obstacleGrid[0].length; j++ ) {
                for (int i = 1; i < obstacleGrid.length; i++ ) {
                    if (result[i][j] == 1) {
                        result[i][j] = -1;
                    }
                    if (result[i][j] != -1) {
                        if (result[i - 1][j] == -1 && result[i][j - 1] == -1) {
                            result[i][j] = 0;
                        } else if (result[i][j - 1] == -1) {
                            result[i][j] = result[i - 1][j];
                        } else if (result[i - 1][j] == -1) {
                            result[i][j] = result[i][j - 1];
                        } else {
                            result[i][j] = result[i - 1][j] + result[i][j-1];
                        }
                    }
                }
            }
        } else {
            return Math.min(topLineResult, leftLineResult);
        }



        return result[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
