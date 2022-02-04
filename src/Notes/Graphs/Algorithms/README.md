#  Single Source Shortest Distances

| Algorithm  | Bellman Ford  | Dijkstra   | Topological Sorting  |
| ---------- | :-------------: |:----------:| :--------------------:|
| Used For | any weighted graph    | any graph - no negative weights | Directed Acyclic Graph |
| Complexity | O(VE)         | O(E + VLogV) | O(E + V) |

# Dijkstra
We have to find shortest path from one source vertex to all or one other vertices. Since we are finding the shortest path it is a minimization problem, in other words
     it is an optimization problem. Optimization problems can be solved using Greedy Algorithm.
     Greedy Algorithm states that a problem must be solved by taking one step at a time and
     considering one input at a time to get a optimal solution. So, in Greedy Algorithm there are
     pre defines steps and we follow these steps to get an optimal solution.
     Dijkstra's algorithm is one such Greedy Algorithm.
     Dijkstra's algorithm can work for both Directed and Undirected graphs.
     Drawback : May or May Not work when there is a graph with negative edge
     
### Concept : 
Looks for the destination in sort of a flood fill or BFS manner. The main point
        is that -- every time the shortest distance neighbor is selected. In other words the neighbor
        that has the shortest cost is selected.
        Initial : Firstly, Source vertex is marked with a cost of 0, because you are already there.
        All other vertices have cost infinity.
        Steps :
  - Your source vertex say S, with cost 0 is added to a priority queue.
  - All the neighbors of S, say U is then updated with a number
                cost(u) = Math.min(cost(U), cost(S) + edge_weight(S, U));
                In out case Math.min(infinity, 0 + say 7) marking cost of U as 7.
  - This procedure is called relaxation.
  - You need to tract the immediate parent of every node as well so our node U
                has S marked as it's parent.
  - Any time you start exploring a vertex you poll it out of the queue, relax all
            it's neighbors and add these neighbors to the queue.

**Relaxation** : Math.min(cost(U), cost(S) + edge_weight(S, U)); cost of nodes are infinity
initially and for source it is 0.

**Note** - No need to relax a node again when you encounter it via some other node. In other words each node is relaxed only once in Dijkstra's Algorithm.