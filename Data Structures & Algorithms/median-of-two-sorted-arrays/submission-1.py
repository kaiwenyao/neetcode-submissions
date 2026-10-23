class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        m, n = len(nums1), len(nums2)
        left = (m + n + 1) >> 1
        INF = float('inf')

        l, r = 0, m                      # i 的取值范围是 [0, m]
        while l <= r:
            i = (l + r) >> 1
            j = left - i
            L1 = nums1[i - 1] if i > 0 else -INF
            R1 = nums1[i]     if i < m else INF
            L2 = nums2[j - 1] if j > 0 else -INF
            R2 = nums2[j]     if j < n else INF

            if L1 <= R2 and L2 <= R1:    # 找到合法划分
                if (m + n) % 2:
                    return max(L1, L2)
                return (max(L1, L2) + min(R1, R2)) / 2
            elif R1 < L2:                # i 太小，往右
                l = i + 1
            else:                        # i 太大，往左
                r = i - 1