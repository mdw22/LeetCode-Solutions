#include <map>
#include <vector>
class Solution {
    public:
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