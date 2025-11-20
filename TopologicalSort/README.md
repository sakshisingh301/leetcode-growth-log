course schedule:

This question was tough for me, i understood Topological sort. 
Topological sort only works in DAG(Directed acyclic Graph), If the graph is undirected/Cyclic then we can never apply the algorithm

[1,0]--> meaning 1 should be finished first then 0 can be completed.

In one DFS call, we keep track of visited element, if we encounter it again then we say that there is a cycle and we cannot take that course.




