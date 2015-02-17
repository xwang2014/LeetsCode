
public class XW162_FindPeakElement {
    // http://blog.csdn.net/u010367506/article/details/41943309
    
    public int findPeakElement(int[] num) {
        int l = 0, r = num.length - 1;
        while(l <= r) {
            if(l == r) return l;
            
            int mid = (l + r) / 2;
            
            if(num[mid] < num[mid + 1]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        } 
        
        return -1;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
