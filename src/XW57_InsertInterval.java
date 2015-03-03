import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class XW57_InsertInterval {
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> ans = new LinkedList<Interval>();
        
        boolean merged = false;
        
        for(int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            
            if(cur.end < newInterval.start) {
                ans.add(cur);
            } else if(newInterval.end < cur.start) {
                if(!merged) {
                	ans.add(newInterval);
                	merged = true;
                }
                
                ans.add(cur);
            } else if(newInterval.end > cur.start || newInterval.start < cur.end) {
                int start = newInterval.start < cur.start ? newInterval.start : cur.start;
                int end = newInterval.end > cur.end ? newInterval.end : cur.end;
                Interval overlapped = new Interval(start, end);
                newInterval = overlapped;
            }
        }
        if(!merged) ans.add(newInterval);
        
        return ans;
    }

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(2,5));
		list.add(new Interval(6,7));
		list.add(new Interval(8,9));
		
		Interval i = new Interval(0,1);
		
		XW57_InsertInterval so = new XW57_InsertInterval();
		so.insert(list, i);
		
	}

}
