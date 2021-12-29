package ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();

        int LEFT = 0 ;
        int RIGHT = col -1 ;
        int TOP = 0 ;
        int DOWN = row -1 ;
        int d=0;

        while(LEFT <= RIGHT && TOP <= DOWN){
            switch(d){
                case 0 -> {
                    for(int j=LEFT ; j<= RIGHT ; j++ ){
                        ans.add(matrix[TOP][j]);
                    }
                    TOP ++ ;
                }
                case 1 -> {
                    for(int i=TOP ; i<= DOWN ; i++ ){
                        ans.add(matrix[i][RIGHT]);
                    }
                    RIGHT -- ;
                }
                case 2 -> {
                    for(int j=RIGHT ; j>= LEFT ; j-- ){
                        ans.add(matrix[DOWN][j]);
                    }
                    DOWN -- ;
                }
                case 3 -> {
                    for(int i=DOWN ; i>= TOP ; i-- ){
                        ans.add(matrix[i][LEFT]);
                    }
                    LEFT ++ ;
                }
            }
            d = (d+1)%4;
        }
        return ans;
    }
}
//. L  -> R   constant : TOP
// T -> D. constant : RIGHT
// R-> L constant : DOWN
// D -> T contant : LEFT
