
class Solution {
    func busyStudent(_ startTime: [Int], _ endTime: [Int], _ queryTime: Int) -> Int {
        var result = 0
        for(startT, endT) in zip(startTime, endTime) {
            if queryTime >= startT && queryTime <= endT {
                result += 1
            }
        }
        return result
    }
}

