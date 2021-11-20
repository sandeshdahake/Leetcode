package array;
/**
 * Check If N and Its Double Exist
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 *
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 *
 *
 * Hide Hint #1
 * Loop from i = 0 to arr.length, maintaining in a hashTable the array elements from [0, i - 1].
 * Hide Hint #2
 * On each step of the loop check if we have seen the element 2 * arr[i] so far or arr[i] / 2 was seen if arr[i] % 2 == 0.
 */


public class Check_If_N_and_Its_Double_Exist {

    public boolean checkIfExist(int[] arr) {
        int index = 0;
        int pointer= 0;
        int maxIndex = arr.length-1;
        boolean isExist = false;

        if(arr == null || maxIndex== 0){
            return false;
        }
        while(index <= maxIndex){

            if(pointer< maxIndex && index==pointer){
                pointer++;
                continue;
            }

            if(arr[index] == 2*arr[pointer]){
                isExist = true;
                break;
            }

            if(pointer == maxIndex && index==maxIndex){
                break;
            }
            if (pointer == maxIndex){
                pointer = 0;
                index++;
                continue;
            }

            pointer ++;
        }
        return isExist;
    }

}
