
public class XW168_ExcelSheetColumnTitle {

	// http://blog.csdn.net/u012162613/article/details/42059591
    public String convertToTitle(int n) {
        String ans = "";

        int base = 26;
        while(n > 0) {
            int r = (n % base);
            n = n / base;
            if(r == 0 ) {
            	n--;
            	r = 'Z' - 'A' + 1;
            }
            
            char c = (char) ('A' + r - 1);
            ans = c + ans;
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		XW168_ExcelSheetColumnTitle in = new XW168_ExcelSheetColumnTitle();
		
		System.out.println(in.convertToTitle(701));

	}

}
