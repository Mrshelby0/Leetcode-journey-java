# 🚀 LeetCode Journey - Java

[![Java](https://img.shields.io/badge/Java-11%2B-orange.svg)](https://www.java.com)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue.svg)](https://maven.apache.org)
[![JUnit](https://img.shields.io/badge/JUnit-5.9.2-green.svg)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

This repository documents my LeetCode journey in Java, featuring well-structured solutions organized by algorithmic topics. Each solution includes clean, well-commented code with multiple approaches, time/space complexity analysis, and comprehensive unit tests.

## 🎯 Goals & Objectives

- **Systematic Learning**: Master data structures and algorithms through topic-based organization
- **Code Quality**: Write clean, readable, and well-documented Java code
- **Best Practices**: Follow Java conventions, SOLID principles, and testing best practices
- **Progress Tracking**: Monitor improvement and consistency in problem-solving
- **Knowledge Sharing**: Create a comprehensive reference for future practice and learning

## 📁 Project Structure

```
src/
├── main/java/com/leetcode/
│   ├── arrays/                     # Array-based problems
│   ├── linkedlists/               # Linked list problems
│   ├── trees/                     # Binary tree and BST problems
│   ├── dynamicprogramming/        # DP problems
│   ├── strings/                   # String manipulation problems
│   ├── graphs/                    # Graph algorithms
│   ├── backtracking/              # Backtracking problems
│   ├── sorting/                   # Sorting algorithms
│   ├── searching/                 # Binary search and variants
│   ├── math/                      # Mathematical problems
│   ├── stack/                     # Stack-based problems
│   ├── queue/                     # Queue-based problems
│   ├── heap/                      # Priority queue/heap problems
│   └── utils/                     # Common data structures (ListNode, TreeNode)
└── test/java/com/leetcode/        # Comprehensive unit tests
```

## 📊 Progress Tracker

### 🟢 Completed Topics

#### Arrays (2/50+ planned)
- [x] **Problem 1**: Two Sum - Hash map approach with O(n) time complexity
- [x] **Problem 121**: Best Time to Buy and Sell Stock - Single pass with min tracking

#### Linked Lists (1/30+ planned)  
- [x] **Problem 206**: Reverse Linked List - Both iterative and recursive solutions

#### Trees (1/25+ planned)
- [x] **Problem 104**: Maximum Depth of Binary Tree - DFS, BFS, and iterative approaches

#### Dynamic Programming (1/40+ planned)
- [x] **Problem 70**: Climbing Stairs - Multiple DP approaches with space optimization

### 🔵 In Progress Topics
- [ ] **Strings**: String pattern matching, palindromes, anagrams
- [ ] **Graphs**: BFS, DFS, shortest path algorithms
- [ ] **Backtracking**: N-Queens, permutations, combinations

### 🔴 Planned Topics
- [ ] **Sorting**: Quick sort, merge sort, heap sort implementations
- [ ] **Searching**: Binary search variations and applications
- [ ] **Math**: Number theory, bit manipulation problems
- [ ] **Stack**: Monotonic stack, expression evaluation
- [ ] **Queue**: BFS applications, sliding window problems
- [ ] **Heap**: Priority queue applications, top K problems

## 🛠️ How to Run

### Prerequisites
- Java 11 or higher
- Maven 3.6+ 

### Build and Test
```bash
# Clone the repository
git clone https://github.com/Mrshelby0/Leetcode-journey-java.git
cd Leetcode-journey-java

# Compile the project
mvn compile

# Run all tests
mvn test

# Run tests for a specific topic
mvn test -Dtest="com.leetcode.arrays.*"

# Generate test coverage report (if configured)
mvn jacoco:report
```

### Running Individual Solutions
```bash
# Compile and run a specific solution
javac -cp target/classes src/main/java/com/leetcode/arrays/TwoSum.java
java -cp target/classes com.leetcode.arrays.TwoSum

# Or use Maven to execute
mvn exec:java -Dexec.mainClass="com.leetcode.arrays.TwoSum"
```

## 📝 Code Structure & Standards

### Solution Template
Each solution follows this structure:
```java
/**
 * LeetCode Problem X: Problem Name
 * 
 * Problem description and examples
 * 
 * Time Complexity: O(...)
 * Space Complexity: O(...)
 */
public class SolutionName {
    
    /**
     * Main approach with detailed explanation
     * 
     * @param input Parameters description
     * @return Return value description
     */
    public ReturnType solutionMethod(InputType input) {
        // Implementation with comments
    }
    
    // Alternative approaches if applicable
    // Helper methods if needed
}
```

### Testing Standards
- Comprehensive unit tests for all public methods
- Edge case coverage (empty inputs, single elements, etc.)
- Performance verification for different input sizes
- Comparison between different solution approaches

## 🔧 Utility Classes

### Common Data Structures
- **ListNode**: Singly-linked list node with helper methods
- **TreeNode**: Binary tree node with array conversion utilities
- **Custom structures**: As needed for specific problems

### Helper Methods
- Array/List creation from test data
- Tree construction from level-order arrays
- Visualization and debugging utilities

## 📈 Learning Resources & References

### Recommended Study Order
1. **Arrays & Strings**: Foundation for most algorithms
2. **Linked Lists**: Pointer manipulation and recursion
3. **Trees & Graphs**: Recursive thinking and traversals
4. **Dynamic Programming**: Optimization and pattern recognition
5. **Advanced Topics**: Backtracking, greedy algorithms, etc.

### Key Concepts Covered
- Time and Space Complexity Analysis
- Algorithm Design Patterns
- Data Structure Trade-offs
- Code Optimization Techniques
- Testing and Debugging Strategies

## 🤝 Contributing

While this is a personal learning repository, suggestions and improvements are welcome:
1. Fork the repository
2. Create a feature branch
3. Make your changes with tests
4. Submit a pull request with detailed description

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- LeetCode platform for providing excellent algorithmic problems
- Java community for best practices and conventions
- Open source testing frameworks and tools

---

> **Note**: This repository is actively maintained as I progress through LeetCode problems. Solutions are added regularly with detailed explanations and optimizations. ⭐ Star this repo if you find it helpful!
