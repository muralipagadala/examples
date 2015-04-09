package com.murali.datastructures.tree.bst;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BianaryTreeTest {

	private BinaryTree binaryTree;
	
	@BeforeMethod
	public void setUp(){
		binaryTree = new BinaryTree();
	}
	
	@AfterMethod
	public void tearDown(){
		binaryTree = null;
	}
	
	@Test(enabled=false, dataProvider="nodesProvider")
	public void testInsertNodes(Node node){
		binaryTree.insert(node);
	}
	
	@Test
	public void testInsert(){
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		assertTrue(binaryTree.find(new Node(1, 2)));
		assertTrue(binaryTree.find(new Node(10, 12)));
	}
	
	@Test(enabled=false)
	public void testInOrderTraverse(){
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		binaryTree.traverse(BinaryTree.TraverseOrder.INORDER);
	}
	
	@Test
	public void testFindMinimum(){
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		assertFalse(binaryTree.isEmpty());
		assertEquals(binaryTree.findMinimum(), new Node(1,2));
	}
	
	@Test
	public void testFindMaximum(){
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		assertFalse(binaryTree.isEmpty());
		assertEquals(binaryTree.findMaximum(), new Node(13,12));
	}
	
	@Test(enabled=false)
	public void testDeleteLeafNode(){
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		assertFalse(binaryTree.isEmpty());
		assertTrue(binaryTree.delete(3));
		binaryTree.traverse();
	}
	
	@Test(enabled=false)
	public void testDeleteNodeWithSingleLeftChild(){
		System.out.println("Deleting a node with single left child.");
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		assertFalse(binaryTree.isEmpty());
		assertTrue(binaryTree.delete(5));
		binaryTree.traverse();
	}
	
	@Test
	public void testDeleteNodeWithSingleRightChild(){
		System.out.println("Deleting a node with single right child.");
		binaryTree.insert(1, 2);
		binaryTree.insert(10, 12);
		binaryTree.insert(5, 4);
		binaryTree.insert(3,2);
		binaryTree.insert(13, 12);
		assertFalse(binaryTree.isEmpty());
		binaryTree.traverse();
		assertTrue(binaryTree.delete(10));
		binaryTree.traverse();
	}
	
	@Test
	public void testFind(){
		assertFalse(binaryTree.find(new Node(30, 32)));
	}
	
	@DataProvider(name="nodesProvider")
	private Object[][] getNodeData(){
		return new Object[][]{
				{new Node(1,2)},
				{new Node(10,12)},
				{new Node(30,32)},
				{new Node(40,42)},
				{new Node(50,52)}
			};
	}
}
