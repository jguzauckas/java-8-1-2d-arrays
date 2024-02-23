# 2D Arrays

---

## 1-Dimensional

So far, we have covered two similar, but different, data structures: arrays and ArrayLists. At their core, they both store a list of values, which we would consider to be "one-dimensional" or "1D". In math, this typically refers to something like a number line: something that has just the one axis. For us, we think of it as how much information do we need to access a value? We need one piece of information, the index, hence 1D.

If you think about it, every time we write out an array, we write it in one dimension, we just write it horizontally with its indices, just like a number line:

```
Index:  0   1   2   3   4   5   6   7   8   9
Value:  2   7   9   11  7   12  2   1   8   0
```

---

## 2-Dimensional

So how would storing information in two dimensions work? The strongest analogy we have is to a table of values, where you can distinctly identify rows and columns of information:

```
|-------|----------|----------|----------|----------|----------|
|       | Column 0 | Column 1 | Column 2 | Column 3 | Column 4 |
|-------|----------|----------|----------|----------|----------|
| Row 0 |    3     |    7     |    2     |    11    |    4     |
|-------|----------|----------|----------|----------|----------|
| Row 1 |    1     |    5     |    8     |    15    |    13    |
|-------|----------|----------|----------|----------|----------|
| Row 2 |    1     |    2     |    6     |    5     |    12    |
|-------|----------|----------|----------|----------|----------|
| Row 3 |    2     |    5     |    7     |    23    |    9     |
|-------|----------|----------|----------|----------|----------|
| Row 4 |    12    |    10    |    3     |    5     |    3     |
|-------|----------|----------|----------|----------|----------|
```

The basic idea here is that instead of addressing something by a single index (1 dimensional), we could address it using a value for its row and a value for its column, which is essentially now two indices (2 dimensional).

For example, I could tell you to look for the value in column `3` and row `2`, which for the table above is the value `5`.

Notice that no two "cells" of the table will have exactly the same identifier. Telling someone to look at column `1` and row `4` (the value `10`) is different from telling them to look at column `4` and row `1` (the value `13`). While both addresses use the values `4` and `1`, which one is the row and which one is the column is important information.

---

## 2-Dimensions in Java

So how do we store a table of values in Java? As you might be able to tell from the name of the unit and section, we still use arrays to do this. How can arrays store things in both 1 dimension and 2 dimensions?

The basic answer is that an array only ever stores things in 1 dimension, so we get really clever to solve this problem.

Arrays can store any type of information: primitive types or objects. This is important because arrays at their core are also objects. The clever solution then is to make an array that stores other arrays. Does this work?

Thinking back to our table above, we could separate a table into being a set of rows. We could think of each row itself as an array. Here's the same information as the table above written as multiple arrays:

```
Array 0 (from Row 0)
Index:  0   1   2   3   4
Value:  3   7   2   11  4

Array 1 (from Row 1)
Index:  0   1   2   3   4
Value:  1   5   8   15  13

Array 2 (from Row 2)
Index:  0   1   2   3   4
Value:  1   2   6   5   12

Array 3 (from Row 3)
Index:  0   1   2   3   4
Value:  2   5   7   23  9

Array 4 (from Row 4)
Index:  0   1   2   3   4
Value:  12  10  3   5   3
```

These 5 arrays contain all of the same information as the table above. You would just have to know which array to look at (equivalent to our row numbers), and which index to look at in that array (equivalent to our column numbers).

We can bring this back into our table form to see the interaction of storing multiple arrays:

```
|---------|---------|---------|---------|---------|---------|
|         | Index 0 | Index 1 | Index 2 | Index 3 | Index 4 |
|---------|---------|---------|---------|---------|---------|
| Array 0 |    3    |    7    |    2    |    11   |    4    |
|---------|---------|---------|---------|---------|---------|
| Array 1 |    1    |    5    |    8    |    15   |    13   |
|---------|---------|---------|---------|---------|---------|
| Array 2 |    1    |    2    |    6    |    5    |    12   |
|---------|---------|---------|---------|---------|---------|
| Array 3 |    2    |    5    |    7    |    23   |    9    |
|---------|---------|---------|---------|---------|---------|
| Array 4 |    12   |    10   |    3    |    5    |    3    |
|---------|---------|---------|---------|---------|---------|
```

Each of our arrays is assigned a number just like our row numbers before, and each column functions as our more traditional index inside of any of the given arrays/rows. This is what a 2-dimensional or **2D array** looks like, it is a set of arrays that can be lined up together.

It is important to note that the example above specifically has a set of arrays that are all the same size. This is not a requirement in Java, but is a standard we will stick to through this course, referred to as **rectangular arrays**.

---

## Implementing 2D Arrays

The notation for 2D arrays is built on the notation for our regular 1D arrays (since it is just an array storing other arrays).

### Declaring and Initializing a Default 2D Array

Here is a quick example of how to initialize an array variable for `int` values from the `Notes1DArrays1.java` file:

