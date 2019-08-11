/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (32.15%)
 * Total Accepted:    87.9K
 * Total Submissions: 273.5K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * Note:
 * 
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 * 
 * 
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        result.add("JFK");
        if (tickets == null || tickets.length == 0)
            return result;
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] t1, String[] t2) {
                int result = t1[0].compareTo(t2[0]);
                if (result == 0)
                    return t1[1].compareTo(t2[1]);
                else
                    return result;
            }
        });
        buildDFS(tickets, visited, result);
        return result;
    }
    
    public boolean buildDFS(String[][] tickets, boolean[] visited, List<String> result) {
        String origin = result.get(result.size()-1);
        if (tickets.length+1 == result.size())
            return true;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(origin) && !visited[i]) {
                visited[i] = true;
                result.add(tickets[i][1]);
                if (buildDFS(tickets, visited, result))
                    return true;
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
        return false;
    }
}
