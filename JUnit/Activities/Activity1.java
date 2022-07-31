package activities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class Activity1 {
	
	static ArrayList<String> list;
	
	@BeforeEach
	void setUp() {
		list= new ArrayList<String>();
		list.add("alpha");
		list.add("beta");
	}
	
	@Test
	void insertTest() {
		System.out.println("Inside InsertTest");
		System.out.println(list.size());
		System.out.println(list);
		assertEquals(2, list.size());
		list.add("gamma");
		assertEquals(3, list.size());
		assertEquals("alpha", list.get(0),"Wrong element");
		assertEquals("beta", list.get(1),"Wrong element");
		assertEquals("gamma", list.get(2),"Wrong element");
	}

	@Test
	void replaceTest() {
		System.out.println("Inside ReplaceTest");
		assertEquals(2, list.size());
		list.add("gamma");
		assertEquals(3, list.size());
		
		list.set(1, "delta");
		assertEquals("alpha", list.get(0),"Wrong element");
		assertEquals("delta", list.get(1),"Wrong element");
		assertEquals("gamma", list.get(2),"Wrong element");
	}
	
	

}
