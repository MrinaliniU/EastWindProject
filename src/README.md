#Notes
### Two Sum Equals Target O(n)
1. Get a `HashMap`
2. in `for` loop ask the map "Have you seen `(target - num)`"
3. if yes : done `return num and target - num` as result.
4. if no : put `(num, target - num)` in the `map`

### Sum of Sub Array Equals Target O(n)

1. Get a `HashMap`
2. `put (0, 1)` in it. This is because the num itself could be equal to target.
3. keep an int for `sum` and one for `count`
4. int a `for` loop 
    1. `sum` is going to keep adding num to itself : `sum += num`
    3. ask if the map "Have you seen `(sum - target)`"
    4. if **yes** `count` will be added with number of times (sum - target) was seen by the map, i.e `count += get(sum - target)`
    5. irrespective of yes or no add `(sum, ++)` to the map. i.e `put(sum, getOrDefault(sum, 0) + 1)`
5. return the count.

### 3 Sum O(n log n) because of the sort

1. Sort the array
2. The `for` loop is going to start from `i :- 0 to n`
    1. **To remove duplicates** if there is a number in front of `num[i]` and that number is same as `num[i]` then `continue`
    2. keep two pointers `a` and `b`. `a` will be in front of `i` and `b` will be the last number in array.
    3. `while` `a` is less than `b` and `b` is less than array length
        1. check if `num[i] = -(num[a] + num[b])` 
        2. if **yes** add i, a and b as one 3 sum set in the result set and increment a and decrement b
        3. **To remove duplicates** as long as num[a] is same as num[a - 1] increment a
        4. **To remove duplicates** as long as num[b] is same as num[a + 1] decrement b
        5. id **no** check if `
            1. num[i] < -(num[a] + num[b])` then increment a
            2.  num[i] > -(num[a] + num[b])` then decrement b
3. Return the final result set.

# Index
## CodeChef
            