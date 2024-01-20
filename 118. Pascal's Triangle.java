/*
118. Pascal's Triangle
Easy
12.3K
396
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],
        [1,1]
,      [1,2,1],
      [1,3,3,1],
      [1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();//每一个row 都要放进去
        List <Integer> firstRow = new ArrayList<>();//第一个
        firstRow.add(1);//第一个肯定是1
        ans.add(firstRow);//把第一个放进去
        for(int i = 1 ; i<numRows;i++){//已经把第一个放进去了，，到numRows结束是因为最后一个是1 后面回加进去
            List <Integer> preRow = ans.get(i-1);//等到上一层的值
            List <Integer> curRow = new ArrayList<>();//当前row 的值
            curRow.add(1);//每层第一个肯定是1
            for(int j = 1 ; j<i ;j++){//已经把第一层放进去了，到i结束是因为最后一个是1 后面回加进去
                curRow.add(preRow.get(j)+ preRow.get(j-1));//上一层的前一个加后面一个
            }
             curRow.add(1);最后也是1

              ans.add(curRow);
        }
        return ans;
    }
}
