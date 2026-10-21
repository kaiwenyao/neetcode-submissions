class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m, n = len(num1), len(num2)
        res = [0] * (m + n)
        a = [ord(c) - ord("0") for c in reversed(num1)]
        b = [ord(c) - ord("0") for c in reversed(num2)]

        for i in range(m):
            for j in range(n):
                res[i + j] += a[i] * b[j]

        carry = 0
        for i in range(m + n):
            cur = carry + res[i]
            carry = cur // 10
            res[i] = cur % 10

        while len(res) > 1 and res[-1] == 0:
            res.pop()

        return "".join(map(str, reversed(res)))
