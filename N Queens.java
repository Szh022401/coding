public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    help(result,cur,n);
    return result;

  }
  private void help(List<List<Integer>> result,List<Integer>cur,int n ){
    if(cur.size() == n){
      result.add(new ArrayList<Integer>(cur));
    }
    for(int i = 0; i < n;i++){
      if(vaild(cur,i)){
        cur.add(i);
        help(result,cur,n);
        cur.remove(cur.size() -1);
      }
    }
  }
  private boolean vaild(List<Integer>cur,int i){
    int row = cur.size();
    for(int j = 0 ;j < row;j++){
      int col = cur.get(j);
      if(i == col || Math.abs(col-i) == Math.abs(row - j)){
        return false;
      }
    }
    return true;
  }
}
