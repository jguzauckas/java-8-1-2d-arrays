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

## 2 Dimensions in Java

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

Here is a quick example of how to initialize an array variable for default `int` values from the `NotesDefaultInitialization1.java` file:

```java
int[] nums = new int[5];
```

This creates an `int` array that can store 5 `int` values and assigns it to the variable `nums`. When we create an array like this, it automatically fills it with default values for the type it contains (for `int`, the default is `0`).

This uses the important square bracket notation, where you write the type, and when followed by square brackets indicates an array of that type.

If we want to store an array of arrays, then we need to establish that our type is an array, followed by square brackets. Since `int[]` represents an array of `int` values, this means that `int[][]` represents an array of `int` arrays, essentially representing a table.

Using this notation, we can now initialize a 2D array variable for `int` values from the `NotesDefaultInitialization2.java` file:

```java
int[][] nums = new int[5][5];
```

This creates an array of 5 `int` arrays that can each store `5` values. For the purposes of this course, we will always think of the first number as the number of arrays, and the second number as the number of elements in each of those arrays.

Despite it now being 2D, it still fills all of the elements in all of the arrays with the default type (again, for `int` values, this is `0`).

### Declaring and Initializing a 2D Array with Values

Here is a quick example of how to initialize an array variable with `int` values from the `NotesInitialization1.java` file:

```java
int[] nums = new int[] {3, 7, 2, 11, 4};
```

The change from default arrays is that instead of providing an `int` value in the square brackets for the length, we just provide an **initializer list** that uses curly braces, and commas between each value.

We can provide initializer lists for 2D arrays as well, with similar notation. Since we are making an array of arrays, where we would have written a number before, we write a whole 1D array initializer list.

Continuing our sample 2D array from above, this is what the 1D array initializer lists look like for each of the rows.

```
{3, 7, 2, 11, 4}
{1, 5, 8, 15, 13}
{1, 2, 6, 5, 12}
{2, 5, 7, 23, 9}
{12, 10, 3, 5, 3}
```

With these in hand, our 2D array initializer list would look like this:

```
{{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}}
```

Notice that we end up with multiple curly braces, and each of our 1D initializer lists are separated by commas themselves.

Using this notation, we can now initialize a 2D array variable with specific `int` values from the `NotesInitialization2.java` file:

```java
int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
```

Just like our default example, this creates a 5 row, 5 column 2D array, but this time the values are specifically set. The values in the first row would be 3, 7, 2, 11, and 4.

---

## Using 2D Arrays

Just like when creating them, the notation for using (accessing, modifying, etc.) the values for 2D arrays is built on the notation that we used for 1D arrays.

As discussed above when looking at tables, the primary difference is we now have two "index" values that are needed to get to an element: one for the row and one for the column.

Here is our sample table again:

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

To tell someone which element we would like to look at/work with, we need to tell them which 1D array we are looking at (our row), and which index in that 1D array we are looking at (our column).

For example, if I told someone I was looking at row `3` and column `2`, this would represent the value `7`. Again as mentioned above, despite using the same values for the indices, looking at row `2` and column `3` is a different element of the 2D array: this time the value is `5`.

### Accessing Elements

Here is a quick example of how we would access a specific element in a 1D array from the `NotesAccess1.java` file:

```java
int[] nums = new int[] {3, 7, 2, 11, 4};
System.out.println(nums[1]);
System.out.println(nums[3]);
```

This sample would print out the values `7` and `11`. By providing the index of the element we want in the square brackets, it accesses and gives us the value stored in that index.

This is going to be very similar for 2D arrays, except now we have two square brackets and therefore two indices (our row and column that we looked at above). The first square bracket will represent the row index and the second square bracket will represent the column index.

Here is what this would look like for 2D arrays from the `NotesAccess2.java` file:

```java
int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
System.out.println(nums[3][2]);
System.out.println(nums[2][3]);
```

This shows our example earlier was correct by printing `7` first (for row `3` and column `2`), and then `5` (for row `2` and column `3`).

### Modifying Elements

Here is a quick example of how we would modify a specific element in a 1D array from the `NotesAccess1.java` file:

```java
int[] nums = new int[] {3, 7, 2, 11, 4};
nums[2] = 5;
System.out.println(nums[2]);
nums[4] -= 1;
System.out.println(nums[4]);
nums[1] *= nums[0];
System.out.println(nums[1]);
```

