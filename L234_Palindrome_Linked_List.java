package LeetCode;

public class L234_Palindrome_Linked_List {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;

		// 找到链表中点
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 翻转后段链表
		ListNode tail = reverseList(slow);

		while (head != slow) {
			if (head.val != tail.val) {
				return false;
			}
			head = head.next;
			tail = tail.next;
		}

		return true;
	}

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode tail = head.next;
		ListNode reversed = reverseList(head.next);

		// 前后翻转tail和head
		tail.next = head;
		head.next = null;

		return reversed;

	}

}
