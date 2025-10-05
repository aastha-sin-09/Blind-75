/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node cloneStart = new Node(node.val);
        map.put(node, cloneStart);
        queue.add(node);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            for(Node neighbor : currNode.neighbors){
                if(!map.containsKey(neighbor)){
                    Node cloneNeighbor = new Node(neighbor.val);
                    map.put(neighbor, cloneNeighbor);
                    queue.add(neighbor);
                }

                map.get(currNode).neighbors.add(map.get(neighbor));
            }
        }

        return cloneStart;
    }
}