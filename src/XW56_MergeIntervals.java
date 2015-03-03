import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class XW56_MergeIntervals {
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> ans = new ArrayList<Interval>();
    	
    	// First sort
    	Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval arg0, Interval arg1) {
				if(arg0.start < arg1.start) return -1;
				else if(arg0.start > arg1.start) return 1;
				else return arg0.end - arg1.end;
			}
    		
    	});
    	
    	// Empty 
    	if(intervals == null || intervals.size() == 0) return ans;
    	
    	Interval pt = null;
    	
    	for(int i = 0; i < intervals.size(); i++) {
    		Interval cur = intervals.get(i);
    		
    		if(pt == null) {
    			pt = cur;
    			continue;
    		}
    		
    		if(pt.end < cur.start) {
    			ans.add(pt);
    			pt = cur;
    		} else if(pt.end >= cur.start) {
    			int start = pt.start < cur.start ? pt.start : cur.start;
    			int end = pt.end > cur.end ? pt.end : cur.end;
    			
    			pt = new Interval(start, end);
    		}
    	}
    	
    	if(pt != null) {
    		ans.add(pt);
    	}
    	
    	return ans;
    }

	public static void main(String[] args) {
		XW56_MergeIntervals so = new XW56_MergeIntervals();
		
		Interval i1 = new Interval(1,4);
		Interval i2 = new Interval(4,6);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1); list.add(i2);
		
		System.out.println(so.merge(list));

	}

}
