package easy;

import java.awt.*;
import java.util.Arrays;

/**
 * 1037. Valid Boomerang
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
 *
 * A boomerang is a set of three points that are all distinct and not in a straight line.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: false
 *
 *
 * Constraints:
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 */
public class ValidBoomerang {
    public static void main(String[] args) {
//        Point[] input = new Point[]{
//                new Point(1, 1),
//                new Point(2, 3),
//                new Point(3, 2),
//        };

        Point[] input = new Point[]{
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
        };

        checkConstraints(input);

        Matrix matrixA = new Matrix(2, 2);
        Matrix matrixAa = new Matrix(2, 2);
        Matrix matrixAb = new Matrix(2, 2);

        matrixA.addCell(0, 0, input[0].getX());
        matrixA.addCell(0, 1, 1);
        matrixA.addCell(1, 0, input[1].getX());
        matrixA.addCell(1, 1, 1);

        matrixAa.addCell(0, 0, input[0].getY());
        matrixAa.addCell(0, 1, 1);
        matrixAa.addCell(1, 0, input[1].getY());
        matrixAa.addCell(1, 1, 1);

        matrixAb.addCell(0, 0, input[0].getX());
        matrixAb.addCell(0, 1, input[0].getY());
        matrixAb.addCell(1, 0, input[1].getX());
        matrixAb.addCell(1, 1, input[1].getY());

        System.out.println("input: " + Arrays.toString(input));
        System.out.println();

        System.out.println("Matrix A: ");
        System.out.println(matrixA);

        System.out.println("Matrix Aa: ");
        System.out.println(matrixAa);

        System.out.println("Matrix Ab: ");
        System.out.println(matrixAb);

        double delta = matrixA.calucateDelta();
        System.out.println("Delta: " + delta);

        if (delta == 0) {
            System.out.println("Wrong points!");
            return;
        }

        double deltaA = matrixAa.calucateDelta();
        System.out.println("DeltaA: " + deltaA);

        double deltaB = matrixAb.calucateDelta();
        System.out.println("DeltaB: " + deltaB);

        double a = deltaA / delta;
        double b = deltaB / delta;

        System.out.println();
        System.out.println("a = " + a + ", b = " + b);
        System.out.println();

        boolean isBomerang = input[2].getY() != a * input[2].getX() + b;

        System.out.println("isBomerang = " + isBomerang);
    }

    private static void checkConstraints(Point[] input) {
    }

    private static class Matrix {
        private int rows;
        private int cols;
        private double[][] cells;
        Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.cells = new double[rows][cols];
        }

        boolean addCell(int row, int col, double value) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return false;
            }
            this.cells[row][col] = value;

            return true;
        }

        double calucateDelta() {
            int row = 0;
            int col = 0;
            double diagonal1 = 1.0;
            while (row < rows && col < cols) {
                diagonal1 *= this.cells[row][col];
                row++;
                col++;
            }

            row = 0;
            col = cols - 1;
            double diagonal2 = 1.0;
            while (row < rows && col >= 0) {
                diagonal2 *= this.cells[row][col];
                row++;
                col--;
            }

            return diagonal1 - diagonal2;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sb.append(this.cells[i][j]) .append(" ");
                    if (j == cols - 1) {
                        sb.append("\n");
                    }
                }
            }

            return sb.toString();
        }
    }
}
