package com.learning.java_junit_mockito.todos.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class TodosBusinessServiceAssertJStub2Test {
	//mocking can be done using stub
	private TodosBusinessService TodosBusinessService ;
	
	@Before
	public void setup() {
		TodosBusinessService = new TodosBusinessService(new ToDoIntegrationServiceStub2() 
	);
	}
	
	
	@Test
	public void testFindSpringTodosBasic() {
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user1");
		assertEquals(2, findSpringTodos.size());
	
	}
	@Test
	public void testFindSpringTodosBasic2() {
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user1");
		assertThat(findSpringTodos).hasSize(2)
								.allMatch(item -> item.contains("spring"));
	}
	//expected to have exception thrown as user3 is ntot there in stub
	@Test(expected = RuntimeException.class)
	public void testFindSpringTodosFakeUser() {
		TodosBusinessService.findSpringTodos("user3");
	}
	
}
