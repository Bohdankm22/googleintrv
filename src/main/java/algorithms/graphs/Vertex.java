package algorithms.graphs;

public class Vertex {

    private static long generatedId = 0;

    private long id;

    public Vertex() {
        this.id = ++generatedId;
    }
}
