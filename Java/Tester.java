package Java;
import java.util.Random;

import Java.Solution;

public class Tester {
    Random RAND = new Random(); 

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
            result += (RAND.nextInt(97, 122)) - '0';
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.findMaxK(new int[]{-10,8,6,7,-2,-3});
        System.out.println("Output of the called function : " + result); 
    }
}
