package im.engure.binarytree;

public class PrintTree {

	public static void main(String[] args) {

		/*
		 * tree

			H100H
	     >0>	     		<150<
 >-222222>  <50<		>120>		<55555555<
 					    	  >180>


===>>>> 逆时针旋转90度

                                                      <55555555<
                                                                             >180>
                                     <150<
                                                         >120>
                 H100H
                                                         <50<
                                      >0>
                                                       >-222222>


		 * */

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

		printBinaryTree(h,0,"H");

	}
	/**
	 * 打印二叉树
	 * @param h 当前节点
	 * @param i 从上往下，第几层
	 * @param string 标识符，H,<,>
	 */
	static void printBinaryTree(Node h, int i, String string) {
		if (h==null) {
			return;
		}

		//打印右子树
		printBinaryTree(h.right, i+1, "<");

		//打印当前节点
		if (h != null) {
			int len = 10 + 20*i +(17 - new String(""+h.val).length())/2;
			String space = "";
			for (int j = 0; j < len; j++) {
				space+=" ";
			}
			System.out.println(space + string + h.val + string);
		}
		//打印左子树
		printBinaryTree(h.left, i+1, ">");

	}

}

class Node {
		public Node left=null,right=null;
		public Node parent;
		public int val;

		public Node(int v) {
			val = v;
		}
	}
