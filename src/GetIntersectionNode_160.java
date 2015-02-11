
public class GetIntersectionNode_160 {
    // Q160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        if(headA == null || headB == null ) {
            return null;
        }
        if(headA.val == headB.val) return headA;
        
        // Step 1, find the tail of the list.
        // connect it to headB. to make it a fast-slow-runner problem
        ListNode tail = null;
        ListNode cur = headB;
        while(cur.next != null) {
            cur = cur.next;
        }
        tail = cur;
        
        cur.next = headB;
        
        // Step 2 Check if there is a intersection
        cur = headA;
        boolean flag = false;
        while(cur.next != null) {
            cur = cur.next;
            if(cur == tail) {
                flag = true;
                break;
            }
        } 
        if(!flag) {
            tail.next = null;
            return null;
        }
        
        // Step 3 fast-slow runner to find the intersection
        ListNode fast = headA, slow = headA;
        
        fast = fast.next.next;
        slow = slow.next;
        while(fast.val != slow.val) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                tail.next = null;
                return null;
            }
            if(slow.next != null) {
                slow = slow.next;
            } else {
                tail.next = null;
                return null;
            }
        }
        
        cur = headA;
        while(fast.val != cur.val) {
            fast = fast.next;
            cur = cur.next;
        }
        
        tail.next = null;
        return cur;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
