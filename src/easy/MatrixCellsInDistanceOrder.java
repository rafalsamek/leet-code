package easy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1030. Matrix Cells in Distance Order
 * Easy
 * Topics
 * Companies
 * You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
 *
 * Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.
 *
 * The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
 *
 *
 *
 * Example 1:
 *
 * Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (0, 0) to other cells are: [0,1]
 * Example 2:
 *
 * Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * Example 3:
 *
 * Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 *
 *
 * Constraints:
 *
 * 1 <= rows, cols <= 100
 * 0 <= rCenter < rows
 * 0 <= cCenter < cols
 */
public class MatrixCellsInDistanceOrder {
    private int rows;
    private int cols;
    private int rCenter;
    private int cCenter;

    public MatrixCellsInDistanceOrder(int rows, int cols, int rCenter, int cCenter) {
        this.rows = rows;
        this.cols = cols;
        this.rCenter = rCenter;
        this.cCenter = cCenter;
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder matrix = new MatrixCellsInDistanceOrder(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3])
        );

        matrix.checkConstraints();

        System.out.println(matrix.resolve());
    }


    private Matrix resolve() {
        Matrix resolution = new Matrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resolution.add(new MatrixCell(i, j));
            }
        }

        // sort by distance from (rCenter, cCenter) from smallest to greatest
        resolution.sort(
                Comparator.comparingInt(p -> calculateDistance(p, new MatrixCell(this.rCenter, this.cCenter)))
        );

        return resolution;
    }

    private int calculateDistance(MatrixCell p1, MatrixCell p2) {
        /**
         * |r1 - r2| + |c1 - c2|
         */
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private void checkConstraints() {
        /* Constraints:
         *
         * 1 <= rows, cols <= 100
         * 0 <= rCenter < rows
         * 0 <= cCenter < cols
         */
        if (this.rows < 1 || this.rows > 100 || this.cols < 1 || this.cols > 100) {
            throw new IllegalArgumentException(
                    "1 <= rows, cols <= 100"
            );
        }
        if (this.rCenter < 0 || this.rCenter >= this.rows) {
            throw new IllegalArgumentException(
                     "0 <= rCenter < rows"
            );
        }
        if (this.cCenter < 0 || this.cCenter >= this.cols) {
            throw new IllegalArgumentException(
                    "0 <= cCenter < cols"
            );
        }
    }

    private static class MatrixCell extends Point {
        MatrixCell(int row, int col) {
            super(row, col);
        }
        @Override
        public String toString() {
            return "[" + this.x + "," + this.y + "]";
        }
    }

    private static class Matrix extends ArrayList<MatrixCell> {
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (MatrixCell matrixCell : this) {
                builder.append(matrixCell.toString());
            }
            builder.append("]");

            return builder.toString();
        }
    }
}
