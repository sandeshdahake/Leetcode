package ds.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Set_Matrix_Zero {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        Set<Integer> rowset = new HashSet();
        Set<Integer> colset = new HashSet();

        for(int i = 0 ; i< rowLength; i++){
            for(int j=0; j< colLength; j++){
                if(matrix[i][j] == 0){
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }

        for(int i = 0 ; i< rowLength; i++){
            for(int j=0; j< colLength; j++){
                if(rowset.contains(i) || colset.contains(j) ){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// https://leetcode.com/problems/set-matrix-zeroes/discuss/1614875/Java-o(1)-solution-(easy-to-read)
