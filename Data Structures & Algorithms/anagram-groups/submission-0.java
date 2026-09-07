class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for(String s: strs){
            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            m.putIfAbsent(key, new ArrayList<>());
            m.get(key).add(s);
        }

        return new ArrayList<>(m.values());
    }
}
