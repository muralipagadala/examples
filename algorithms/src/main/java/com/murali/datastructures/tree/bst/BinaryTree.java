package com.murali.datastructures.tree.bst;

public class BinaryTree {

	private Node root;
	private int totalNodes;

	
	public enum TraverseOrder{
		INORDER, PREORDER, POSTORDER
	}
	
	public boolean isEmpty(){
		return (root == null);
	}
	
	public boolean find(Node node){
		Node current = root;
		while(current != null && node.key != current.key){
			if(node.key < current.key )
				current = current.left;
			else 
				current = current.right;
		}
		if(current != null){
			//System.out.println("Found the node :"+current);
			return true;
		}
		return false;
	}
	
	public Node findMinimum(){
		Node current = root;
		Node minimum = null;
		while(current != null){
			minimum = current;
			current = current.left;
		}
		return minimum;
	}
	
	public Node findMaximum(){
		Node current = root;
		Node maximum = null;
		while(current != null){
			maximum = current;
			current = current.right;
		}
		return maximum;
	}
	
	public void traverse(TraverseOrder order){
		switch(order){
			case INORDER:
						System.out.println();
						inOrder(root);
						break;
			case PREORDER:
						System.out.println();
						preOrder(root);
						break;
			case POSTORDER:
						System.out.println();
						postOrder(root);
						break;
		}
	}
	
	private void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.key + "  ");
			inOrder(root.right);
		}
	}
	
	private void preOrder(Node root){
		
	}
	
	private void postOrder(Node root){
		
	}
	
	public void traverse(){
		traverse(TraverseOrder.INORDER);
	}
	
	public Node find(int key){
		Node current = root;
		while(current != null && key != current.key){
			if(key < current.key )
				current = current.left;
			else 
				current = current.right;
		}
		return current;
	}
	
	/**
	 * Insert as root
	 * Traverse the tree to find a place to insert.
	 * @param node
	 */
	public void insert(Node node){
		if(root == null){
			root = node;
			//System.out.println("Added as root node :"+root);
		}else{
			Node current = root;
			while(true){
				if(node.key < current.key ){
					if(current.left != null){
						current = current.left;
					}else{
						current.left = node;
						//System.out.println("Added as left node :"+node);
						break;
					}
				}else{
					if(current.right != null){
						current = current.right;
					}else{
						current.right = node;
						//System.out.println("Added as right node :"+node);
						break;
					}
				}
			}
		}
		totalNodes++;
	}
	
	
	
	public int size(){
		return totalNodes;
	}
	
	public void insert(int key, int value){
		insert(new Node(key, value));
	}
	
	public boolean delete(Node node){
		return node != null ? delete(node.key):false;
	}
	public boolean deleteBook(int key){
		Node current = root;
		Node parent = current;
		boolean isLeftChild = false;
		while(current.key != key){
			parent = current;
			if(key < current.key){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
		}
		if(current == null){
			return false;
		}
		
		if(current.left == null && current.right == null){
			if(current == root){
				root = null;
				return true;
			}else if(isLeftChild){
				current.left = null;
				return true;
			}else{
				current.right = null;
				return true;
			}
		}else if(current.right == null){
			if(current == root)
				root = current.left;
			else if(isLeftChild) 
				parent.left = current.left;  // left child of parent
			else 
				parent.right = current.left;  // right child of parent
		}else if(current.left == null){
			if(current == root)
				root = current.right;
			else if(isLeftChild) 
				parent.left = current.right;  
			else 
				parent.right = current.right;
		}
		
		return false;
	}
	
	/**
	 * 	1. The node to be deleted is a leaf (has no children).
		2. The node to be deleted has one child.
		3. The node to be deleted has two children.
	 * @param key
	 * @return
	 */
	private boolean deleteLeafNodeMine(int key){
		Node current = root;
		Node parent = null;
		while(current != null){
			parent = current;
			if(key < current.key ){
				current = current.left;
				if(current.key == key){
					parent.left = null;
					return true;
				}
			}else{
				current = current.right;
				if(current.key == key){
					parent.right = null;
					return true;
				}
			} 
		}
		return false;
	}
	
	//public boolean deleteNodeWithOneChild(int key){
	public boolean delete(int key){
		traverse();
		Node current = root;
		Node parent = current;
		while(current != null){
			parent = current;
			if(key < current.key ){
				System.out.println("Should not come here....");
				current = current.left;
				if(current.key == key ){
					if(isLeafNode(current)){
						parent.left = null;
						return true;
					}else{
						parent.left = current.left;
						current = null;
						return true;
					}
				}
			}else{
				current = current.right;
				if(current.key == key ){
					if(isLeafNode(current)){
						parent.right = null;
						return true;
					}else{
						System.out.println("Parent :"+parent);
						System.out.println("Parent right : "+parent.right);
						System.out.println("Current :"+current);
						System.out.println("Current right : "+current.right);
						
						//parent.right = current.right;
						//current = null;
						System.out.println("After Parent :"+parent);
						System.out.println("After Parent right : "+parent.right);
						System.out.println("After Parent left : "+parent.left);
						return true;
					}
				}
			} 
		}
		return false;
	}
	
	private boolean isLeafNode(Node node){
		return (node.left == null && node.right == null);
	}

}
