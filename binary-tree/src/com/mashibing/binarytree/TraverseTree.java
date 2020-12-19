package com.mashibing.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseTree {

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
		
		//printRecursionSequence(h);
		
		/*
		 * System.out.print("pre order:"); preOrder(h); System.out.println();
		 * 
		 * System.out.print("in order:"); inOrder(h); System.out.println();
		 * 
		 * System.out.print("post order: "); postOrder(h); System.out.println();
		 * 
		 * System.out.print("level order:"); levelOrder(h); System.out.println();
		 */
		
		System.out.print("pre non-recurion:");
		preNonRecurion(h);
		System.out.println();
		
		System.out.print("in non-recurion:");
		inNonRecurion(h);
		System.out.println();
		
		System.out.print("post non-recurion:");
		postNonRecurion(h);
		System.out.println();
		
	}

	private static void postNonRecurion(Node h) {
		if (h != null) {
			//双栈打印后序遍历（前序的倒置）
			
			//1.将整个右边界从上到下节点的值入stack2，节点入stack
			//2.弹栈stack，对弹出节点的左子树重复 1.
			
			//stack2：100 150 55555 180 120 0 50 -22222，倒序为后序遍历
			Stack<Node> stack = new Stack<Node>();
			Stack<Integer> stack2 = new Stack<>();
			while (!stack.empty() || h!=null) {
				if (h != null) {
					stack2.push(h.val);
					stack.push(h);
					h = h.right;
				} else {
					Node n = stack.pop();
					h = n.left;
				}
				
			}
			while (!stack2.empty()) {
				System.out.print(stack2.pop() + " ");
			}
		}
		
	}

	private static void inNonRecurion(Node h) {
		// 1.整条左边界入栈
		// 2.左边界到头1.无法继续，则弹栈打印，来到右树继续执行1.
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.empty() || h!=null) {
				if (h != null) {
					stack.push(h);
					h = h.left;
				} else {
					Node n = stack.pop();
					System.out.print(n.val + " ");
					h = n.right;
				}
			}
		}
		
	}

	private static void preNonRecurion(Node h) {
		//1.打印压栈左边界
		//2.当1.不能继续时弹栈，对右子树执行1.
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.empty() || h!=null) {
				if (h != null) {
					System.out.print(h.val + " ");
					stack.push(h);
					h = h.left;
				} else {
					Node n = stack.pop();
					h = n.right;
				}
				
			}
		}
		
	}

	private static void levelOrder(Node h) {
		LinkedList<Node> q = new LinkedList<Node>();
//		q.pop();  删除首部第一个元素
//		q.add(e); 向尾部添加一个元素
		q.add(h);
		while (q.size() != 0) {
			Node n = q.pop();
			System.out.print(n.val + " ");
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
	}

	private static void postOrder(Node h) {
		if (h == null) {
			return;
		}
			
		postOrder(h.left);
		postOrder(h.right);
		System.out.print(h.val + " ");
	}

	private static void inOrder(Node h) {
		if (h == null) {
			return;
		}	
		inOrder(h.left);
		System.out.print(h.val + " ");
		inOrder(h.right);
	}

	private static void preOrder(Node h) {
		if (h == null) {
			return;
		}
			
		System.out.print(h.val + " ");
		preOrder(h.left);
		preOrder(h.right);
	}

	/**
	 * 打印递归序
	 * @param h 头节点
	 */
	private static void printRecursionSequence(Node h) {
		if (h == null) {
			return ;
		}
		//1.
		System.out.println(h.val + " [1]");
		//2.
		printRecursionSequence(h.left);
		System.out.println(h.val + " [2]");
		//3.
		printRecursionSequence(h.right);
		System.out.println(h.val + " [3]");
	}
	
	

}
