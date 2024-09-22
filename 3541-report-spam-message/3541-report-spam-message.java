public class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedSet = new HashSet<>();
        
        for (String word : bannedWords) {
            bannedSet.add(word);
        }
        
        int spamCount = 0;
        
        for (String word : message) {
            if (bannedSet.contains(word)) {
                spamCount++;
            }
            if (spamCount >= 2) {
                return true;
            }
        }
        
        return false;
    }
}