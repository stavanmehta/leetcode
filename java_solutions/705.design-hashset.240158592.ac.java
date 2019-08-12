/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 *
 * https://leetcode.com/problems/design-hashset/description/
 *
 * algorithms
 * Easy (54.88%)
 * Total Accepted:    25.1K
 * Total Submissions: 45.8K
 * Testcase Example:  '["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]\n' +
  '[[],[1],[2],[1],[3],[2],[2],[2],[2]]'
 *
 * Design a HashSet without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * 
 * add(value): Insert a value into the HashSet. 
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in
 * the HashSet, do nothing.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);         
 * hashSet.add(2);         
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);          
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // returns false (already removed)
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 * 
 * 
 */
class MyHashSet {
    class Buckets{
        private int itemsNum;
        private int items[];
        
        public Buckets(){
            itemsNum = 1001;
            items = new int[itemsNum];
            init();
        }
        
        public void init(){
            for(int i = 0; i < itemsNum; i++)
                items[i] = -1;
        }
        
        public void setItem(int key,int value){
            int index = hashItem(key);
            items[index] = value;
        }
        
        public int getItem(int key){
            int index = hashItem(key);
            return items[index];
        }
        public int hashItem(int key){
            return key / bucketsNum;
        }
    }
    
    private int bucketsNum;
    private Buckets buckets[];
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketsNum = 1000;
        buckets = new Buckets[bucketsNum];
    }
    
    public int hashBucket(int key){
        return key % bucketsNum;
    }
    public void add(int key) {
        int bucketID = hashBucket(key);
        if(buckets[bucketID] == null) buckets[bucketID] = new Buckets();
        buckets[bucketID].setItem(key, key);
    }
    
    public void remove(int key) {
        int bucketID = hashBucket(key);
        if(contains(key)) buckets[bucketID].setItem(key, -1);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketID = hashBucket(key);
        return buckets[bucketID] != null && buckets[bucketID].getItem(key) != -1;
    }
}
