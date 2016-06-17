package com.java.algorithm.BST;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import com.java.algorithm.utility.TreeNode;

public class Traverse {
	//Time: O(n); Space: O(n)
	public void inOrderTraverseIterativeWithHashSet(TreeNode root){
		if(root == null) return;
		HashSet<TreeNode> set = new HashSet();
		Stack<TreeNode> s = new Stack();
		s.push(root);
		set.add(root);
		while(!s.isEmpty()){
			TreeNode top = s.peek();
			if(top.left != null && !set.contains(top.left)){
				s.push(top.left);
				set.add(top.left);
			}else{
				System.out.print(top.val+" ");
				s.pop();
				if(top.right != null)
					s.push(top.right);
			}
		}
		System.out.println();
	}
	public void inOrderTraverseIterative(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s = new Stack();
		TreeNode p = root;
		while(!s.isEmpty() || p != null){
			if(p!=null){
				s.push(p);
				p = p.left;
			}else{
				TreeNode top = s.pop();
				System.out.print(top.val +" ");
				p = top.right;
			}
		}
		System.out.println();
	}
	//O(n)
	public void inOrderTraverseRecusive(TreeNode root){
		if(root == null) return;
		inOrderTraverseRecusive(root.left);
		System.out.print(root.val + " ");
		inOrderTraverseRecusive(root.right);
	}
	//Space: O(1)
	public void inOrderMorrisTraverse(TreeNode root){
//1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
//
//2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
//
//	a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
//
//	b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
//
//3. 重复以上1、2直到当前节点为空。		
		if(root == null) return;
		TreeNode cur = root;
		while(cur != null){
			if(cur.left == null){
				System.out.print(cur.val + " ");
				cur = cur.right;
			}else{
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}
				if(pre.right == cur){
					pre.right = null;
					System.out.print(cur.val + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}
	public void preOrderTraverseIterative(TreeNode root){
		if(root == null) return ;
		Stack<TreeNode> s = new Stack();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode node = s.pop();
			System.out.print(node.val+" ");
			if(node.right != null){
				s.push(node.right);
			}
			if(node.left != null){
				s.push(node.left);
			}
		}
		System.out.println();
	}
	
	public void preOrderTraverseIterative2(TreeNode root){
		if(root == null) return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = root;
		while(!stack.isEmpty() || p != null){
			if(p!=null){
				System.out.print(p.val+" ");
				stack.push(p);
				p = p.left;
			}else{
				TreeNode peek = stack.pop();
				p = peek.right;
			}
		}
		System.out.println();
	}
	
	public void preOrderMorrisTraverse(TreeNode root){
		if(root == null) return;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur != null){
			if(cur.left == null){
				System.out.print(cur.val+" ");
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					System.out.print(cur.val+" ");
					pre.right = cur;					
					cur = cur.left;
				}else if(pre.right == cur){
					pre.right = null;
					cur = cur.right;							
				}
			}
		}
		System.out.println();
	}
	public void preOrderTraverseRecusive(TreeNode root){
		if(root == null) return;
		System.out.print(root.val + " ");
		preOrderTraverseRecusive(root.left);
		preOrderTraverseRecusive(root.right);		
	}	
	public void postOrderTraverseIterativeWithHashSet(TreeNode root){
		if(root == null) return;
		HashSet<TreeNode> set = new HashSet();
		Stack<TreeNode> s = new Stack();
		s.push(root); set.add(root);
		while(!s.isEmpty()){
			TreeNode top = s.peek();
			if((top.left == null && top.right == null) 
					||
					set.contains(top.left) || set.contains(top.right)){
				System.out.print(top.val + " ");
				s.pop();
			}
			if(top.right != null && !set.contains(top.right)){
				s.push(top.right);
				set.add(top.right);
			}
			if(top.left != null && !set.contains(top.left)){
				s.push(top.left);
				set.add(top.left);
			}
		}
		System.out.println();
	}
	
//	1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），那么就把当前结点移到右结点继续循环；
//	2）如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了。
	public void postOrderTraverseItrative(TreeNode root){
		if(root == null) return;
	
		TreeNode pre = null;
		LinkedList<TreeNode> s = new LinkedList();
		while(!s.isEmpty() || root != null){
			if(root!=null){
				s.push(root);
				root = root.left;
			}else{
				TreeNode top = s.peek();
				if(top.right != null && top.right != pre){
					root = top.right;
				}else{
					s.pop();
					System.out.print(top.val + " ");
					pre = top;
				}
			}
		}
		System.out.println();
	}
	
//	这个方法不需要为每个节点额外分配指针指向其前驱和后继结点，而是利用叶子节点中的右空指针指向中序遍历下的后继节点就可以了，所以优势在于不需要额外空间。
//	不过同样相比于Binary Tree Inorder Traversal和Binary Tree Preorder Traversal，后序遍历的情况要复杂得多，因为后序遍历中一直要等到孩子结点访问完才能访问自己，需要一些技巧来维护。
//
//	在这里，我们需要创建一个临时的根节点dummy，把它的左孩子设为树的根root。同时还需要一个s来倒序输出一条右孩子路径上的结点。跟迭代法一样我们需要维护cur指针和pre指针来追溯访问的结点。
//	具体步骤是重复以下两步直到结点为空：
//	1. 如果cur指针的左孩子为空，那么cur设为其右孩子。
//	2. 否则，在cur的左子树中找到中序遍历下的前驱结点pre（其实就是左子树的最右结点）。接下来分两种子情况：
//	（1）如果pre没有右孩子，那么将他的右孩子接到cur。将cur更新为它的左孩子。
//	（2）如果pre的右孩子已经接到cur上了，说明这已经是回溯访问了，可以处理访问右孩子了，倒序输出cur左孩子到pre这条路径上的所有结点，并把pre的右孩子重新设为空（结点已经访问过了，还原现场）。
//	最后将cur更新为cur的右孩子。
//	空间复杂度同样是O(1)，而时间复杂度也还是O(n)，倒序输出的过程只是加大了常数系数，并没有影响到时间的量级。
//	如果对这个复杂度结果不是很熟悉的朋友，可以先看看Binary Tree Inorder Traversal中的分析，在那个帖子中讲得比较详细。	
	public void postOrderMorrisTraverse(TreeNode root){
		if(root == null) return;
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode pre = null;
		TreeNode cur = dummy;
		while(cur !=null){
			if(cur.left == null){
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					reverse(cur.left, pre);
					TreeNode tmp = pre;
					while(tmp != cur.left){
						System.out.print(tmp.val +" ");
						tmp = tmp.right;
					}
					System.out.print(tmp.val+ " ");
					reverse(pre, cur.left);
					pre.right = cur;
					cur = cur.right;
				}
			}
		}
	}
	private void reverse(TreeNode start, TreeNode end){
		if(start == end) return;
		TreeNode pre = start;
		TreeNode cur = start.right;
		TreeNode next = null;
		while(pre != end){
			next = cur.right;
			cur.right = pre;
			pre = cur;
			cur = next;
		}
	}
	public void postOrderTraverseRecusive(TreeNode root){
		if(root == null) return;
		postOrderTraverseRecusive(root.left);
		postOrderTraverseRecusive(root.right);			
		System.out.print(root.val + " ");
	}	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 =  new TreeNode(4);
		node2.left = node4;
		node2.right = node5;
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(8);
		node3.left = node6;
		node3.right = node7;
		Traverse t = new Traverse();
//		System.out.println("Inorder traverse: ");
//		t.inOrderTraverseRecusive(root);
//		System.out.println();
//		t.inOrderTraverseIterativeWithHashSet(root);
//		t.inOrderTraverseIterative(root);
//		System.out.println();
//		t.inOrderMorrisTraverse(root);
//		System.out.println();
		
		System.out.println("Preorder traverse: ");
		t.preOrderTraverseRecusive(root);
		System.out.println();
//		t.preOrderTraverseIterative(root);
//		t.preOrderTraverseIterative2(root);
		t.preOrderMorrisTraverse(root);
		
//		System.out.println("Postorder traverse: ");
//		t.postOrderTraverseRecusive(root);
//		System.out.println();
//		t.postOrderTraverseItrative(root);
//		t.postOrderTraverseIterativeWithHashSet(root);
	}

}
