package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import itec220.labs.BinarySearchTree.Traversal;

class TestBSTDefaultRemoveTree {

	
	private  static ArrayList<Integer> defaultNumberList;
	private  static BSTree<Integer,Integer> defaultNumberTree;
	private  static BSTree<Integer,Integer> singleTestNumberTree;
	@BeforeAll
	public static void setUpAll() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15, 5,20, 35,30,45,65,60,70,85,95 ) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75
		 *                           15     35        65      85       
		 *                          5  20 30  45    60  70       95      
		 *                          
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	
	public static void defaultBinaryTree() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15,5,20, 35,30,45,65,60,70,85,75, 95 ) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75
		 *                           15     35        65      85       
		 *                          5  20 30  45    60  70       95      
		 *                          
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	
	public static void setUpAll2() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75    
  
		 *                          
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	public static void setUpAll3() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15,5) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75    
		 *                          15
		 *                         5         
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	
	public static void setUpAll4() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,60,15,20) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75    
		 *                          15                  60
		 *                            20     
       
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}

	
	@BeforeEach
	public void setUp() {
		// use this type of setup for something you would break by testing (like delete)
		// it will be reset for each test
	
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75
		 *                           15      35        65      85       
		 *                          5     30    45  60   70       95   
		 *                          
		 *                                 
		 *                                 50
		 *                              20        75
		 *                            15  30    65    85 
		 *                           5     45 60 70
		 *                          
		 */
		singleTestNumberTree = new BSTree<>();
		defaultNumberList.forEach((a) -> {singleTestNumberTree.insert(a, a);});
	}
	
	//make assert all test for size and contains
	@Test
	void testRemoveNumber() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(65);
		// Act
		Integer found = defaultNumberTree.remove(65);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(13, defaultNumberTree.size())				
				);	
		
	
	}
	
	@Test
	void testRemoveRoot() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = defaultNumberTree.remove(50);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(13, defaultNumberTree.size())				
				);	
	}
	
	@Test
	void testForPredesesor() {
		setUpAll();
		//Arrange 
		defaultNumberTree.remove(50);
		Integer searchItem = 45;
		// Act
		Integer found = defaultNumberTree.getRoot();
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(13, defaultNumberTree.size())				
				);	
		
	
	}
	
	
	@Test
	void testRemoveTwoChild() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(25);
		// Act
		Integer found = defaultNumberTree.remove(25);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(13, defaultNumberTree.size())				
				);	
		
	
	}
	@Test
	void testRemoveNoChild() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(70);
		// Act
		Integer found = defaultNumberTree.remove(70);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(13, defaultNumberTree.size())				
				);	
		
	
	}
	
	@Test
	void testRemoveRootTwo() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = defaultNumberTree.remove(50);
		// Assert
		assertEquals(searchItem, found);
		//Arrange 
		Integer searchItem2 = Integer.valueOf(45);
		// Act
		Integer found2 = defaultNumberTree.remove(45);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(12, defaultNumberTree.size())				
				);	
		
	
	}
	
	@Test
	void testRemoveLeftSideOfTree() {
		setUpAll();
		//Arrange 
		defaultNumberTree.remove(15);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		defaultNumberTree.remove(5);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println(); 
		defaultNumberTree.remove(20);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		defaultNumberTree.remove(35);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		defaultNumberTree.remove(30);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		defaultNumberTree.remove(45);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		
		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = defaultNumberTree.remove(50);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(7, defaultNumberTree.size())				
				);	
	
	}
	
	@Test
	void testRemoveRightSideOfTree() {
		setUpAll();
		//Arrange 
		defaultNumberTree.remove(75);

		defaultNumberTree.remove(65);

		defaultNumberTree.remove(85);

		defaultNumberTree.remove(60);

		defaultNumberTree.remove(70);

		defaultNumberTree.remove(95);

		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = defaultNumberTree.remove(50);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(7, defaultNumberTree.size())				
				);	
	
	}
	
	@Test
	void testRootWithRightPredesesor() {
		setUpAll2();
		//Arrange 
		Integer searchItem = 25;
		// Act
		defaultNumberTree.remove(50);
		Integer found = defaultNumberTree.getRoot();
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(2, defaultNumberTree.size())				
				);	
	}
	
	
	@Test
	void testRootWithLeftPredesesor() {
		setUpAll3();
		//Arrange 
		Integer searchItem = 15;
		// Act
		defaultNumberTree.remove(50);
		defaultNumberTree.remove(25);
		Integer found = defaultNumberTree.getRoot();
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(3, defaultNumberTree.size())				
				);	

	}
	
	@Test
	void testOneRightChild() {
		setUpAll4();
		//Arrange 
		Integer searchItem = 75;
		// Act
		Integer found = defaultNumberTree.remove(75);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(5, defaultNumberTree.size())				
				);
	}

	
	@Test
	void testRootWithPredesesorTwo() {
		setUpAll4();
		//Arrange 
		Integer searchItem = 20;
		// Act
		defaultNumberTree.remove(50);
		defaultNumberTree.remove(25);
		defaultNumberTree.remove(15);
		Integer found = defaultNumberTree.getRoot();
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(3, defaultNumberTree.size())				
				);

	}
	

	@Test
	void testNull() {
		setUpAll();
		//Arrange 
		Integer searchItem = null;
		// Act
		Integer found = defaultNumberTree.remove(3);
		// Assert
		assertAll(() ->	assertEquals(searchItem, found),
				  () ->	assertEquals(0, defaultNumberTree.size())				
				);
		
	
	}
	@Test
	void testEmpty() {
		setUpAll();
		//Arrange 
		for(Integer num : defaultNumberList) {
			defaultNumberTree.remove(num);
		}
		Integer searchItem = null;
		// Act
		Integer found = defaultNumberTree.remove(95);
		// Assert
		assertEquals(searchItem, found);
		
	
	}
	


	
	@Test
	void testRemoveTree() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = defaultNumberTree.remove(50);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		// Assert
		assertEquals(searchItem, found);
		
		Integer searchItem2 = Integer.valueOf(25);
		// Act
		Integer found2 = defaultNumberTree.remove(25);
		// Assert
		assertEquals(searchItem2, found2);
		
		Integer searchItem3 = Integer.valueOf(75);
		// Act
		Integer found3 = defaultNumberTree.remove(75);
		// Assert
		assertEquals(searchItem3, found3);
		
		Integer searchItem4 = Integer.valueOf(15);
		// Act
		Integer found4 = defaultNumberTree.remove(15);
		// Assert
		assertEquals(searchItem4, found4);
		
		Integer searchItem5 = Integer.valueOf(5);
		// Act
		Integer found5 = defaultNumberTree.remove(5);
		// Assert
		assertEquals(searchItem5, found5);
		
		Integer searchItem6 = Integer.valueOf(20);
		// Act
		Integer found6 = defaultNumberTree.remove(20);
		// Assert
		assertEquals(searchItem6, found6);
		
		Integer searchItem7 = Integer.valueOf(35);
		// Act
		Integer found7 = defaultNumberTree.remove(35);
		// Assert
		assertEquals(searchItem7, found7);
		
		Integer searchItem8 = Integer.valueOf(30);
		// Act
		Integer found8 = defaultNumberTree.remove(30);
		// Assert
		assertEquals(searchItem8, found8);
		
		Integer searchItem9 = Integer.valueOf(45);
		// Act
		Integer found9 = defaultNumberTree.remove(45);
		// Assert
		assertEquals(searchItem9, found9);
		
		Integer searchItem10 = Integer.valueOf(65);
		// Act
		Integer found10 = defaultNumberTree.remove(65);
		// Assert
		assertEquals(searchItem10, found10);
		
		Integer searchItem11 = Integer.valueOf(60);
		// Act
		Integer found11 = defaultNumberTree.remove(60);
		// Assert
		assertEquals(searchItem11, found11);

		Integer searchItem12 = Integer.valueOf(70);
		// Act
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		Integer found12 = defaultNumberTree.remove(70);
		// Assert
		assertEquals(searchItem12, found12);

		Integer searchItem14 = Integer.valueOf(85);
		// Act

		Integer found14 = defaultNumberTree.remove(85);

		// Assert
		assertEquals(searchItem14, found14);
		
		Integer searchItem13 = Integer.valueOf(95);
		// Act
		Integer found13 = defaultNumberTree.remove(95);
		// Assert
		assertEquals(searchItem13, found13);
	}
	
	
	@Test
	void testStructure() {
		defaultBinaryTree();
		//Arrange 
		ArrayList<Integer> preOrderNumberList = new ArrayList<Integer>(Arrays.asList(45, 25, 15, 20, 35, 30, 65, 60, 85, 95) );
		ArrayList<Integer> inOrderNumberList = new ArrayList<Integer>(Arrays.asList(15, 20, 25, 30, 35, 45, 60, 65, 85, 95) );
		// Act
		defaultNumberTree.remove(50);
		defaultNumberTree.remove(75);
		defaultNumberTree.remove(5);
		defaultNumberTree.remove(70);
		ArrayList<Integer> preOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.PRE_ORDER);
		ArrayList<Integer> inOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.IN_ORDER);
		// Assert
		assertAll(() ->	assertEquals(preOrderNumberList, preOrderActual),
				  () ->	assertEquals(inOrderNumberList, inOrderActual)				
				);
	
	}
	
	@Test
	void testStructureRemoveRight() {
		defaultBinaryTree();
		//Arrange 
		ArrayList<Integer> preOrderNumberList = new ArrayList<Integer>(Arrays.asList(45, 20, 35, 30, 75, 65, 60, 70, 85, 95) );
		ArrayList<Integer> inOrderNumberList = new ArrayList<Integer>(Arrays.asList(20, 30, 35, 45, 60, 65, 70, 75, 85, 95) );
		// Act
		defaultNumberTree.remove(50);
		defaultNumberTree.remove(25);
		defaultNumberTree.remove(5);
		defaultNumberTree.remove(15);
		ArrayList<Integer> preOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.PRE_ORDER);
		ArrayList<Integer> inOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.IN_ORDER);
		// Assert
		assertAll(() ->	assertEquals(preOrderNumberList, preOrderActual),
				  () ->	assertEquals(inOrderNumberList, inOrderActual)				
				);
	
	}
	
	@Test
	void testStructureRemoveLeft() {
		defaultBinaryTree();
		//Arrange 
		ArrayList<Integer> preOrderNumberList = new ArrayList<Integer>(Arrays.asList(35, 25, 15, 5, 20, 75, 65, 85, 95) );
		ArrayList<Integer> inOrderNumberList = new ArrayList<Integer>(Arrays.asList(5, 15, 20, 25, 35, 65, 75, 85, 95) );
		// Act
		defaultNumberTree.remove(50);
		defaultNumberTree.remove(70);
		defaultNumberTree.remove(60);
		defaultNumberTree.remove(45);
		ArrayList<Integer> preOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.PRE_ORDER);
		ArrayList<Integer> inOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.IN_ORDER);
		// Assert
		assertAll(() ->	assertEquals(preOrderNumberList, preOrderActual),
				  () ->	assertEquals(inOrderNumberList, inOrderActual)				
				);
	
	}
	
	@Test
	void testRemoveTreeRandomOrder() {
		setUpAll();
		//Arrange 
		Integer searchItem = Integer.valueOf(35);
		// Act
		Integer found = defaultNumberTree.remove(35);
		// Assert
		assertEquals(searchItem, found);
		
		Integer searchItem2 = Integer.valueOf(25);
		// Act
		Integer found2 = defaultNumberTree.remove(25);
		// Assert
		assertEquals(searchItem2, found2);
		
		Integer searchItem3 = Integer.valueOf(95);
		// Act
		Integer found3 = defaultNumberTree.remove(95);
		// Assert
		assertEquals(searchItem3, found3);
//		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		Integer searchItem4 = Integer.valueOf(60);
		// Act
		Integer found4 = defaultNumberTree.remove(60);
		// Assert
		assertEquals(searchItem4, found4);
		
		Integer searchItem5 = Integer.valueOf(70);
		// Act
		Integer found5 = defaultNumberTree.remove(70);
		// Assert
		assertEquals(searchItem5, found5);
		
		Integer searchItem6 = Integer.valueOf(20);
		// Act
//		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		System.out.println();
		Integer found6 = defaultNumberTree.remove(20);
//		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);

		// Assert
		assertEquals(searchItem6, found6);
		
		Integer searchItem7 = Integer.valueOf(45);
		// Act
		Integer found7 = defaultNumberTree.remove(45);
		// Assert
		assertEquals(searchItem7, found7);
		
		Integer searchItem8 = Integer.valueOf(15);
		// Act
		Integer found8 = defaultNumberTree.remove(15);
		// Assert
		assertEquals(searchItem8, found8);
		
		Integer searchItem9 = Integer.valueOf(50);
		// Act
		Integer found9 = defaultNumberTree.remove(50);
		// Assert
		assertEquals(searchItem9, found9);
		
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		Integer searchItem10 = Integer.valueOf(5);
		// Act

		Integer found10 = defaultNumberTree.remove(5);
		defaultNumberTree.printTree(Traversal.LEVEL_ORDER);
		// Assert
		assertEquals(searchItem10, found10);
		
		Integer searchItem11 = Integer.valueOf(75);
		// Act
		Integer found11 = defaultNumberTree.remove(75);
		// Assert
		assertEquals(searchItem11, found11);
		
		Integer searchItem12 = Integer.valueOf(85);
		// Act
		Integer found12 = defaultNumberTree.remove(85);
		// Assert
		assertEquals(searchItem12, found12);

		Integer searchItem14 = Integer.valueOf(65);
		// Act
		Integer found14 = defaultNumberTree.remove(65);
		// Assert
		assertEquals(searchItem14, found14);
		
		Integer searchItem13 = Integer.valueOf(30);
		// Act
		Integer found13 = defaultNumberTree.remove(30);
		// Assert
		assertEquals(searchItem13, found13);
	}

}
