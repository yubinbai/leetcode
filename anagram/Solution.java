// Given an array of strings, return all groups of strings that are anagrams.

// Note: All inputs will be in lower-case.
import java.util.*;
public class Solution {

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (hm.containsKey(tempStr)) {
                hm.get(tempStr).add(s);
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(s);
                hm.put(tempStr, tempList);
            }
        }

        for (ArrayList<String> list : hm.values()) {
            if (list.size() > 1) {
                for (String str : list) {
                    result.add(str);
                }
            }
        }
        return result;
    }
}