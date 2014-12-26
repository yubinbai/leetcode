Problem
===
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Solution
====
Put all lists into a queue, while queue size is bigger than one, pop two lists from queue, merge them to one, and put back to queue