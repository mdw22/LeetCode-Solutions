package Java;

import java.math.BigInteger;
import java.util.*;
import javax.swing.tree.TreeNode;

import Java.ListNode;

public class Solution {

    public int findMaxK(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        int max = -1;
        Arrays.sort(nums);
        for(int num : nums) {
            if(num < 0) m.put(-num, true);
            else {
                if(m.getOrDefault(num, false)) max = num;
            }
        }
        return max;
    }

    public int numberOfMatches(int n) {
        int matches = 0;
        while(n != 1) {
            // If n is a multiple of 2, set n to n/2
            // If not, set n to n/2 plus one. 
            matches += n/2;
            n = (n % 2 == 0 ? n/2 : (n/2 + 1));
        }
        return matches;
    }

    public int compareVersion(String version1, String version2) {
        var v1 = version1.split("\\.");
        var v2 = version2.split("\\.");

        for(var i = 0; i < Math.max(v1.length, v2.length); ++i) {
            var num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            var num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
    }

    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while(i <= j) {
            if(people[j] + people[i] <= limit) ++i;
            j--;
            boats++;
        }
        return boats; 
    }

    public void deleteNode(ListNode node) {
        while(node.next != null) {
            node.val = node.next.val;
            // Next node is the last node in the tree
            if(node.next.next == null) {
                node.next = null;
            }
            else {
                node = node.next;
            }
        }
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        boolean buy_flag = true, sell_flag = false;
        int profit = 0, current_proft = 0;
        for(int price : prices) {
            if(buy_flag) {
                // Buy mode
                current_proft = 0;
                current_proft = price;
                buy_flag = false;
                sell_flag = true;
            } else if(sell_flag) {
                // Sell mode
                profit += price - current_proft;
                sell_flag = false;
            } else {
                buy_flag = true;
            }
        }
        if(profit < 0) return 0;
        return profit;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode new_head; 
        int val = head.val * 2;
        if(val > 9) {
            new_head = new ListNode(1);
            new_head.next = new ListNode(val - 10);
            new_head = new_head.next;
        } else {
            new_head = new ListNode(val);
        }
        
        ListNode return_head = new_head;
        return null;
    }

    public String[] findRelativeRanks(int[] score) {
        int[] sorted_score = score.clone();
        String[] return_list = new String[score.length];
        Arrays.sort(sorted_score);
        for(int i = 0; i < score.length; ++i) {
            if(score[i] == sorted_score[score.length-1]) return_list[i] = "Gold Medal";
            else if(score[i] == sorted_score[score.length-2]) return_list[i] = "Silver Medal";
            else if(score[i] == sorted_score[score.length-3]) return_list[i] = "Bronze Medal";
            else {
                for(int j = 0; j < sorted_score.length-3; ++j) {
                    if(score[i] == sorted_score[j]) {
                        return_list[i] = String.valueOf(score.length - j);
                        break;
                    }
                }
            }
        }
        return return_list;
    }

    public int[] rational(double x) {
        int[] arr = new int[2];
        String[] s = String.valueOf(x).split(".");
        arr[0] = Integer.valueOf(s[0]);
        arr[1] = Integer.valueOf(s[1]);
        return arr;
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        return null;
    }

    public boolean isOneBitCharacter(int[] bits) {
        /*
         * Iterate through the array.
         * For every 1, make sure the subsuquent num is NOT at the 
         * end of the array. 
         */
        boolean bit_flag = false;
        for(int i = 0; i < bits.length; ++i) {
            int bit = bits[i];
            if(bit_flag) {
                if(i == bits.length - 1) return false;
                bit_flag = false;
            } else {
                if(bit == 1) bit_flag = true;
            }
        }
        return true;
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Map to store quality/wage values, key is worker index
        Map<Integer, Double> m = new HashMap<>();
        for(int i = 0; i < quality.length; ++i) {
            double d = quality[i] / wage[i];
            m.put(i, d);
        }
        return 0;
    }

