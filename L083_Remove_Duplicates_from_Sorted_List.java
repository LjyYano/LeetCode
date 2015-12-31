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

			// 如果元素不重复，跳过
			if (node.val != node.next.val) {
				node = node.next;
			} else {
				// 重复，则跳过下一个
				while (node.next != null && node.val == node.next.val) {
					node.next = node.next.next;
				}
			}
		}

		return head;
	}

}
