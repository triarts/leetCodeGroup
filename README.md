**the golden question** when leveling up in DSA:  
**"How do I know which technique to apply for a given problem?"**

The answer is: **pattern recognition**. Most LeetCode problems fall into **problem archetypes** — and over time, you’ll start seeing the clues.

Let’s break it down into **what to look for in the problem description**, and then **how to match that with the technique**.

---

## 🔍 How to Identify the Right Technique

| Pattern/Keyword in Problem | Go With This Technique | Why It Works |
|----------------------------|------------------------|--------------|
| **"longest / shortest subarray"** with some constraint | 🔹 Sliding Window | Optimal for continuous segments with conditions |
| **Sorted array / string** or “in-place” or “no extra space” | 🔹 Two Pointers | Exploits order + minimizes space |
| **Cycle detection / infinite loop / palindrome** | 🔹 Fast & Slow Pointers | Efficient for linked lists or symmetric data |
| **"Find all paths / levels / shortest path / traverse a tree or graph"** | 🔹 BFS / DFS | Graph traversal and decision trees |
| **"All permutations / combinations / subsets"** | 🔹 Backtracking | Try all possibilities with pruning |
| **"Find in sorted array / search space"** | 🔹 Binary Search | Binary divide & conquer if order or monotonicity exists |
| **"Top K / frequent / real-time / stream"** | 🔹 Heap / Priority Queue | Maintains top values efficiently |
| **"Max profit / min cost / with constraints / overlapping subproblems"** | 🔹 Dynamic Programming | Break problem into optimal substructure |
| **"Minimize / maximize result by choosing greedily"** | 🔹 Greedy | Local decisions = global optimal (when true) |
| **"Groups / components / islands / friends / connected"** | 🔹 Union Find (DSU) | Disjoint sets, connected components |

---

## 🧠 Example Mapping Practice

Let’s apply it to some real LeetCode-style prompts:

### 🔸 Problem: “Find the longest substring without repeating characters.”
- Clue: Substring + condition
- 🔑 Use: **Sliding Window**

---

### 🔸 Problem: “Given two sorted arrays, find median.”
- Clue: Sorted + efficient
- 🔑 Use: **Binary Search** (not merge!)

---

### 🔸 Problem: “Find if a linked list has a cycle.”
- Clue: Cycle
- 🔑 Use: **Fast & Slow Pointers**

---

### 🔸 Problem: “Given a matrix of 0s and 1s, find the number of islands.”
- Clue: Grid → components
- 🔑 Use: **DFS / Union Find**

---

### 🔸 Problem: “Given coins, find the minimum number to make amount.”
- Clue: Minimum + reuse → overlapping subproblems
- 🔑 Use: **Dynamic Programming**

---

### 🔸 Problem: “Find all combinations of k numbers that sum to n.”
- Clue: “Find all combinations”
- 🔑 Use: **Backtracking**

---

### 🔸 Problem: “Schedule jobs with deadlines and maximize profit.”
- Clue: Optimize with deadlines
- 🔑 Use: **Greedy + Heap**

---

## ✅ Decision Flow

Ask yourself:
1. **Is the input sorted or can be sorted?** → Two pointers / binary search
2. **Are we dealing with contiguous data (array/substring)?** → Sliding window
3. **Is the data recursive / graph/tree?** → DFS/BFS
4. **Are we making combinations or permutations?** → Backtracking
5. **Is there overlap in subproblems?** → Dynamic Programming
6. **Are we repeatedly merging / keeping top values?** → Heap
7. **Are we grouping things?** → Union Find

---


🧠 Simple Trick to Visualize Recursion:
Imagine a stack of calls.
Think of each recursive call as if you're pushing it onto a stack.

So, you're going deeper into the graph with each new recursive call.

The "current node" you're working on is the one at the top of the stack.

Backtracking is like popping off the top of the stack.

Once you reach a dead-end (no more neighbors to visit), you "backtrack" by removing the node from the stack and return to the previous one.
