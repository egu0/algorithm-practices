package com.mashibing.binarytree;
/**
 * 获取二叉树某节点的后继节点
 * 
 * @author 菠萝蜜
 *
 */

public class NextNode {

	public static void main(String[] args) {
/*
			H100H
	     >0>	     		<150<
 >-222222>  <50<		>120>		<55555555<
 					    	  >180>		
 */
		Node h = new Node(100);
		Node n1 = new Node(0);
		Node n2 = new Node(150);
		Node n3 = new Node(-222222);
		Node n4 = new Node(50);
		n1.parent=h;
		n2.parent=h;
		n3.parent=n1;
		n4.parent=n1;
		h.left=n1;
		n1.left=n3;
		n1.right=n4;
		Node n5 = new Node(120);
		Node n6 = new Node(55555555);
		Node n7 = new Node(180);
		n5.parent=n2;
		n6.parent=n2;
		n7.parent=n6;
		h.right=n2;
		n2.left=n5;
		n2.right=n6;
		n6.left=n7;
		// -22222222 -> 0 -> 50 -> 100 -> 120 -> 150 -> 180 -> 55555555
		//    n3        n1   n4     h     n5     n2     n7        n6
		
		printNext(h);//100->120
		printNext(n6);//末节点
		printNext(n2);//150->180
		printNext(n7);//180->5555555
		System.out.println();
		printPrevious(h);//100->50
		printPrevious(n6);//55555->180
		printPrevious(n2);//150->120
		printPrevious(n7);//180->150
		printPrevious(n3);//-2222222->x
		
	}
	
	/**
	 * 求当前节点 h的前驱节点,讨论左子树
	 * @param h
	 */
	private static void printPrevious(Node n) {
		//左子树不为空，则左子树上最右节点为目标节点
		if (n.left != null) {
			Node t = n.left;
			while (t.right != null) {
				t=t.right;
			}
			System.out.println("previous node's val is " + t.val);
		}
		//左子树为空，则
		else {
			Node t = n;
			while (t.parent!=null && t!=t.parent.right) {
				t=t.parent;
			}
			if (t.parent==null) {
				System.out.println("没有前驱节点");
			}else {
				System.out.println("previous node's val is " + t.parent.val);
			}
			
		}
	}
	
	/**
	 * 求当前节点 n的后继节点，讨论右子树
	 * @param n
	 */
	private static void printNext(/* Node h, */ Node n) {
		
		//如果右子树不为空,右子树上的最左节点为后继节点
		if (n.right != null) {
			Node t = n.right;
			while (t.left != null) {
				t = t.left;
			}
			System.out.println("next node's val is " + t.val);
		} 
		//如果右子树为空
		else 
		{
			Node t = n;
			while (t.parent!=null && t!=t.parent.left) {	//当前节点为父节点右节点
				t = t.parent;
			}
			if (t.parent==null) {//末节点
				System.out.println("当前节点为中序遍历末节点，没有后继节点");
			}else {//一般节点
				System.out.println("next node's val is " + t.parent.val);
			}
			
		}
		
	}
	

}
