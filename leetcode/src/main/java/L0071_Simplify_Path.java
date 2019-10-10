import java.util.LinkedList;

public class L0071_Simplify_Path {

	public String simplifyPath(String path) {

		if (path == null) {
			return null;
		}

		String[] names = path.split("/");

		int eat = 0;

		LinkedList<String> stack = new LinkedList<String>();

		for (int i = names.length - 1; i >= 0; i--) {

			String token = names[i];

			// token��".."�� ��ʾ�ϼ�·����ǰһ��·������ӡ
			// token��"."�� ��ʾ��ǰ·����������ӡ
			// token��"", ��ʾΪ����"/"��������������
			// eat>0����ʾ��߲���ӡ
			// ���򣬽�token��ջ
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

		// ���һ������"/"������while�ж�������>1
		while (stack.size() > 1) {
			s.append(stack.pop());
			s.append("/");
		}

		// ���һ������"/"
		if (!stack.isEmpty()) {
			s.append(stack.pop());
		}

		return s.toString();
	}

}
