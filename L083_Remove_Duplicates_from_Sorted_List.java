package LeetCode;

public class L083_Remove_Duplicates_from_Sorted_List {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode node = head;

		while (node.next != null) {

			if (node.val != node.next.val) {
				node = node.next;
			} else {
				while (node.next != null && node.val == node.next.val) {
					node.next = node.next.next;
				}
			}
		}

		return head;
	}

}
