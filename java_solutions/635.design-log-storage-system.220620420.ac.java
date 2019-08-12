/*
 * @lc app=leetcode id=635 lang=java
 *
 * [635] Design Log Storage System
 *
 * https://leetcode.com/problems/design-log-storage-system/description/
 *
 * algorithms
 * Medium (55.32%)
 * Total Accepted:    11.4K
 * Total Submissions: 20.7K
 * Testcase Example:  '["LogSystem","put","put","put","retrieve","retrieve"]\n' +
  '[[],[1,"2017:01:01:23:59:59"],[2,"2017:01:01:22:59:59"],[3,"2016:01:01:00:00:00"],["2016:01:01:01:01:01","2017:01:01:23:00:00","Year"],["2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"]]'
 *
 * You are given several logs that each log contains a unique id and timestamp.
 * Timestamp is a string that has the following format:
 * Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All
 * domains are zero-padded decimal numbers. 
 * 
 * Design a log storage system to implement the following functions:
 * 
 * void Put(int id, string timestamp): Given a log's unique id and timestamp,
 * store the log in your storage system.
 * 
 * int[] Retrieve(String start, String end, String granularity): Return the id
 * of logs whose timestamps are within the range from start to end. Start and
 * end all have the same format as timestamp. However, granularity means the
 * time level for consideration. For example, start = "2017:01:01:23:59:59",
 * end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to
 * find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 * 
 * Example 1:
 * 
 * put(1, "2017:01:01:23:59:59");
 * put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return
 * [1,2,3], because you need to return all logs within 2016 and 2017.
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return
 * [1,2], because you need to return all logs start from 2016:01:01:01 to
 * 2017:01:01:23, where log 3 is left outside the range.
 * 
 * 
 * 
 * Note:
 * 
 * There will be at most 300 operations of Put or Retrieve.
 * Year ranges from [2000,2017]. Hour ranges from [00,23].
 * Output for Retrieve has no order required.
 * 
 * 
 */
class LogSystem {
    ArrayList<long[]> list;
    public LogSystem() {
        list = new ArrayList<long[]>();
    }
    
    public void put(int id, String timestamp) {
        int[] storage = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
        list.add(new long[]{convert(storage), id});
    }
    
     public long convert(int[] st) {
        st[1] = st[1] - (st[1] == 0 ? 0 : 1);
        st[2] = st[2] - (st[2] == 0 ? 0 : 1);
        return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60 + st[3] * 60 * 60 + st[4] * 60 + st[5];
    }
    
    public long granularity(String s, String gra, boolean end) {
        HashMap<String, Integer> map = new HashMap();
        map.put("Year",0);
        map.put("Month",1);
        map.put("Day",2);
        map.put("Hour",3);
        map.put("Minute",4);
        map.put("Second",5);
        String[] result = new String[] {"1999","00","00","00","00","00"};
        String[] st = s.split(":");
        for (int i = 0; i <= map.get(gra); i++) 
            result[i] = st[i];
        int[] t = Arrays.stream(result).mapToInt(Integer::parseInt).toArray();
        if (end)
            t[map.get(gra)]++;
        return convert(t);
            
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        ArrayList<Integer> result = new ArrayList();
        long start = granularity(s, gra, false);
        long end = granularity(e, gra, true);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] >= start && list.get(i)[0] < end) 
                result.add((int) list.get(i)[1]);
        }
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
