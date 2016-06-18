package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1. Insert a Node to a Binary tree
 * 2. All 3 traversals of a binary tree
 * 3. Given a sorted array, build a balanced search tree (BST)
 * 4. Search for a given element in a BST
 * 5. Balance a binary tree
 * 7. Check if a tree is balanced or not
 * 8. Breadth first search of a Binary tree or Print level wise all nodes of a binary tree   
 * 9. Height of a binary tree
 * 
 * */
public class TreeNodeImplementation {

	public static TreeNode root;
	public static TreeNode nodeBST; 
	public void insertNode(int data){
		if(root == null){
			root = new TreeNode(data);
		}
		else{
			 TreeNode current, prevCurrent;
			 
			 current = root;
			 
			 while(true){
				 
				 prevCurrent = current;
				 
				 if(current.data > data){
					 current = current.left;					 
					 if(current == null){
						 prevCurrent.left = new TreeNode(data);
						 return;
					 }
				 }				 
				 else{
					 current = current.right;					 
					 if(current == null){
						 prevCurrent.right = new TreeNode(data);
						 return;
					 }
				 }
				 
			 }
		}
	}
	
	public void inorderTraversal(TreeNode node){
		if(node != null){
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
		
	}
	
	public void preorderTraversal(TreeNode node){
		if(node != null){
			System.out.print(node.data + " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
		
	}
	
	public void postorderTraversal(TreeNode node){
		if(node !=null){
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data + " ");
		}
		
	}
	
	public TreeNode createBalancedBST(int arr[], int start, int end){		
		if(start > end)
			return null;
		int mid = start + (end-start)/2;
		TreeNode node = new TreeNode(arr[mid]);
		
		node.setLeft(createBalancedBST(arr, start, mid-1));
		node.setRight(createBalancedBST(arr, mid+1, end));
		
		return node;
	}
	
	public boolean searchNode(TreeNode node, int data){
		
		if(data == node.data){
			return true;
		}
			
		else if(data > node.data){
		if(node.right == null)
				return false;
			else
				return searchNode(node.right, data);
		}
		else{
			if(node.left == null){
				return false;
			}
			else
				return searchNode(node.left, data);
		}	
		
	}
	
	public int heightOfTree(TreeNode node){
	
		if (node == null){
			return -1;
		}
		else{
			int leftSubtree = heightOfTree(node.left);
			int rightSubTree  = heightOfTree(node.right);
			return Math.max(leftSubtree, rightSubTree) + 1;			
		}
	
	}
	 
	public boolean checkIfTreeIsBalanced(TreeNode node){
		
		if(node == null)
			return false;
		else if(node.left == null && node.right == null)
			return true;
		else{
			int leftSubtree = heightOfTree(node.left);
			int rightSubTree = heightOfTree(node.right);
			
			if(Math.abs(leftSubtree - rightSubTree) > 1)
				return false;
			else
				return true;
		}
	}
	
	
	public void breadthFirstSearch(TreeNode node){
		if(node == null)return;
		
		Queue q = new LinkedList();		
		q.add(node);
		int noOfNodesInEachLevel =0;
		
		while(!q.isEmpty()){
			noOfNodesInEachLevel = q.size();
		
			while(noOfNodesInEachLevel > 0){
				TreeNode n = (TreeNode) q.remove();
				System.out.print(" " +n.data);
				if(n.left != null)q.add(n.left);
				if(n.right != null) q.add(n.right);
				
				noOfNodesInEachLevel--;
			}
			System.out.println("");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		// Following creates a normal unbalanced binary tree and inserts node into it
		TreeNodeImplementation trees = new TreeNodeImplementation();
		trees.insertNode(1);
		trees.insertNode(2);
		trees.insertNode(3);
		trees.insertNode(4);
		trees.insertNode(5);
		
		//The following is the 3 types of tree traversals
		trees.inorderTraversal(root);
		System.out.println();
		trees.preorderTraversal(root);
		System.out.println();
		trees.postorderTraversal(root);
		System.out.println();

		//The following creates a binary search tree with sorted array as input
		int arr[] = {1,2,3,4,5,6,7,8,9};
		TreeNodeImplementation balancedTree = new TreeNodeImplementation();
		TreeNode balancedTreeNode = balancedTree.createBalancedBST(arr, 0, 8);
		balancedTree.inorderTraversal(balancedTreeNode);
		System.out.println();
		balancedTree.preorderTraversal(balancedTreeNode);
		System.out.println();

		balancedTree.postorderTraversal(balancedTreeNode);
		System.out.println();	
		
		//The following inputs test if a node is present or not in a BST
		boolean result = balancedTree.searchNode(balancedTreeNode, 8);
		if(result)
			System.out.println("Present");
		else
			System.out.println("Not Present");
		
		result = balancedTree.searchNode(balancedTreeNode, 0);
		if(result)
			System.out.println("Present");
		else
			System.out.println("Not Present");
		
		//Get height of a BST
		System.out.println("Height of the BST is : " + balancedTree.heightOfTree(balancedTreeNode));
		
		//Check if a given tree is blanaced or not
		
		if(balancedTree.checkIfTreeIsBalanced(balancedTreeNode))
			System.out.println("It is balanced");
		else
			System.out.println("It is not balanced");
		
		if(trees.checkIfTreeIsBalanced(root))
			System.out.println("It is balanced");
		else
			System.out.println("It is not balanced");
		
		//Breadth first traversal of a tree
		balancedTree.breadthFirstSearch(balancedTreeNode);
		
		
	}

}
