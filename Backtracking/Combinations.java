/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (k > n) { return res; }
    backtrack(n, k, 1, new ArrayList<>(), res);
    return res;
  }

  private void backtrack(int n, int k, int start, List<Integer> sub, List<List<Integer>> res) {
    if (sub.size() == k) {
      res.add(new ArrayList<>(sub));
      return;
    }
    for (int i = start; i <= n; i++) {
      sub.add(i);
      backtrack(n, k, i + 1, sub, res);
      sub.remove(sub.size() - 1);
    }
  }
}
