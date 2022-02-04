package LeetCode.Util;
import java.util.*;
public class BinaryMatrix {
    public BinaryMatrix(List<List<Integer>> matrix){
        this.matrix = matrix;
        this.dimensions = new ArrayList<>(Arrays.asList(matrix.size(), matrix.get(0).size()));
    }
    public int get(int x, int y){
        return matrix.get(x).get(y);
    }
    private final List<Integer> dimensions;
    List<List<Integer>> matrix;
    public List<Integer> dimensions(){
        return dimensions;
    }
}
