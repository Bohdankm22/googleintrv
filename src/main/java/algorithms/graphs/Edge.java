package algorithms.graphs;

public class Edge {

    private Vertex oneVertex;
    private Vertex secVertex;

    public Edge(Vertex oneVertex, Vertex secVertex) {
        this.oneVertex = oneVertex;
        this.secVertex = secVertex;
    }

    public Vertex getOneVertex() {
        return oneVertex;
    }

    public Vertex getSecVertex() {
        return secVertex;
    }
}
