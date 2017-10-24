package advlearning.ex2;

public class Node {

    private Point point;
    private Node previousNode;
    private Node nextNode;

    public Node(Point point, Node previousNode, Node nextNode) {
        this.point = point;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "point=" + point +
                ", previousNode=" + previousNode +
                ", nextNode=" + nextNode +
                '}';
    }
}