    /*
     * You are given an n x n integer matrix grid.
    Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

    maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
    In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

    Return the generated matrix.
     */
    public int findMax(int[][] grid, int x, int y) {
        int max = 0;
        for(int i = x; i < x + 3; ++i) {
            for(int j = y; j < y + 3; ++j) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        for(int i = 0; i < grid.length-2; ++i) {
            for(int j = 0; j < grid[i].length-2; ++j) {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }
        return maxLocal;
    }

    /*
     * You are given an m x n binary matrix grid.

        A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

        Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

        Return the highest possible score after making any number of moves (including zero moves).
     */
    public int matrixScore(int[][] grid) {
        for(int i = 0; i < grid.length; ++i) {
            
        }
        return 0;
    }

    /*
     * You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:

        A cell containing a thief if grid[r][c] = 1
        An empty cell if grid[r][c] = 0
        You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

        The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.

        Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).

        An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.

        The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.


     */

     /*
      * Approach : BFS search through grid
      
      */ 

    public class Pair {
        int x, y;
        Pair(int first, int second) {
            x = first;
            y = second;
        }
    }

    public boolean isValid(boolean[][] vis, int row, int col) {
        if(row < 0 || col < 0 || row > vis.length || col > vis.length) return false;
        if(vis[row][col]) return false;
        return true;
    }

    void listBFS(List<List<Integer>> grid, boolean[][] vis, int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;
        while(!q.isEmpty()) {
            Pair cell = q.peek();

        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        boolean[][] vis = new boolean[grid.size()][grid.size()]; 
        return 0;
    }

    /*
     * A truck has two fuel tanks. You are given two integers, mainTank representing the fuel present in the main tank in liters and additionalTank representing the fuel present in the additional tank in liters.

        The truck has a mileage of 10 km per liter. Whenever 5 liters of fuel get used up in the main tank, if the additional tank has at least 1 liters of fuel, 1 liters of fuel will be transferred from the additional tank to the main tank.

        Return the maximum distance which can be traveled.

        Note: Injection from the additional tank is not continuous. It happens suddenly and immediately for every 5 liters consumed.

        

        Example 1:

        Input: mainTank = 5, additionalTank = 10
        Output: 60
        Explanation: 
        After spending 5 litre of fuel, fuel remaining is (5 - 5 + 1) = 1 litre and distance traveled is 50km.
        After spending another 1 litre of fuel, no fuel gets injected in the main tank and the main tank becomes empty.
        Total distance traveled is 60km.
        Example 2:

        Input: mainTank = 1, additionalTank = 2
        Output: 10
        Explanation: 
        After spending 1 litre of fuel, the main tank becomes empty.
        Total distance traveled is 10km.

     */
    public int distanceTraveled(int mainTank, int additionalTank) {
        int addTankCounter = 0, distanceTraveled = 0;
        while(mainTank > 0) {
            mainTank--;
            addTankCounter++;
            if(addTankCounter == 5 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
                addTankCounter = 0;
            }
            distanceTraveled += 10;
        }
        return distanceTraveled;
    }

    /*
 * You are given a positive integer n.

    Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.

    Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.

    Return an integer array answer where answer = [even, odd].
 */
    public int[] evenOddBit(int n) {
        String binary = Integer.toBinaryString(n);
        int even_count = 0, odd_count = 0;
        for(int i = 0; i < binary.length(); ++i) {
            char c = binary.charAt(i);
            if(c == '1') {
                if((binary.length() - 1 - i) % 2 == 0) even_count++;
                else odd_count++;
            }
        }
        return new int[] { even_count, odd_count } ;
    }

    /*
     * You are given the root of a full binary tree with the following properties:

        Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
        Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
        The evaluation of a node is as follows:

        If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
        Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
        Return the boolean result of evaluating the root node.

        A full binary tree is a binary tree where each node has either 0 or 2 children.

        A leaf node is a node that has zero children.
         * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
     */

     /*
      * DFS, Rush to bottom of leftmost node, then move up rerunning DFS through the right node
      */
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null) return root.val != 0;

        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);

        if(root.val == 2) {
            return leftEval | rightEval;
        } else {
            return leftEval && rightEval;
        }
    }

    /*
     * An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

        'A': Absent.
        'L': Late.
        'P': Present.
        Any student is eligible for an attendance award if they meet both of the following criteria:

        The student was absent ('A') for strictly fewer than 2 days total.
        The student was never late ('L') for 3 or more consecutive days.
        Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.

        

        Example 1:

        Input: n = 2
        Output: 8
        Explanation: There are 8 records with length 2 that are eligible for an award:
        "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
        Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
        Example 2:

        Input: n = 1
        Output: 3
        Example 3:

        Input: n = 10101
        Output: 183236316
        

        Constraints:

        1 <= n <= 105
     */
    public int checkRecord(int n) {
        return 0;
    }

    public String licenseKeyFormatting(String s, int k) {
        int count = 0;
        String newKey = "";
        for(char c : s.toCharArray()) {
            if(c == '-' && count != k) {
                count = 0;
                continue;
            }
            if(count == k) {
                newKey+="-";
                count = 0;
            }
            newKey+=c;
            count++;
        }
        return newKey;
    }

