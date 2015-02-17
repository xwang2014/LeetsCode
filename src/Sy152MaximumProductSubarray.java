public class Sy152MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if(A==null||A.length==0)
            return 0;
        if(A.length==1)
            return A[0];
        
        int max = A[0];
        int localMax = A[0];
        int localMin = A[0];
        
        for(int i=1; i<A.length; i++){
            
            if(A[i]==0){
                
                localMax = 1;
                localMin = 1;
                if(A[i]>max)
                    max = A[i];
            }
            else{
                int temp = localMax;
                localMax = Math.max(Math.max(localMax*A[i], localMin*A[i]), A[i]);
                localMin = Math.min(Math.min(temp*A[i], localMin*A[i]), A[i]);
           
                if(localMax > max)
                    max = localMax;
            }
        }
        
        return max;
    }
}