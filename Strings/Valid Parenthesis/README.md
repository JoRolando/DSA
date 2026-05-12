# Valid Parentheses

## Problem Statement

Given a string `s` containing only:

```text
( ) { } [ ]
```

Determine whether the string is valid.

A string is valid if:

1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a matching opening bracket.

---

# Example

## Input
```text
([]){}
```

## Output
```text
true
```

---

# Brute Force Approach (Using StringBuilder)

## Java Code

```java
class Solution {

    public boolean isValid(String s) {

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {

                str.append(ch);
            }

            // Closing brackets
            else {

                // No opening bracket available
                if(str.length() == 0) {
                    return false;
                }

                char top = str.charAt(str.length() - 1);

                // Check matching pair
                if(ch == ')' && top != '(') {
                    return false;
                }

                else if(ch == ']' && top != '[') {
                    return false;
                }

                else if(ch == '}' && top != '{') {
                    return false;
                }

                // Remove matched bracket
                str.deleteCharAt(str.length() - 1);
            }
        }

        return str.length() == 0;
    }
}
```

---

# Line-by-Line Explanation (Brute Force)

---

## Create StringBuilder

```java
StringBuilder str = new StringBuilder();
```

Used to store opening brackets.

Acts like a temporary stack.

---

## Traverse String

```java
for(int i = 0; i < s.length(); i++)
```

Loop through every character.

---

## Get Current Character

```java
char ch = s.charAt(i);
```

Extract current bracket.

---

## Check Opening Brackets

```java
if(ch == '(' || ch == '{' || ch == '[')
```

If current character is an opening bracket:

```java
str.append(ch);
```

Store it.

---

## Handle Closing Brackets

```java
else
```

Current character is:
- `)`
- `}`
- `]`

---

## Empty Check

```java
if(str.length() == 0)
```

If no opening bracket exists,
the string is invalid.

Example:

```text
")"
```

---

## Get Last Opening Bracket

```java
char top = str.charAt(str.length() - 1);
```

Retrieve latest opening bracket.

---

## Matching Validation

### Round Brackets

```java
if(ch == ')' && top != '(')
```

If closing bracket is `)`
but latest opening bracket is not `(`,
return false.

---

### Square Brackets

```java
else if(ch == ']' && top != '[')
```

---

### Curly Brackets

```java
else if(ch == '}' && top != '{')
```

---

## Remove Matched Bracket

```java
str.deleteCharAt(str.length() - 1);
```

Matched opening bracket is removed.

---

## Final Validation

```java
return str.length() == 0;
```

If brackets remain unmatched,
string is invalid.

---

# Logic Used in Brute Force

## Core Idea

Store opening brackets.

Whenever a closing bracket appears:
- compare with latest opening bracket
- if matching → remove it
- otherwise → invalid

---

# Dry Run

## Input

```text
([])
```

| Character | StringBuilder |
|---|---|
| `(` | `(` |
| `[` | `([` |
| `]` | `(` |
| `)` | empty |

Valid.

---

# Time Complexity

## O(n)

Every character processed once.

---

# Space Complexity

## O(n)

Worst case:

```text
(((((((
```

All brackets stored.

---

# Problems with This Approach

Although it works,
`StringBuilder` is not meant for stack operations.

Using:
```java
deleteCharAt()
```

makes intent less clear.

This is not the ideal interview approach.

---

# Optimized Approach (Using Stack)

## Java Code

```java
import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {

                st.push(ch);
            }

            // Closing brackets
            else {

                // Empty stack means invalid
                if(st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Matching validation
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
```

---

# Line-by-Line Explanation (Optimized)

---

## Create Stack

```java
Stack<Character> st = new Stack<>();
```

A stack follows:

```text
LIFO
Last In First Out
```

Perfect for nested bracket problems.

---

## Push Opening Brackets

```java
st.push(ch);
```

Store latest opening bracket.

---

## Empty Stack Check

```java
if(st.isEmpty())
```

Closing bracket without opening bracket.

Invalid.

---

## Remove Latest Opening Bracket

```java
char top = st.pop();
```

Retrieve and remove latest opening bracket.

---

## Combined Matching Check

```java
if((ch == ')' && top != '(') ||
   (ch == '}' && top != '{') ||
   (ch == ']' && top != '['))
```

Verify correct bracket pairing.

---

## Final Check

```java
return st.isEmpty();
```

All brackets should be matched.

---

# Why Stack is Better

## 1. Correct Data Structure

This problem is naturally a stack problem.

Using `Stack<Character>` clearly expresses intent.

---

## 2. Cleaner Operations

### Push
```java
st.push()
```

### Remove
```java
st.pop()
```

Cleaner than:
```java
deleteCharAt()
```

---

## 3. Better Readability

Interviewers immediately recognize:
- stack pattern
- bracket matching logic

---

## 4. Easier to Extend

Stack approach easily scales to:
- expression evaluation
- compiler parsing
- HTML tag validation
- recursive simulations

---

# Difference Between Both Approaches

| Feature | StringBuilder Approach | Stack Approach |
|---|---|---|
| Data Structure | StringBuilder | Stack |
| Readability | Moderate | High |
| Interview Preference | Lower | Higher |
| Intent Clarity | Less Clear | Very Clear |
| Operations | append/delete | push/pop |
| Scalability | Lower | Better |

---

# Important DSA Concepts Learned

- Stack
- LIFO
- Nested Structures
- Character Processing
- Traversal
- Matching Patterns
- Edge Case Handling

---

