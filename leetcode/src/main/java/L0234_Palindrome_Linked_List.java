import common.ListNode;

public class L0234_Palindrome_Linked_List {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;

		// �ҵ������е�
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// ��ת�������
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

		// ǰ��תtail��head
		tail.next = head;
		head.next = null;

		return reversed;

	}

}
