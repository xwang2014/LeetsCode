import java.util.Arrays;

/**
 * 
 * @author xin
 *
 */
public class CompareVersion_165 {

	// input strings are non-empty and 
	// contain only digits and the . character
    public int compareVersion(String version1, String version2) {
    	// When use . in regExp, watch for escape char \\
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int i = 0;
        for(; i < v1.length || i < v2.length ; i++) {
            int one = 0;
            if(i < v1.length) one = Integer.parseInt(v1[i]);
            int two = 0;
            if(i < v2.length) two = Integer.parseInt(v2[i]);
            
            if(one > two) return 1;
            if(one < two) return -1;
        }
        
        return 0;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersion_165 so = new CompareVersion_165();
		int res = so.compareVersion("1", "1.0.1");
		System.out.println(res);
		
	}

}
