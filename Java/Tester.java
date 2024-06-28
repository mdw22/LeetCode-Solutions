package Java;
import java.util.Random;

import Java.Solution;

public class Tester {
    static Random RAND = new Random(); 
    static Solution SOL = new Solution();

    // Generates a random set of integers with a given size
    public int[] integerArrayGen(int size) {   
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = RAND.nextInt(1000);
        }
        return arr;
    }

    // Generates a random set of doubles with a given size
    public double[] doubleArrayGen(int size) {
        double[] arr = new double[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = RAND.nextDouble(1000);
        }
        return arr;
    }

    // Generates a random string with a given length
    public String randomStringGen(int length) {
        String result = "";
        for(int i = 0; i < length; ++i) {
            result += (char)(RAND.nextInt(97, 122));
        }
        return result;
    }

    // Generates a random set of random strings with given length
    public String[] randomStringArrGen(int arrlen, int length) {
        String[] result = new String[arrlen];
        for(int i = 0; i < arrlen; ++i) {
            result[i] = randomStringGen(length);
        }
        return result;
    }

    // Generates random values for a listnode tree specified by length
    public ListNode randomListNodeTree(int length) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        for(int i = 0; i < length; ++i) {
            dummy.next = new ListNode(RAND.nextInt(1000));
            dummy = dummy.next;
        }
        return result.next;
    }

    // Generates sorted random values for listnode tree specified by length 
    public ListNode randomSortedListNodeTree(int length) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        for(int i = 0; i < length; ++i) {
            dummy.next = new ListNode(RAND.nextInt(0, i));
            dummy = dummy.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        
    }
}
