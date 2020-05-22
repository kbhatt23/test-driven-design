package com.learning.java_junit_mockito.todos.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class TodosBusinessServiceAssertJTest {
	
	private TodosBusinessService TodosBusinessService = new TodosBusinessService(new ToDoIntegrationService());
	
	
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
	
	@Test(expected = RuntimeException.class)
	public void testFindSpringTodosFakeUser() {
		TodosBusinessService.findSpringTodos("fakeuser");
	}
	
	@Test
	public void testFindSpringTodosUser4() {
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user4");
		assertThat(findSpringTodos).hasSize(1)
								.allMatch(item -> item.contains("spring"));
	}
	
}
