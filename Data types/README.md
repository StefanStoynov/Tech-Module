# Tech-Module
# 1.Lab: Data Types and Variables


1.
# I.Integer and Real Numbers

1. 1.Centuries to Minutes

Write program to enter an integer number of **centuries** and convert it to **years** , **days** , **hours** and **minutes**.

### Examples

| **Input** | **Output** |
| --- | --- |
| 1 | 1 centuries = 100 years = 36524 days = 876576 hours = 52594560 minutes |
| 5 | 5 centuries = 500 years = 182621 days = 4382904 hours = 262974240 minutes |

### Hints

- Use appropriate data type to fit the result after each data conversion.
- Assume that a year has 2422 days at average ( [the Tropical year](https://en.wikipedia.org/wiki/Tropical_year)).

### Solution

You might help yourself with the code below:

1. 2.Circle Area (12 Digits Precision)

Write program to enter a radius **r** (real number) and **print the area** of the circle with exactly **12 digits** after the decimal point. Use data type of **enough precision** to hold the results.

### Examples

| **Input** | **Output** |   | **Input** | **Output** |
| --- | --- | --- | --- | --- |
| 2.5 | 19.634954084936 |   | 1.2 | 4.523893421169 |

### Hints

- You might use the data type **double**. It has precision of 15-16 digits.
- To print the output with exactly 12 digits after the decimal point, you might use the following code:

1. 3.Exact Sum of Real Numbers

Write program to enter **n** numbers and calculate and print their **exact sum** (without rounding).

### Examples

| **Input** | **Output** |   | **Input** | **Output** |
| --- | --- | --- | --- | --- |
| 3<br>1000000000000000000<br>5<br>10 | 1000000000000000015 |   | 2<br>0.00000000003<br>333333333333.3 | 333333333333.30000000003 |

### Hints

- If you use types like **float** or **double** , the result will lose some of its precision. Also it might be printed in scientific notation.
- You might use the **decimal** data type which holds real numbers with high precision with less loss.
- Note that **decimal** numbers sometimes hold the unneeded zeroes after the decimal point, so **0m** is different than **0.0m** and **0.00000m**.

1.
# II.Data Types and Type Conversion

1. 4.Elevator

Calculate how many courses will be needed to **elevate n persons** by using an elevator of **capacity of p persons**. The input holds two lines:the **number of people n** and the **capacity p** of the elevator.

### Examples

| **Input** | **Output** | **Comments** |
| --- | --- | --- |
| 17<br>3 | 6 | 5 courses \* 3 people<br>
+ 1 course \* 2 persons |
| 4<br>5 | 1 | All the persons fit inside in the elevator.<br>Only one course is needed. |
| 10<br>5 | 2 | 2 courses \* 5 people |

### Hints

- You should **divide**  **n**  **by**  **p**. This gives you the number of full courses (e.g. 17 / 3 = 5).
- If **n** does not divide **p** without a remainder, you will need one additional partially full course (e.g. 17 % 3 = 2).
- Another approach is to round up **n**** / ****p** to the nearest integer (ceiling), e.g. 17/3 = 67 rounds up to 6.
- Sample code for the round-up calculation:

### Hints

To calculate the sum of digits of given number **num** , you might repeat the following: sum the last digit ( **num**** % ****10** ) and remove it ( **sum**** = ****sum**** / ****10** ) until **num** reaches **0**.

1. 5.Triples of Latin Letters

Write a program to read an integer **n** and print all **triples** of the first **n small Latin letters** , ordered alphabetically:

### Examples

| **Input** | **Output** |
| --- | --- |
| 3 | aaa<br>aab<br>aac<br>aba<br>abb<br>abc<br>aca<br>acb<br>acc<br>baa<br>bab<br>bac<br>bba<br>bbb<br>bbc<br>bca<br>bcb<br>bcc<br>caa<br>cab<br>cac<br>cba<br>cbb<br>cbc<br>cca<br>ccb<br>ccc |

### Hints

Perform 3 nested loops from **0** to **n-1**. For each number **num** print its corresponding Latin letter as follows:

1. 6.Greeting

Write a program that enters **first name** , **last name** and **age** and prints &quot; **Hello, &lt;first name&gt; &lt;last name&gt;. You are &lt;age&gt; years old.**&quot;. Use interpolated strings.

### Examples

| **Input** | **Output** |
| --- | --- |
| Svetlin<br>Nakov<br>25 | Hello, Svetlin Nakov. You are 25 years old. |

### Hints

You might use the following code:

1.
# III.Variables

1. 7.Refactor Volume of Pyramid

You are given a **working code** that finds the **volume of a pyramid**. However, you should consider that the variables exceed their optimum span and have improper naming. Also, search for variables that **have multiple purpose**.

### Hints

- **Reduce the span** of the variables by declaring them in the moment they receive a value, not before
- Rename your variables to **represent their** real **purpose** (example: &quot;dul&quot; should become length, etc.)
- Search for variables that have multiple purpose. If you find any, **introduce a new variable**.

1. 8.Refactor Special Numbers

You are given a **working code** that is a solution to **Problem 5. Special Numbers**. However, the variables are **improperly named, declared before** they are needed and some of them are used for multiple things. Without using your previous solution, **modify the code** so that it is **easy to read and understand**.

### Hints

- Reduce the span of the variables by declaring them in the moment they receive a value, not before
- Rename your variables to represent their real purpose (example: &quot;dul&quot; should become length, etc.)
- Search for variables that have multiple purpose. If you find any, introduce a new variable