    int sum = 0;
    public void recursiveRange(TreeNode root, int low, int high) {
        if(root == null) return;
        if(root.val >= low && root.val <= high) sum += root.val;
        recursiveRange(root.left, low, high);
        recursiveRange(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        recursiveRange(root, low, high);
        return sum;
    }

    public int numSteps(String s) {
        int N = s.length();
        int ops = 0;
        int carry = 0;
        for(int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if(digit % 2 == 1) {
                ops += 2;
                carry = 1;
            } else {
                ops++;
            }
        }
        return ops + carry;
    }

    
    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];
        prefixXOR[0] = 0;
        System.arraycopy(arr, 0, prefixXOR, 1, arr.length);
        int size = prefixXOR.length;
        int count = 0;

        // Performing XOR operation on the array elements
        for (int i = 1; i < size; ++i) prefixXOR[i] ^= prefixXOR[i - 1];

        // Maps to store counts and totals of XOR values encountered
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefixXOR[i], 0) * (i - 1) -
            totalMap.getOrDefault(prefixXOR[i], 0);

            // Updating total count of current XOR value
            totalMap.put(
                prefixXOR[i],
                totalMap.getOrDefault(prefixXOR[i], 0) + i
            );
            countMap.put(
                prefixXOR[i],
                countMap.getOrDefault(prefixXOR[i], 0) + 1
            );
        }

        return count;
    }

    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i) {
            int curr_num = nums[i];
            boolean match_found = false;
            for(int j = 0; j < list.size(); ++j) {
                if(list.get(j) == curr_num) {
                    match_found = true;
                    list.remove(j);
                }
            }
            if(!match_found) {
                list.add(curr_num);
            }
        }
        int[] result = new int[2];
        for(int i = 0; i < 2; ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for(int digit = 1; digit < 9; ++digit) {
            int num = digit;
            int next_digit = num + 1;

            while(num <= high && next_digit <= 9) {
                num = (num * 10) + next_digit;
                if(num >= low && num <= high) result.add(num);

                next_digit++;
            }
        }

        Collections.sort(result);
        return result;
    }

    void leafInOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return; 
        if(root.left == null && root.right == null) list.add(root.val);
        leafInOrder(root.left, list);
        leafInOrder(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1_list = new ArrayList<>();
        ArrayList<Integer> root2_list = new ArrayList<>();
        leafInOrder(root1, root1_list);
        leafInOrder(root2, root2_list);
        if(root1_list.equals(root2_list)) return true;
        return false;
    }

    public int scoreOfString(String s) {
        int result = 0;
        for(int i = 0; i < s.length() - 1; ++i) {
            result += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return result;
    }

    public void reverseString(char[] s) {
        for(int i = 0, j = s.length - 1; i <= j; ++i, --j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public int appendCharacters(String s, String t) {
        int t_pointer = 0, s_pointer = 0;
        while(t_pointer < t.length() && s_pointer < s.length()) {
            if(s.charAt(s_pointer) == t.charAt(t_pointer)) ++t_pointer;
            s_pointer++;
        }
        return t.length() - t_pointer;
    }

    public int romanCharToVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }

    public int romanToInt(String s) {
        int curr_largest_val = 1000;
        int result = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int new_value = romanCharToVal(c);
            // Subtraction needs to be used
            if(new_value > curr_largest_val) {
                result -= curr_largest_val; 
                result += new_value - curr_largest_val;
                curr_largest_val = new_value; 
            } else {
                result += new_value;
                curr_largest_val = new_value;
            }
        }
        return result;
    }

    public int longestPalindrome(String s) {
        int result = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        boolean freqFlag = false;
        for(int freq : freqMap.values()) {
            if(freq % 2 == 0) result += freq; 
            else {
                result += freq - 1;
                freqFlag = true;
            }
        }
        if(freqFlag) return result + 1;
        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnList = new ListNode();
        ListNode dummyList = returnList; 
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                dummyList.next = list1;
                list1 = list1.next;
            } else {
                dummyList.next = list2;
                list2 = list2.next;
            }
            dummyList = dummyList.next;
        }
        if(list1 != null) dummyList.next = list1;
        if(list2 != null) dummyList.next = list2; 
        return returnList.next; 
    }

    public List<String> commonChars(String[] words) {
        // Count characters in the first word
        int[] last = count(words[0]);
        
        // Update the count array by intersecting with each subsequent word
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        
        // Build the result list based on the final count array
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    // Calculate the intersection of two count arrays
    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    // Count the frequency of each character in a word
    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[c - 'a']++;
        }
        return t;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // HashMap to store the count of each card value
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count + 1);
        }

        for (int card : hand) {
            int startCard = card;
            // Find the start of the potential straight sequence
            while (cardCount.getOrDefault(startCard - 1, 0) > 0) {
                startCard--;
            }

            // Process the sequence starting from startCard
            while (startCard <= card) {
                while (cardCount.getOrDefault(startCard, 0) > 0) {
                    // Check if we can form a consecutive sequence
                    // of groupSize cards
                    for (
                        int nextCard = startCard;
                        nextCard < startCard + groupSize;
                        nextCard++
                    ) {
                        if (cardCount.getOrDefault(nextCard, 0) == 0) {
                            return false;
                        }
                        cardCount.put(nextCard, cardCount.get(nextCard) - 1);
                    }
                }
                startCard++;
            }
        }

        return true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        // Replace each word in sentence with the corresponding shortest root
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        // Find the shortest root of the word in the dictionary
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        // There is not a corresponding root in the dictionary
        return word;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }

    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int result = 0;
        for (int i = 0; i < heights.length; ++i) {
            if(heights[i] != expected[i]) result++;
        }
        return result;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(); 
        // Map values in arr1
        for (int i = 0; i < arr1.length; ++i) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        // Iterate through arr2, Build array as needed by getting map values
        int[] result = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i = 0; i < arr2.length * 2; ++i) {
            result[i] = arr2[index];
            for (int j = 0; j < map.getOrDefault(arr2[i], 0); ++j) {
                ++i;
                result[i] = arr2[index];
            }
            // Set map value as 0 each time
            map.put(arr2[i], 0);
        }
        return null;
        
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort both seats and students arrays
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for(int i = 0; i < seats.length; ++i) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }

    public int minIncrementForUnique(int[] nums) {
        return 0;
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> difficultyProfitMap = new HashMap<>();
        // Fill Map
        for (int i = 0; i < difficulty.length; ++i) {
            difficultyProfitMap.put(difficulty[i], profit[i]);
        }
        int result = 0;
        for (int i = 0; i < worker.length; ++i) {
            int currWorkerDiff = worker[i];
            while (difficultyProfitMap.getOrDefault(currWorkerDiff, 0) == 0) {
                currWorkerDiff--;
            }
            result += difficultyProfitMap.get(currWorkerDiff);
        }
        return result;
    }

    public int findCenter(int[][] edges) {
        int edge_0 = edges[0][0];
        int edge_1 = edges[0][1];
        if(edge_0 == edges[1][0] || edge_0 == edges[1][1]) return edge_0;
        else return edge_1;
    }

    public long maximumImportance(int n, int[][] roads) {
        long[] degrees = new long[n];

        for(int edge[] : roads) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        Arrays.sort(degrees);
        long value = 1;
        long totalImportance = 0;
        for(long degree : degrees) {
            totalImportance += value * degree;
            value++;
        }
        return totalImportance;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result_List = new ArrayList<>();
        result_List.add(new ArrayList<>());
        result_List.add(new ArrayList<>());
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0; i < nums1.length; ++i) {
            int num = nums1[i];
            if(i > 0 && num == nums1[i - 1]) continue;
            result_List.get(0).add(num);
        }
        for(int i = 0; i < nums2.length; ++i) {
            int num = nums2[i];
            if(i > 0 && num == nums2[i - 1]) continue;
            if(result_List.get(0).indexOf(num) != -1) {
                result_List.get(0).remove(result_List.get(0).indexOf(num));
            }
            else {
                result_List.get(1).add(num);
            }
        }
        return result_List;
    }

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[nums.length - 1];
        int result = 0;
        // Iterate between small/large using two pointers
        for (int i = 1, j = nums.length - 2; i < j; ++i, --j) {
            if(nums[i] != smallest) result++;
            if(i != j && nums[j] != largest) result++;
        }
        return result;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n < original.length) return new int[][]{}; 
        int[][] result_Array = new int[m][n];
        int counter = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                result_Array[i][j] = original[counter];
                ++counter;
            }
        }
        return result_Array;
    }

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        char last_char = s.charAt(0);
        int counter = 0;
        result.append(s.charAt(0));
        for(int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(last_char == c) {
                counter++;
            }
            else {
                counter = 0;
            }
            if(counter < 2) {
                result.append(c);
            }
            last_char = c;
        }
        return result.toString();
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int counter = 0;
        for(int num : arr) {
            if (num % 2 != 0) {
                if(counter == 2) {
                    return true;
                }
                counter++;
            }
            else {
                counter = 0;
            }
        }
        return false;
    }

    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
    
    public List<String> stringMatching(String[] words) {
        List<String> stringMatching = new LinkedList<>();
        for(int i = 0; i < words.length; ++i) {
            String word = words[i];
            for(int j = 0; j < words.length; ++j) {
                if(i == j) continue;
                String comparedWord = words[j];
                if(comparedWord.contains(word)) {
                    stringMatching.add(word);
                }
            }
        }
        return stringMatching;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // Pointer to nums1, nums2, and index for return array respectivally
        int p_nums1 = 0, p_nums2 = 0, final_index = 0;
        while(p_nums1 < nums1.length && p_nums2 < nums2.length) {
            if(nums1[p_nums1] < nums2[p_nums2]) {
                ++p_nums1;
            } else if (nums1[p_nums1] > nums2[p_nums2]) {
                ++p_nums2;
            } else {
                nums1[final_index++] = nums1[p_nums1++];
                ++p_nums2;
            }
        }
        return Arrays.copyOfRange(nums1, 0, final_index);
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode resultHead = new ListNode();
        ListNode dummyHead = new ListNode();
        // store pointer to start of ListNode
        resultHead.next = dummyHead; 
        while(head != null) {
            if(head.val == 0) {
                int result = 0;
                // zero with no partner found at end of list
                if(head.next == null) break;
                head = head.next;
                // iterate until next zero is found or final node is called
                while(head.val != 0 && head.next != null) {
                    result += head.val;
                    head = head.next;
                }
                // if a subsuquent zero is found, take out zero and store result as a listnode
                if(head.val == 0 && result != 0) {
                    dummyHead.val = result;
                } else {
                    // else, no sub zero is found so break
                    break;
                }
            } else {
                dummyHead.val = head.val;
            }
            if(head.next == null) break;
            dummyHead.next = new ListNode();
            dummyHead = dummyHead.next;
            if(head.val != 0) head = head.next;
        }
        return resultHead.next;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int list_size = 1;
        List<Integer> critList = new ArrayList<>();
        int last_value = 0;
        while(head != null && head.next != null) {
            ListNode tempHead = head.next; 
            if(head.val > last_value && head.val > tempHead.val) {
                critList.add(head.val);
            } else if(head.val < last_value && head.val < tempHead.val) {
                critList.add(head.val);
            }
            head = head.next;
            list_size++;
        }
        if(list_size < 3) return new int[]{-1, 1};
        int[] result = new int[critList.size()];
        for(int i = 0; i < critList.size(); ++i) {
            result[i] = critList.get(i);
        }
        return result;
    }

    public int passThePillow(int n, int time) {
        // pillow is passed a full lap
        while(time > (n-1) * 2) {
            time -= (n - 1) * 2;
        }
        boolean wayFlag = false; // left to right is false, right to left is true
        while(time > (n - 1)) {
            time -= n - 1;
            wayFlag = !wayFlag;
        }
        if(!wayFlag) {
            return 1 + time;
        } else {
            return n - time;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<String> feedback_list = new ArrayList<>();
        Map<Integer, Integer> scores_map = new HashMap<>();// student_score -> student_id
        for(String str : positive_feedback) {
            feedback_list.add(str);
        }
        for(String str : negative_feedback) {
            feedback_list.add(str);
        }
        int[] scores = new int[student_id.length];
        for(int i = 0; i < student_id.length; ++i) {
            String student_report = report[i];
            int student_score = 0;
            for(String feedback : feedback_list) {
                if(student_report.contains(feedback)) {
                    if(feedback_list.indexOf(feedback) < positive_feedback.length) {
                        student_score += 3;
                    } else if(feedback_list.indexOf(feedback) >= positive_feedback.length) {
                        student_score--;
                    }
                }
            }
            while(scores_map.get(student_score) != null) {
                student_score--;
            }
            scores_map.put(student_score, student_id[i]);
            scores[i] = student_score;
        }
        List<Integer> result_list = new ArrayList<>();
        Arrays.sort(scores);
        for(int i = 0; i < k; ++i) {
            result_list.add(scores_map.get(scores[scores.length - i - 1])); 
        }
        return result_list;
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while(numBottles >= numExchange) {
            result += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return result;
    }
}