```java
int[] nums = new int[5];
```

This creates an `int` array that can store 5 `int` values and assigns it to the variable `nums`. When we create an array like this, it automatically fills it with default values for the type it contains (for `int`, the default is `0`).

This uses the important square bracket notation, where you write the type, and when followed by square brackets indicates an array of that type.

If we want to store an array of arrays, then we need to establish that our type is an array, followed by square brackets. Since `int[]` represents an array of `int` values, this means that `int[][]` represents an array of `int` arrays, essentially representing a table.

Using this notation, we can now initialize a 2D array variable for `int` values from the `Notes2DArrays1.java` file:

```java
int[][] nums = new int[5][5];
```

This creates an array of 5 `int` arrays that can each store `5` values. For the purposes of this course, we will always think of the first number as the number of arrays, and the second number as the number of elements in each of those arrays.

Despite it now being 2D, it still fills all of the elements in all of the arrays with the default type (again, for `int` values, this is `0`).

### Declaring and Initializing a 2D Array with Values

Here is a quick example of how to initialize an array variable with `int` values from the `Notes1DArrays2.java` file:

```java
int[] nums = new int[] {3, 7, 2, 11, 4};
```

The change from default arrays is that instead of providing an `int` value in the square brackets for the length, we just provide an **initializer list** that uses curly braces, and commas between each value.

We can provide initializer lists for 2D arrays as well, with similar notation. Since we are making an array of arrays, 







# Searching and Sorting

Often when we store data in ArrayLists, we want to be able to look through that data and find certain values, or reorganize it to be easier to use.

---

## Searching

While there are many approaches for how to look through an `ArrayList` to find a value, in this course we will only worry about **sequential search**, also known as **linear search**.

The idea of sequential search is straight-forward, just start at the beginning of the `ArrayList` and check each value to see if it is the one you want until you find what you are looking for, or until you have searched the entire `ArrayList` and couldn't find it.

Conveniently, this is extremely similar to the algorithm we covered on identifying if there exists an element with a property. The difference now is that the "property" we are looking for is an exact value (i.e. is the number exactly 5), and instead of just saying `true`, it is there or `false` it is not there, we instead want to say where you can go to get that value if you need it.

Here are the basic steps:
- Iterate over the `ArrayList`.
    - Check if the current value is the value we want.
        - If it is, `return` the current index.
        - If it is not, skip it.
- `return -1` because we did not find the value.

Here is what this could look like from the `NotesSearch1.java` file:

```java
public static int linearSearch(ArrayList<Double> doubleList, double targetValue) {
    for (int i = 0; i < doubleList.size(); i++) {
        if (doubleList.get(i) == targetValue) {
            return i;
        }
    }
    return -1;
}
```

Since objects are slightly different, here is an example with `String` objects from the `NotesSearch2.java` file:

```java
public static int linearSearch(ArrayList<String> strList, String targetValue) {
    for (int i = 0; i < strList.size(); i++) {
        if (strList.get(i).equals(targetValue)) {
            return i;
        }
    }
    return -1;
}
```

Note that the return type `int` did not change between the two examples, since we are always returning an index, which is always an `int`.

---

## Sorting

Sorting is mainly applicable to numerical values, though can be applied to numerical instance variables of objects (i.e., we can sort people by their age or `String` objects by their length).

We will be looking at two different algorithms for sorting: **selection sort** and **insertion sort**.

### Selection Sort

Selection sort is the simpler, yet less efficient of the two sorting algorithms we will look at.

We divide the list into sorted and unsorted sections. At first, just the first element of the list is considered "sorted" and everything to the right of it is considered "unsorted".

The premise of selection sort is that if we want to get numbers in order, we can keep finding the smallest number in the "unsorted" part of the list, and swap it with the front-most value of the "unsorted" list, making it the last value in the "sorted" part of the list, and making the "unsorted" part smaller, until we've moved all the way through the `ArrayList`.

Here is a visual of what selection sort does:

```
3, 2, 9, 8, 6

Minimum --> 2
Swap 2 with the front value (3)
2, 3, 9, 8, 6

Minimum --> 3
Swap 3 with the front of the remaining values (3 was already at the front of them)
2, 3, 9, 8, 6

Minimum --> 6
Swap 6 with the front of the remaining values
2, 3, 6, 8, 9

Minimum --> 8
Swap 8 with the front of the remaining values (8 was already at the front of them)
2, 3, 6, 8, 9

Last value must already be in the right position
2, 3, 6, 8, 9
```

The general algorithm follows these steps:
- Iterate over the ArrayList:
    - Find the minimum value from your current slot to the end of the ArrayList.
    - Swap the minimum value from its current position to the current slot.

Here is what this would look like in the `NotesSelectionSort1.java` file:

