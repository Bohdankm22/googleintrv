package algorithms.graphs;

public class Edge {

    private Vertex oneVertex;
    private Vertex secVertex;
    private long cost;

    public Edge(Vertex oneVertex, Vertex secVertex) {
        this(oneVertex, secVertex, 1);
    }

    public Edge(Vertex oneVertex, Vertex secVertex, long cost) {
        this.oneVertex = oneVertex;
        this.secVertex = secVertex;
        this.cost = cost;
    }

    public Vertex getOneVertex() {
        return oneVertex;
    }

    public Vertex getSecVertex() {
        return secVertex;
    }
}
