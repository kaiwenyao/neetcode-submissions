class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {'(': ')',
        '[': ']',
        '{': '}'
        }
        stk = []
        for c in s:
            if c in pairs:
                stk.append(pairs[c])
            elif not stk or stk.pop() != c:
                return False
        return len(stk) == 0