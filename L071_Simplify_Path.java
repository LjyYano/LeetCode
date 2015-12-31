package LeetCode;

import java.util.LinkedList;

public class L071_Simplify_Path {

	public String simplifyPath(String path) {

		if (path == null) {
			return null;
		}

		String[] names = path.split("/");

		int eat = 0;

		LinkedList<String> stack = new LinkedList<String>();

		for (int i = names.length - 1; i >= 0; i--) {

			String token = names[i];

			// token是".."， 表示上级路径，前一个路径不打印
			// token是"."， 表示当前路径，自身不打印
			// token是"", 表示为两个"/"相连，不做操作
			// eat>0，表示左边不打印
			// 否则，将token入栈
			if (token.equals("..")) {
				eat++;
			} else if (token.equals(".")) {
				// do nothing
			} else if (token.equals("")) {
				// do nothing
			} else {

				if (eat > 0) {
					eat--;
				} else {
					stack.push(token);
				}
			}
		}

		StringBuilder s = new StringBuilder();

		s.append("/");

		// 最后一个不加"/"，所以while判断条件是>1
		while (stack.size() > 1) {
			s.append(stack.pop());
			s.append("/");
		}

		// 最后一个不加"/"
		if (!stack.isEmpty()) {
			s.append(stack.pop());
		}

		return s.toString();
	}

}
