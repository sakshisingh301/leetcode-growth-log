Course Schedule Using DFS :

Determine whether you can finish all courses?

![img.png](img.png)

![img_1.png](img_1.png)




Course Schedule II 

Same code, just added a result variable to store the ordering 


![img_2.png](img_2.png)

![img_3.png](img_3.png)


Find Eventual Safe States:

three states: 0, 1, 2 

 State Meaning

0 → not visited

1 → currently visiting (in recursion path → possible cycle)

2 → safe node
 
Logic: 

1. Start DFS from each node

2. Mark node as 1 (visiting)

3. Explore all neighbours

4. If any neighbour leads to a cycle → return false

5. If all neighbours are safe → mark current node as 2 (safe)

Important Rule ⭐

If even one path goes into a cycle → node is NOT safe

All paths must be safe

Similar to cycle detection(had difficulty writing the code)