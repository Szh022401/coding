 /*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    // 初始检查：如果字典为 null 或者第一个元素就比目标值大，则目标值不在数组中
    if(dict == null || dict.get(0) > target){
      return -1;
    }
    int left = 0;
    int right = 1;
    // 找到可能包含目标值的区间上界
    while(dict.get(right) != null && dict.get(right) < target){
      left = right;// 将左指针移动到当前右指针的位置
      right *=2;// 将右指针加倍以指数方式扩大搜索范围
    }
    while(left <= right){
      int mid = left + (right - left) /2;
       // 检查中间值是否超出数组范围或者大于目标值
      if(dict.get(mid) == null || dict.get(mid) > target){
        right = mid - 1; // 将搜索区间上界左移
      }else if(dict.get(mid) < target){
        left = mid  + 1;// 将搜索区间下界右移
      }else{
        return mid;
      }

    }
    return -1;
  }
}
