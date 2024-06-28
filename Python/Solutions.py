# Code by Michael White, 2024
from collections import defaultdict
from typing import List
import pandas as pd
import numpy as np

class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        ans = odds = 0
        freq = defaultdict(int)
        freq[0] = 1
        for num in nums:
            odds += num % 2
            ans += freq[odds - k]
            freq[odds] += 1
        
        return ans
    
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        evens = []
        odds = []
        output = []
        for num in nums:
            if(num % 2 == 0):
                evens.append(num)
            else:
                odds.append(num)
        for i in range(len(evens)):
            output.append(evens[i])
            output.append(odds[i])
        return output
    