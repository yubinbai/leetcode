import java.util.*;
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, ret);
        ArrayDeque<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        q.offer(node);
        // store all nodes
        while (!q.isEmpty()) {
            UndirectedGraphNode e = q.poll();
            for (UndirectedGraphNode ee : e.neighbors) {
                if (map.get(ee) == null) {
                    map.put(ee, new UndirectedGraphNode(ee.label));
                    q.offer(ee);
                }
            }
        }
        // store all edges
        for (UndirectedGraphNode e : map.keySet()) {
            UndirectedGraphNode target = map.get(e);
            for (UndirectedGraphNode ee : e.neighbors) {
                target.neighbors.add(map.get(ee));
            }
        }
        return ret;
    }
}