# Remove Outermost Parentheses

## Problem Statement

A valid parentheses string is either:
- an empty string `""`
- `"(" + A + ")"` where `A` is valid
- `A + B` where both `A` and `B` are valid

A primitive valid parentheses string is a valid parentheses string that cannot be split into smaller valid valid strings.

The task is to remove the outermost parentheses from every primitive string.

---

# Example

## Input
```text
((()))
```

## Output
```text
(())
```

---

# Java Solution

```java
class Solution {

    public String removeOuterParentheses(String s) {

        int counter = 0;

        StringBuilder out = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);

            if(temp == '(') {

                if(counter > 0) {
                    out.append(temp);
                }

                counter++;
            }
            else {

                counter--;

                if(counter > 0) {
                    out.append(temp);
                }
            }
        }

        return out.toString();
    }
}
```

---

# Logic Explanation

## Main Idea

We use a counter to track the nesting level of parentheses.

- `(` increases the counter
- `)` decreases the counter

The outermost parentheses are:
- the first `(` when counter is `0`
- the last `)` when counter becomes `0`

We skip these outermost parentheses and add the remaining characters to the output.

---

# Step-by-Step Dry Run

## Input
```text
((()))
```

| Character | Counter Before | Action | Counter After | Output |
|---|---|---|---|---|
| `(` | 0 | Skip | 1 | "" |
| `(` | 1 | Add | 2 | "(" |
| `(` | 2 | Add | 3 | "((" |
| `)` | 3 | Add | 2 | "(()" |
| `)` | 2 | Add | 1 | "(())" |
| `)` | 1 | Skip | 0 | "(())" |

---

# Why StringBuilder is Used

In Java, `String` objects are immutable.

Using:
```java
out = out + temp;
```

creates a new string every time, which is inefficient.

`StringBuilder` is faster because it modifies the same object internally.

---

# Time Complexity

## O(n)

We traverse the string once.

---

# Space Complexity

## O(n)

Used for storing the output string.

---

# Concepts Used

- Strings
- Traversal
- Character Processing
- Counter Technique
- StringBuilder
- Parentheses Balancing

---
