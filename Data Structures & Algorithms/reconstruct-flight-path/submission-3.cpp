class Solution {
    unordered_map<string, vector<string>> g;
    vector<string> res;

    void dfs(const string& node) {
        while (!g[node].empty()) {
            string nxt = g[node].back();
            g[node].pop_back();
            dfs(nxt);
        }
        res.push_back(node);
    }

   public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        sort(tickets.rbegin(), tickets.rend());  // 降序 → pop_back 取字典序最小
        for (auto& t : tickets) g[t[0]].push_back(t[1]);
        dfs("JFK");
        reverse(res.begin(), res.end());
        return res;
    }
};