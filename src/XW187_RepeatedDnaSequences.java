import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class XW187_RepeatedDnaSequences {
	
	// refer http://yuanhsh.iteye.com/blog/2185976
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ans = new ArrayList<String>();
		if(s == null || s.length() < 10) return ans;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		for(int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			
			int n = 0;
			for(int k = 0; k < 10; k++) {
				n = (n << 2) + map.get(sub.charAt(k));
			}
			Integer in = dict.get(n);
			if(in == null) {
				dict.put(n, 1);
			} else if(in == 1) {
				ans.add(sub);
				dict.put(n, 2);
			} else {
				dict.put(n, in + 1);
			}
		}
		
		return ans;
	}
	
	/*
	 * MLE
    public List<String> findRepeatedDnaSequences(String s) {
    	if(s.length() < 10) return new ArrayList<String>();
    	
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
            }
        }
        
        List<String> ans = new ArrayList<String>();
        
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            if(map.get(key) > 1) {
                ans. add(key);
            }
        }
        
        return ans;
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "CAAAAAAAAAC";//"AAAAAAAAAAA"; //"AAGATCCGTCCCCCCAAGATCCGTC";
		
		XW187_RepeatedDnaSequences so = new XW187_RepeatedDnaSequences();
		
		System.out.println(so.findRepeatedDnaSequences(input));
		
		int sum = 1;
		sum = sum << 2 + 1;
		System.out.println(sum);
	}

}
