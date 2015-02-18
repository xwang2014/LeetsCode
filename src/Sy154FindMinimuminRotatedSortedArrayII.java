
public class Sy154FindMinimuminRotatedSortedArrayII {
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
        if(start+1==end)
            return Math.min(num[start], num[end]);
            
        int mid = (start + end)/2;
        
        int min = 0;
        if(num[mid]>num[start]){
            
            min = num[start];
            min = Math.min(min, findMin(num, mid+1,end));
        }else if(num[mid]<num[start]){
            
            min = num[mid];
            min = Math.min(min, findMin(num, start, mid-1));
        }else {
            //num[mid]==num[start]
            if(num[mid]==num[end]){ //can't know, have to traverse both sides
                min = findMin(num, start, mid-1);
                int temp_min = findMin(num, mid+1, end);
                min = Math.min(min, temp_min);
            }
            else if(num[mid]<num[end]){ //right side is sorted
                int temp_min = findMin(num, start, mid-1);
                min = Math.min(temp_min, num[mid+1]);
            } 
            else if(num[mid]>num[end]) { //left side is sorted
                int temp_min = findMin(num, mid+1, end);
                min = Math.min(temp_min, num[start]);                
            }
        }
        return min;
    }
}
