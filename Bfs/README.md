ROTTEN ORANGES:

Initial thought was to use DFS but if i choose one rotten orange and make a DFS call, in one call it will make all the fresh one rotten (connected)
but we also want to find minimum time and we will not be able to calculate that.
If the question would be like just return true or false if all the cells will be rotten, then DFS would be the best choice here

Its a multi source BFS problem, If there are more than 1 rotten oranges in the start then 
we cannot choose one rotten orange and start because it is asking for minimum time.
BFS will start simultaneously from all rotten orange.

Add all rotten oranges to the queue.

Remove the first element and make all the oranges rotten by doing all four direction call, keep adding the element in the queue.

do this until the queue is empty.

While you are doing this, initially count the fresh oranges and keep decreasing the oranges as you make it rotten

if fresh==0 then return the maximum time else return -1

Total Time Complexity = O(m × n)

Total Space Complexity = O(m × n)