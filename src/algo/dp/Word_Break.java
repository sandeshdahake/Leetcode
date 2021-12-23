package algo.dp;

import java.util.HashMap;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 * https://leetcode.com/problems/word-break/
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap();
        return wordBreakHelper(s, wordDict ,map);
    }

    public boolean wordBreakHelper(String s, List<String> wordDict, HashMap<String, Boolean> map){
        if(s.equals("")) return true;
        if(map.containsKey(s)) return map.get(s);

        for(String word:wordDict){
            if(s.indexOf(word) == 0){
                String prefix = s.substring(word.length());
                if(wordBreakHelper(prefix, wordDict ,map)){
                    map.put(prefix, true);
                    return map.get(prefix);
                }
            }
        }
        map.put(s, false);
        return map.get(s);
    }

}
