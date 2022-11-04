package im.engure.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SeizalAndDeSeizal {

	public static void main(String[] args) {

		Node h = new Node(100);
		Node n1 = new Node(0);
		Node n2 = new Node(150);
		Node n3 = new Node(-222222);
		Node n4 = new Node(50);
		h.left=n1;
		n1.left=n3;
		n1.right=n4;
		Node n5 = new Node(120);
		Node n6 = new Node(55555555);
		Node n7 = new Node(180);
		h.right=n2;
		n2.left=n5;
		n2.right=n6;
		n6.left=n7;

//		printQueue(preSerial(h));
//		preSerial2(h);
//		Node preDeSerial = preDeSerial(preSerial(h));
//		PrintTree.printBinaryTree(preDeSerial, 0, "H");
		Queue<Node> q = levelSerial(h);
//		printQueue(q);
		System.out.println(q);
		Node h2 = levelDeSerial(q);
		PrintTree.printBinaryTree(h2, 0, "H");

	}

	/**
	 * 打印队列preSerial
	 * @param preSerial
	 */
	private static void printQueue(Queue<Node> preSerial) {
		System.out.println("head --> tail:");
		while (!preSerial.isEmpty()) {
			Node n = preSerial.poll();
			if (n == null) {
				System.out.print("null ");
			} else {
				System.out.print(n.val + " ");
			}
		}
		System.out.println();
	}

	// 递归序列化
	private static Queue<Node> preSerial(Node h) {
		Queue<Node> ans = new LinkedList<Node>();
		pre(h, ans);
		return ans;
	}

	private static void pre(Node h, Queue<Node> ans) {
		ans.add(h);
		if (h != null) {
			pre(h.left, ans);
			pre(h.right, ans);
		}
	}

	// 非递归实现序列化
	private static void preSerial2(Node h) {
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			Queue<Node> queue = new LinkedList<Node>();
			while (!stack.empty() || h!=null) {
				if (h != null) {
					stack.push(h);
					queue.add(h);
					h = h.left;
				} else {
					queue.add(null);
					Node n = stack.pop();
					h = n.right;
				}
			}
			queue.add(null);
			printQueue(queue);
		}
	}

	// 通过前序遍历序列构造树
	private static Node preDeSerial(Queue<Node> queue) {
		Node n = queue.poll();
		if (n != null) {
			n.left = preDeSerial(queue);
			n.right = preDeSerial(queue);
		}
		return n;
	}


	// 后序 递归 序列化 和 反序列化
	private static Queue<Node> postSerial(Node h) {
		Queue<Node> ans = new LinkedList<Node>();
		post(h, ans);
		return ans;
	}

	private static void post(Node h, Queue<Node> ans) {
		if (h == null) {
			ans.add(null);
		} else {
			post(h.left, ans);
			post(h.right, ans);
			ans.add(h);
		}
	}

	private static Node postDeSerial(Queue<Node> queue) {
//		后续的反序列化？ 队头为null，不能反序列化。
		return null;
	}


	// ========================

	// 层序遍历序列化 非递归方法
	// 层序遍历的改进：考虑空位
	private static Queue<Node> levelSerial(Node h) {
		Queue<Node> ans = null;
		if (h != null) {
			Queue<Node> queue = new LinkedList<Node>();
			ans = new LinkedList<Node>();

			queue.add(h);
			ans.add(h);
			while (!queue.isEmpty()) {
				Node n = queue.poll();
				ans.add(n.left);
				ans.add(n.right);
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}
		return ans;
	}

	// 层序遍历反序列化 非递归方式
	private static Node levelDeSerial(Queue<Node> queue) {
		if (queue == null || queue.isEmpty()) {
			return null;
		}
		return deSerial(queue);
	}

	private static Node deSerial(Queue<Node> queue) {
		if (queue == null || queue.isEmpty()) {
			return null;
		}
		Node h = generateNode(queue.poll());
		Queue<Node> q2 = new LinkedList<Node>();
		q2.add(h);
		while (!q2.isEmpty()) {
			Node n = q2.poll();
			n.left = generateNode(queue.poll());
			n.right = generateNode(queue.poll());
			if (n.left != null) {
				q2.add(n.left);
			}
			if (n.right != null) {
				q2.add(n.right);
			}
		}
		return h;
	}

	private static Node generateNode(Node n) {
		Node node = null;
		if (n != null) {
			node = new Node(n.val);
		}
		return node;
	}

}







