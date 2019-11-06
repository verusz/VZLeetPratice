package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Coordinate {
        int x,y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main in = new Main();

        System.out.println(in.numIslands(new char[][]{{'1','0'},{'1','0'}}));
    }

    public int numIslands(char[][] grid) {

        //bfs
        Queue<Coordinate> queue = new LinkedList<>();
        int num = 0;

        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[j][i] == '1') {
                    queue.offer(new Coordinate(i, j));
                    grid[j][i] = '0';

                    num = num + 1;

                    int[] directionX = {0, 1, -1, 0};
                    int[] directionY = {1, 0, 0, -1};
                    while (!queue.isEmpty()) {
                        Coordinate coor = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            Coordinate position = new Coordinate(directionX[k] + coor.x, directionY[k] + coor.y);
                            if (!inBound(position, grid) || grid[position.y][position.x] == '0') {
                                continue;
                            }
                            grid[position.y][position.x] = '0';
                            queue.offer(position);
                        }
                    }
                }
            }
        }
        return num;
    }

    public boolean inBound(Coordinate coor, char[][] grid) {
        if (coor.x < 0 || coor.x > grid[0].length - 1) {
            return false;
        }

        if (coor.y < 0 || coor.y > grid.length - 1) {
            return false;
        }

        return true;
    }
}
