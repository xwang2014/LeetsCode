/**
 * 
 * @author xin
 *
 */
public class MajorityElement_169 {
	/*
	 * This is the idea of Bloom Filter
	 */
    public int majorityElement(int[] num) {
        int majority = -1;
        int frequency = 0;
        
        for(int i = 0; i < num.length ; i++) {
            if(frequency <= 0) {
                frequency = 1;
                majority = num[i];
                continue;
            }
            
            if(num[i] != majority) {
                frequency--;
            } else {
                frequency++;
            }
        }
        
        return majority;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
