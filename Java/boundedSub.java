package Java;
import java.util.LinkedList;
import java.util.Queue;

public class boundedSub {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < nums.length; ++i) {
            if(q.peek() != null) {
                if(nums[i] <= right) {
                    q.add(i);
                    result += q.size();
                }
            }
            else if(nums[i] >= left || nums[i] <= right) {
                q.add(i);
                result += q.size();
            }
            else {
                q.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
