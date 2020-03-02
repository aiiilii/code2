import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String keyString = new String(chars);
            if (map.containsKey(keyString)) {
                ArrayList<String> tempList = map.get(keyString);
                tempList.add(s);
                map.put(keyString, tempList);
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(s);
                map.put(keyString, tempList);
            }            
        }
        
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}