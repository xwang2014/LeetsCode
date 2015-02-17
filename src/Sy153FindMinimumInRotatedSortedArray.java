public class Sy153FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if(num==null||num.length==0)
            return 0;
        if(num.length==1)
            return num[0];
            
        //log(n)
        return findMin(num, 0, num.length-1);
    }
    
    public int findMin(int[] num, int start, int end){
        
        if(start == end)
            return num[start];
        if(start>end)
            return Integer.MAX_VALUE;
        int mid = (start + end)/2;
        
        int min = 0;
        if(num[mid]>num[start]){
            
            min = num[start];
            min = Math.min(min, findMin(num, mid+1,end));
        }else if(num[mid]<num[start]){
            
            min = num[mid];
            min = Math.min(min, findMin(num, start, mid-1));
        }else {
            
            min = Math.min(num[start], num[end]);
        }
        
        return min;
    }

}