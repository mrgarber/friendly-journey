package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBinarySearchTreePrintOut {
	
	private  static ArrayList<Integer> defaultNumberList;
	private  static BSTree<Integer,Integer> defaultNumberTree;
	private  static BSTree<Integer,Integer> singleTestNumberTree;
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	// this will be called before every test
	@BeforeEach
	public void setUp() {
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80 ) );

		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
		 // set output of standard print to outputStreamCaptor
		 System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	// this will be called before every test
	@AfterEach
	public void tearDown() {
		//reset standard out
	    System.setOut(standardOut);
	}
	
	@Test
	void test() {
		String expected = "5\r\n15\r\n20\r\n25\r\n30\r\n35\r\n45\r\n50\r\n60\r\n65\r\n70\r\n75\r\n80\r\n85\r\n95";
		defaultNumberTree.printTree(BinarySearchTree.Traversal.IN_ORDER) ;
	    String actual = outputStreamCaptor.toString().trim();
		    assertEquals(expected, actual);
	}
}
