class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();

        for(char c: s.toCharArray()){
            m.put(c, m.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()){
            m.put(c, m.getOrDefault(c, 0)-1);
        }

        for(Map.Entry<Character, Integer> entry: m.entrySet()){
            if(entry.getValue() != 0) return false;
        }

        return true;
    }
}
