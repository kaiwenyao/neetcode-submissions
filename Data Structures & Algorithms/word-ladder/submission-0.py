class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        g = defaultdict(list)
        for i1 in range(len(wordList)):
            s1 = wordList[i1]
            for i2 in range(i1 + 1, len(wordList)):
                s2 = wordList[i2]
                cnt = 0
                for i in range(len(s1)):
                    if s1[i] != s2[i]:
                        cnt += 1
                if cnt == 1:
                    g[s1].append(s2)
                    g[s2].append(s1)
        for s in wordList:
            cnt = 0
            for i in range(len(beginWord)):
                if beginWord[i] != s[i]:
                    cnt += 1
            if cnt == 1:
                g[beginWord].append(s)
        print(g)
        st = set()
        q = deque()
        q.append(beginWord)
        t = 1
        while len(q) > 0:
            si = len(q)
            while si > 0:
                cur = q.popleft()
                for nei in g[cur]:
                    if nei not in st:
                        if nei == endWord:
                            return t + 1
                        st.add(nei)
                        q.append(nei)
                si -= 1
            t += 1
        return 0

