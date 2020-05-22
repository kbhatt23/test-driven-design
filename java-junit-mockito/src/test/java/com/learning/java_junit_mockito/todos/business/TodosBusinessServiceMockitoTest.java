package com.learning.java_junit_mockito.todos.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class TodosBusinessServiceMockitoTest {
	//mock helps increating less code
	//provides more fleibility and maintaineance
	//easy readability
	//direct method call to this returns default val like null, 0 , false etc
	private ToDoIntegrationService toDoIntegrationService = Mockito.mock(ToDoIntegrationService.class);
	private TodosBusinessService TodosBusinessService = new TodosBusinessService(toDoIntegrationService);
	
	@Test
	public void callMockMethodsDirectly() {
		//wont call the actual method
		//will be used only for mock usin .when and return methods
		List<String> listToDo= toDoIntegrationService.fetchToDosForUser("user1");
		assertEquals(0, listToDo.size());
	}
	@Test
	public void callMockMethodsDirectlyWithMock() {
		//wont call the actual method
		//will be used only for mock usin .when and return methods
		Mockito.when(toDoIntegrationService.fetchToDosForUser(anyString())).thenReturn(Arrays.asList("spring boot"));
		List<String> listToDo= toDoIntegrationService.fetchToDosForUser("user22");
		assertEquals(1, listToDo.size());
	}
	@Test
	public void testFindSpringTodosBasic() {
		Mockito.when(toDoIntegrationService.fetchToDosForUser(anyString())).thenReturn(Arrays.asList("spring boot"));
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user1");
		assertEquals(1, findSpringTodos.size());
	
	}
	@Test
	public void testFindSpringTodosBasic2() {
		Mockito.when(toDoIntegrationService.fetchToDosForUser(anyString())).thenReturn(Arrays.asList("spring boot"));
		List<String> findSpringTodos = TodosBusinessService.findSpringTodos("user14");
		assertThat(findSpringTodos, hasSize(1));
	}
	
}