When it comes to modifying a 1D array value, we can just use the square bracket and index to get the correct position, and then use assignment (`=`) to change the value:
- This can be simple like just assigning a new value `5` to index `2` (overwriting the value `2` that had been there). Therefore, the first number it prints is `5`.
- It can be more complex and modify based on its current value, like substracting `1` from the current value at index `4` (this does `4 - 1` and stores `3` as the result). Therefore, the second number it prints is `3`.
- The most complex would be modifying based on its current value and the value from other parts of the array, like multiplying the current value at index `1` by the current value at index `0` and saving that result to index `1` (this does `7 * 3` and stores `21` as the result). Therefore, the third number it prints is `21`.

Modifying values in a 2D array is fundamentally the same, we just need two square brackets and indices to access the right place to begin with.

Here is what this would look like for 2D arrays from the `NotesAccess2.java` file:

```java
int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
nums[1][4] = 5;
System.out.println(nums[1][4]);
nums[3][1] += 6;
System.out.println(nums[3][1]);
nums[2][2] /= nums[1][0]; 
System.out.println(nums[2][2]);
```

Can you predict what happens and what it should print?
- The first value it prints is `5`. The value at `[1][4]` is `13`, which is overwritten with the value `5`.
- The second value it prints is `11`. The value at `[3][1]` is `5`, which has `6` added to it to get `11`.
- The third value it prints is `6`. The value at `[2][2]` is `6`, which is divided by the value at `[1][0]` which is `1`, to get `6` and saves to the position `[2][2]`.

### Length

1D arrays have a property called `length` that tells us how many elements are stored in the array.

Here is a quick example of how we would get the length of a 1D array from the `NotesLength1.java` file:

```java
int[] nums = new int[] {3, 7, 2, 11, 4};
System.out.println(nums.length);
```

This prints the value `5`, since there are `5` numbers stored in the array. Remember that the `length` has a specific relationship with our indices, which is that indices go from `0` to `length - 1`. So for this array, the valid indices go from `0` to `5 - 1 = 4`.

It would seem intuitive then, that when we ask a 2D array for its length, it tells us how many total values the table stores, but this doesn't work out.

As a quick example from the `NotesLength2.java` file:

```java
int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
System.out.println(nums.length);
```

This prints out the value `5`, even though we know that this table stores `25` numbers (`5` rows times `5` columns is `25` cells).

So why is it printing `5`? This comes back to the premise of what 2D arrays are: an array of arrays. When we ask a 2D array for its `length`, it tells us how many things it stores. Since a 2D array is an array that stores many 1D arrays, `length` tells us how many 1D arrays it stores, which in this case is `5`. This, in effect, tells us how many rows our 2D array has.

Well, if our goal is to say how many total elements it stores, then it seems all we need now is to get the number of columns, and then we can multiple rows and columns to get our answers. How do we get the number of columns?

If the length of a 2D array tells us the number of rows/1D arrays, then if we could just get a hold of one of the 1D arrays and ask it for its length, that would be the number of columns.

Oddly enough with 2D arrays, we can use just one square bracket and an index instead of two, and this gives us a whole row of the 2D array, which is just a 1D array. It is important to note that since our 2D arrays are rectangular, it doesn't matter which row we get access to, any row will work. Due to this, we typically just take the first row (index `0`).

Here is what this would look like from the `NotesLength3.java` file:

```java
int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
System.out.println(nums[0].length);
```

This again prints the value `5`, but that's because that is how many values are stored in the first row (the 1D array `{3, 7, 2, 11, 4}`).

So now we can combine these two things to state the number of rows, number of columns, and number of total values that a 2D array can store.

Here is an example of this with a different-sized 2D array from the `NotesLength4.java` file:

```java
int[][] nums = new int[7][11];
System.out.println("Number of Rows: " + nums.length);
System.out.println("Number of Columns: " + nums[0].length);
System.out.println("Number of Values: " + (nums.length * nums[0].length));
```

This prints the following result:

```
Number of Rows: 7
Number of Columns: 11
Number of Values: 77
```

The ability to get the number of rows and columns separately is going to be critical to our work in the next section as we cover traversal of 2D arrays.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
