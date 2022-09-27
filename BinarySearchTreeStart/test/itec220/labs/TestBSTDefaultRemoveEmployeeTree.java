package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTDefaultRemoveEmployeeTree { 

	
	private  static ArrayList<Integer> defaultNumberList;
	private  static BSTree<String,Employee> defaultEmployeeTree;
	private  static BSTree<String,Employee> singleTestEmployeeTree;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15, 5,20, 35,30,45,65,70,85,95,80 ) );
		
		int typeCount = EmployeeType.values().length;
		defaultEmployeeTree = new BSTree<String, Employee>(( s1 , s2) -> s2.compareTo(s1));
		for(Integer i : defaultNumberList)
		{
			String id = String.format("%010d", i);
			defaultEmployeeTree.insert(id,new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,id, ""+i));
		}
			
		/**50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               75                25
		 *                           85      65        35      15       
		 *                         95  80  70        45  30  20   5          
		 */
	}
	@BeforeEach
	public void setUp() {
		// use this type of setup for something you would break by testing (like delete)
		// it will be reset for each test
	
		int typeCount = EmployeeType.values().length;
		singleTestEmployeeTree = new BSTree<String, Employee>(( s1 , s2) -> s2.compareTo(s1));
		for(Integer i : defaultNumberList)
		{
			String id = String.format(Employee.IDformatter, i);
			singleTestEmployeeTree.insert(id,new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,id, ""+i));
		}
			
		/**50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               75                25
		 *                           85      65        35      15       
		 *                         95  80  70  60    45  30  20   5          
		 */
	}
	@Test
	void testRemoveRoot() {
		int num = 50;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.remove(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
	
	}
	
	
	@Test
	void testRemoveRight() {
		int num = 75;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.remove(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testRemoveLeft() {
		int num = 25;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.remove(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	

	}
	@Test
	void testRemoveMulitple() {
		int num = 5;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.remove(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID()),
				() ->assertEquals(10, defaultEmployeeTree.size())
				);	
		
		int num2 = 65;
		//Arrange 
		String searchItem2 = String.format(Employee.IDformatter, num2);
		// Act
		Employee found2 = defaultEmployeeTree.remove(searchItem2);
		// Assert
		assertAll(() ->assertEquals(searchItem2, found2.getID()),
				
				() ->assertEquals("First"+num2, found2.getFirstName()),
				() ->assertEquals("Last"+num2, found2.getLastName()),
				() ->assertEquals(""+num2, found2.getLevel()),
				() ->assertEquals(searchItem2, found2.getID()),
				() ->assertEquals(9, defaultEmployeeTree.size())
				);	

	}


}
