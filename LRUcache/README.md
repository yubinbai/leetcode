Problem
===
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Solution
===
Use a hash map and a double linked list 

1. use hash map to store <key, linkListNode> 

2. use link list to store value data

3. when updating an existing node, delete and re-insert as head

4. when adding a new node, remove oldest and add new node as head

Note:
---
This is implemente in Java as LinkedHashMap