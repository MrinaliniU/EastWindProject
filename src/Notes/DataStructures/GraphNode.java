package Notes.DataStructures;

import java.util.List;

public class GraphNode<T> {
    T val;
    List<T> neighbors;
    GraphNode(T val, List<T> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
