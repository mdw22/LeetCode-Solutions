package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
            
    }
}
