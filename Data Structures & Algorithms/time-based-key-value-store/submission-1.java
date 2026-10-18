class TimeMap {

    class vSet {
        String value;
        int ts;
        public vSet(String value, int ts) {
            this.value = value;
            this.ts = ts;
        }
    }

    Map<String, List<vSet>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        } 
        map.get(key).add(new vSet(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<vSet> tmp = map.get(key);
        int l = 0;
        int r = tmp.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (tmp.get(mid).ts > timestamp) {
                r = mid - 1;
            }
            else {
                l = mid;
            }
        }
        return tmp.get(l).ts <= timestamp ? tmp.get(l).value : "";
        
        
    }
}
