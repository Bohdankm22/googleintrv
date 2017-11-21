package algorithms.graphs;

import datastructure.list.MyList;

public class MyGraph {

    private MyList<Vertex> vertexList;
    private MyList<Edge> edgeList;

    public MyGraph(MyList<Vertex> vertexList, MyList<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public MyList<Vertex> getVertexList() {
        return vertexList;
    }

    public MyList<Edge> getEdgeList() {
        return edgeList;
    }
}


