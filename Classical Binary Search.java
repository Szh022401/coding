/* https://app.laicode.io/app/problem/14?plan=3
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
Examples

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
*/
public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here、
    if(array == null || array.length == 0){
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left <= right){
      int mid = left + (right - left) /2;// potential integer overflow issues 
      if(array[mid] == target){
        return mid;
      }else if(array[mid] < target){
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }
    return -1;
  }
}
Time Complexity: O(log⁡n)
Space Complexity: O(1)
/*
Consider left = 2,000,000,000 and right = 2,000,000,002:
Using (left + right) / 2 would calculate (4,000,000,002) / 2, 
which doesn’t overflow in this case, but if left and right were closer to the maximum int value,
this could cause an overflow.
*/
