class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        
        r = len(nums) - 1
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        return -1 if nums[l] != target else l