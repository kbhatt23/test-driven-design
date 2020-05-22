package com.learning.java_junit_mockito.todos.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class TodosBusinessServiceTest {
	
	private TodosBusinessService TodosBusinessService ;
	
	//delete method removes user data
	//so we are adding back to normal
	@Before
	public void setup() {
		TodosBusinessService = new TodosBusinessService(new ToDoIntegrationService());
	}
	
	@Test
	public void testdelete() {
		
		TodosBusinessService.deleteNonSpringTodos("user1");
	}
	@Test
	public void testFindSpringTodosBasic() {
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user1");
		assertEquals(2, findSpringTodos.size());
	
	}
	@Test
	public void testFindSpringTodosBasic2() {
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user1");
		assertThat(findSpringTodos, hasSize(2));
	}
	
}
