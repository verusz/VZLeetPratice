package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        Main in = new Main();

        int[][] matrix = {{0,0,0},{0,1,1},{1,1,1}};

        in.updateMatrix(matrix);
    }

    public int[][] updateMatrix(int[][] matrix) {
        int l = matrix[0].length;
        int h = matrix.length;

        int[][] result = new int[h][l];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = bfs(new Coordinate(j, i), matrix);
                }
            }
        }

        return result;
    }

    private int bfs(Coordinate coor, int[][] martrix) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coor);

        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};

        int times = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            times = times + 1;
            for (int i = 0; i < size; i++) {
                Coordinate location = queue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    Coordinate position = new Coordinate(location.x + directionX[direction], location.y + directionY[direction]);
                    if (!inBound(position, martrix)) {
                        continue;
                    }
                    if (martrix[position.y][position.x] == 1) {
                        queue.offer(position);
                    } else if (martrix[position.y][position.x] == 0) {
                        return times;
                    }
                }
            }
        }
        return 0;
    }

    private boolean inBound(Coordinate coor, int[][] matrix) {
        int l = matrix[0].length;
        int h = matrix.length;
        if (coor.x < 0 || coor.x >= l) {
            return false;
        }

        if (coor.y < 0 || coor.y >= h) {
            return false;
        }

        return true;
    }

}
