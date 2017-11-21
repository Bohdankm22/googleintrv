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

    private static boolean checkAllVertexRelated(MyList<Vertex> vertexList, MyList<Edge> edgeList) {
        for (int i = 0; i < vertexList.size(); i++) {
            boolean found = false;
            for (int j = 0; j < edgeList.size(); j++) {
                if (edgeList.get(j).getOneVertex().equals(vertexList.get(i)) ||
                        edgeList.get(j).getSecVertex().equals(vertexList.get(i))) {
                    found = true;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}


