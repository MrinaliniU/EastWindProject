# Graph Representation
There are different types of graphs, and it is a good idea to keep the data structures to represent these graphs handy.
The code for all the representation is in `GraphRepresentation.java`. 
It is important to understand what is given to you. You may be given a list of edges. An edge is represented as, `u -> v`. 
Given a list of edges you can represent a graph as an adjacency list or a matrix.

Any node of value `X` not in the list of adjacency `key` set means there are no edges going out of this node.
Similarly, any node not in any list of neighbors means there are no nodes coming into it.

There might be few disconnected graphs, you don't have to worry about that since all edges including of those that are disconnected are given to you initially
All the graphs would be represented by the `HashMap`.

One **caveat** is that there might be individual nodes that have no out going or in coming edges. These won't be in the `HashMap` as they are not represented in the given
list of edges. You might need to keep track of these for some problems. 
These can be easily tracked in matrix representation but in adjacency list you might have rely on say a list that has all nodes to keep track of all 
nodes in the graph universe. Say, a `boolean[]` list that tracks nodes visited can come handy.
## Basic Representation
### Adjacency List
This is a `HashMap` with `node` as `key` and a List of immediate neighbors or adjacent nodes as `value`.
```$xslt
HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
```
Note that the list of neighbors can be a `HashSet` or a `List`, HashSet is used just for safety to remove duplicate node insertion.
### Adjacency Matrix
if you have `N` nodes make an `N * N` matrix called `A`. Any value `A[u][v]` represents
an edge between nodes `u` and `v`. A value of `1` means a connected edge and a value of `0` means no edge.
## Types of Graph

### Directed Graph
### UnDirected Graph
### Weighted Graph
There are two ways to represent a weighted graph.
#### Neighbour list with weight

#### Weigth-Edge Table
You can keep a `HashMap` with edge, a tuple, (u, v) as the `key` and the weight of this edge
as the value. `W : (u, v) -> w`. An Example : 
`W = {(0, 1) 7→ 0.7, (1, 2) 7→ −2.0, (0, 2) 7→ 1.5}` 
#### Matrix with weights
A graph with `N` nodes can be represented as `N * N` matrix 
### Other things to keep in mind
**The node value** - Generally `N` nodes are marked with values : `0 -> (N - 1)`.
This makes it easy to represent a graph using the below two methods. 
**Node parameters** - There could be other parameters associated with each node,
like it's immediate-parent, it's cost in case of say `Dijkstra's Algorithm`. These can be represented
as separate primitive array like `parent[]` representing the parents of nodes `0 -> (N - 1)`. 
You can however choose to create a `GraphNode` class and have all these parameters stores as the GraphNode class
parameters. It is personal preference.