```java
public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int minimum = intList.get(i);
        int indexMin = i;
        for (int j = i; j < intList.size(); j++) {
            if (intList.get(j) < minimum) {
                minimum = intList.get(j);
                indexMin = j;
            }
        }
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

We can better understand the algorithm by separating finding the minimum in the rest of the list as its own method. Here is what this would look like from the `NotesSelectionSort2.java` file:

```java
public static int findMinimum(ArrayList<Integer> intList, int start) {
    int minimum = intList.get(start);
    int index = start;
    for (int i = start; i < intList.size(); i++) {
        if (intList.get(i) < minimum) {
            minimum = intList.get(i);
            index = i;
        }
    }
    return index;
}

public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int indexMin = findMinimum(intList, i);
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

Interestingly, finding the minimum value for this sorting process is a little bit more complex than it was before, as we need to keep track both of the minimum value and the index we found it at, and the problem really cares more about the index than the value itself.

### Insertion Sort

Insertion sort is a bit more complex than selection sort, but comes with better efficiency (produces the same result faster).

We again divide the list into sorted and unsorted sections.

This time though, we take the left-most value in the "unsorted" list and sort it into the "sorted" portion of the list by moving left until it belongs (it is less than or equal to the value to the right and greater than or equal to the value to the left).

Here is a visual of what insertion sort does:

```
3, 2, 9, 8, 6

Current Value --> 2
2 needs to move all the way to the left since it is less than 3.
2, 3, 9, 8, 6

Current Value --> 9
9 does not need to move since it is greater than 3 (the first thing to its left).
2, 3, 9, 8, 6

Current Value --> 8
8 needs to move one position to the left since it is less than 9, but is greater than 3.
2, 3, 8, 9, 6

Current Value --> 6
6 needs to move two positions to the left since it is less than 8, but is greater than 3.
2, 3, 6, 8, 9
```

This algorithm essentially treats values to the left of the current element as already sorted, and values to the right as unsorted, so it sorts the current element into the sorted left side of the list, and now the left side is one larger, and it slowly grows until the whole list is sorted.

The general algorithm follows these steps:
- Iterate over the ArrayList:
    - Find and save the index of the left-most position the current value can go without being less than anything to its left.
    - Remove the current value and insert it to the left-most position found.

Here is what this would look like in the `NotesInsertionSort1.java` file:

```java
public static void insertionSort(ArrayList<Integer> intList) {
    for (int i = 1; i < intList.size(); i++) {
        int index = i - 1;
        while (index >= 0 && intList.get(index) > intList.get(i)) {
            index--;
        }
        intList.add(index + 1, intList.remove(i));
    }
}
```

---

## Informal Runtime Comparisons

We can compare the efficiency of two algorithms by counting how many times given lines of code are executed, referred to as **statement execution counts** to get a sense of **informal runtime comparisons**. If one algorithm has much lower statement execution counts, it could be considered more efficient.

We can compare the efficiency of our two sorting algorithms by providing an example `ArrayList` for them to run on and counting how many times key statements are executed. Let's use the sample `ArrayList` `[5, 2, 4, 6]` with both sorting algorithms:

### Selection Sort

Here is the algorithm from the `NotesSelectionSort1.java` file:

```java
public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int minimum = intList.get(i);
        int indexMin = i;
        for (int j = i + 1; j < intList.size(); j++) {
            if (intList.get(j) < minimum) { // Statement
                minimum = intList.get(j);
                indexMin = j;
            }
        }
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

Running this algorithm with `intList` being `[5, 2, 4, 6]`, we count how many times the line marked with the comment `// Statement` is executed!

When the first element `5` is chosen, we evalute the `if` statement for the values `2`, `4`, and `6`, so `3` times. Then the value `2` gets shifted left so the element `5` gets chosen again, and we evalute the `if` statement for the values `4`, and `6`, so `2` times. Then the value `4` gets shifted left, so the element `5` gets chosen again, and we evalute the `if` statement for the value `6`, so `1` time.

Our statement execution count total was `3 + 2 + 1 = 6`.

### Insertion Sort

Here is the algorithm from the `NotesInsertionSort1.java` file:

```java
public static void insertionSort(ArrayList<Integer> intList) {
    for (int i = 1; i < intList.size(); i++) {
        int index = i - 1;
        while (index >= 0 && intList.get(index) > intList.get(i)) { // Statement
            index--;
        }
        intList.add(index + 1, intList.remove(i));
    }
}
```

Running this algorithm with `intList` being `[5, 2, 4, 6]`, we count how many times the line marked with the comment `// Statement` is executed!

When the first element `2` is chosen (this algorithm starts at index `1`), we evalute the `while` statement for the value `5`, so `1` time. Then the value `2` gets shifted left so the element `4` gets chosen, and we evalute the `while` statement for the values `5`, and `2`, so `2` times. Then the value `4` gets shifted left, so the element `6` gets chosen, and we evalute the `while` statement for the value `5`, so `1` time.

Our statement execution count total was `1 + 2 + 1 = 4`.

### Outcome

Informally, this suggests that insertion sort is more efficient than selection sort, as it ran our statement less times. The statements here were purposely picked to be run the most out of any sections of the algorithms.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
