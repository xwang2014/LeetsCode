
public class XW171_ExcelSheetColumnNumber {
	
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
       
        int len = s.length();
        
        int base = 1;
        int ans = 0;
        for(int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            ans += (c - 'A' + 1) * base;
            base *= 26;
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
