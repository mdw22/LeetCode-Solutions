#include <vector> 
#include <map>

class Solution {
    public:
    int subarraysWithKDistinct(std::vector<int>& nums, int k) {
        std::vector<int> distinctCount(nums.size() + 1, 0);
        int totalCount = 0;
        int left = 0;
        int right = 0;
        int currCount = 0;
        
        while (right < nums.size()) {
            // Increment count
            if(++distinctCount[nums[right++]] == 1) {
                k--;
            }

            if(k < 0) {
                --distinctCount[nums[left++]];
                k++;
                currCount = 0;
            }

            if(k == 0) {
                while(distinctCount[nums[left]] > 1) {
                    --distinctCount[nums[left++]];
                    currCount++;
                }
                totalCount += (currCount + 1);
            }
        }
        return totalCount;
    }

    int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles; 
        while(numBottles >= numExchange) {
            result += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return result;
    }

    int busyStudent(std::vector<int>& startTime, std::vector<int>& endTime, int queryTime) {
        int numStudents = 0;
        for(int i = 0; i < startTime.size(); ++i) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]) numStudents++;
        }
        return numStudents;
    }

    std::vector<int> twoSum(std::vector<int>& nums, int target) {
            std::map<int, int> map;
            for(int i = 0; i < nums.size(); ++i) {
                int complement = target - nums[i];
                if (map.find(complement) != map.end()) {
                    return std::vector<int> {map[complement], i};
                }
                map[nums[i]] = i;
            }
            return{};
    }
};

int main() {
    
}