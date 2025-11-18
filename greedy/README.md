MAXIMISE THE TOPMOST ELEMENT AFTER K MOVES

this question is full of testcases

we are trying to maximise the top element here 

edge cases: When size of array==1 and k>1

nums= {1} k=1

remove 1 and you cannot add back any element because you dont have any element to add.

nums= {1} k=2

remove 1 still i have one more move left so we can add back 1 to it and that would an answer

nums= {4,2,1} k==3

remove 4, 2,, we can add back 4 and that would be the answer

nums= {4,2,1} k==4

remove 4,2,1 we can add back 4 

nums={5,2,2,4,0,6} k==4

remove 5,2,2 and add back 5

It took me lot of trials to pass all the testcases


QUEUE RECONSTRUCTION BY HEIGHT

I started sorting the array by height in decreasing order

but what about when heights are equal then sort the array by positioning in increasing order

people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]

after sort

[ [7,0], [7,1], [6,1], [5,0], [5,2], [4,4] ]

Now we ask like this:

[7,0]--i want 0 tall people in front of me so lets put this on the 0th index.

[7,1]-- I want to have 1 tall(or same height) people in front of me. put me at 1st index.

[7,0],[7,1]

[6,1]-- I want 1 tall person in front of me so i will put this at index 1 but element which is already present will be shifted.

[7,0],[6,1],[7,1]

[5,0]-- I want 0 tall person in front of me so put me at index 0

[[5,0], [7,0], [6,1], [7,1]]

[5,2]-- I want 2 tall person in front of me so put me at index 2

[[5,0], [7,0], [5,2], [6,1], [7,1]]

[4,4]--I can afford to have 4 tall or same height person in front of me so put me at index 4th

[[5,0], [7,0], [5,2], [6,1], [7,1], [4,4]]

start learning lambda function in java properly


TWO CITY SCHEDULING:

![PetChain Logo](./images/TwoCitySchedule1.jpg)

![PetChain Logo](./images/TwoCitySchedule2.jpg)


![PetChain Logo](./images/TwoCitySchedule3.jpg)

TASK SCHEDULER:

pick the task with the highest frequency why? Its like how i finish off the task which is the difficult first thing in the morning

If you pick the highest frequency task first, it will minimize the idle time and thats our goal.

Coding was bit difficult:

create freqArray with character and their frequency. ex-[A A A B B B] n = 2

A:3 B: 3


Iterate through the freqArray and get the frequency of all tasks and put it in the max_heap

[3,3]

Define Window= n+1 

A _ _ A so the window is 3 here

Now get the most frequent element and start diving the task

[2,2]-> [1,1]->[0]


LONGEST HAPPY STRING 

very similar to task schedule, tough to code 

a = 1, b = 1, c = 7

put all the element with char and their count in a priority queue

((c,7),(a,1),(b,1))--> element which most frequency will be at the top

take out the most frequent element--> c, 7

if the length< 2 or get last two char c1, c2, if it is not equal to current char which is empty here


simply append to the stringbuilder and decrement the count

string--> c : (c,6)

push it back to the max_heap (c,6),(a,1)(b,1) : StringBuilder= c

get the most frequent element : (c,6)

length<2 so simply append to the stringbuilder, decrement the frequency and push it back to the max heap

curr: (c,5),(a, 1),(b,1) : stringBuilder= cc

get the most frequent element : (c, 5)

Now length==2 && last two chars are equal to curr char which is c so now its time that we pick next frequent element and append it to the stringbuilder

get next frequent element : (a, 1)-> append to the stringbuilder, decrement the frequency and push it to the maxheap(if updatedfrequency>0)

stringbuilder=ccb

get the most frequent element : (c, 5)

length>2 but last two chars are not equal to curr char which is c right now hence just append it, decrement the counter

stringbuilder=ccbc

get the most frequent element : (c, 4)

length>2 but last two chars are not equal to curr char which is c right now hence just append it, decrement the counter

stringbuilder=ccbcc

get the most frequent element : (c, 3)

length>2 and last two chars are  equal to curr char which is c right now so now its time that we pick next frequent element and append it to the stringbuilder

stringbuilder=ccbcca

get the most frequent element : (c, 3)

length>2 but last two chars are not equal to curr char which is c right now hence just append it, decrement the counter

stringbuilder=ccbccac

get the most frequent element : (c, 2)

length>2 but last two chars are not equal to curr char which is c right now hence just append it, decrement the counter

stringbuilder=ccbccacc

Thats it


REORGANIZED STRING:

it is very similar to LONGEST HAPPY STRING 


























