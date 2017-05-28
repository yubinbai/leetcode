/* class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 * }
 */

function levelOrder(root) {
  let ret = [];
  if (root == null) {
    return ret;
  }
  let currLevel = [root];
  let nextLevel = [];
  while (currLevel.length > 0) {
    nextLevel = [];
    let intList = [];
    for (let e of currLevel) {
      intList.push(e.val);
      if (e.left != null) {
        nextLevel.push(e.left);
      }
      if (e.right != null) {
        nextLevel.push(e.right);
      }
    }
    ret.push(...intList);
    currLevel = nextLevel;
  }
  return ret;
}
