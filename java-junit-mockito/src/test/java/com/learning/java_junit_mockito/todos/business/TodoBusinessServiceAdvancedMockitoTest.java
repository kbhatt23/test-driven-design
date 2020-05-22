package com.learning.java_junit_mockito.todos.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessServiceAdvancedMockitoTest {
	//create main class and add all the depenedenices to it only for @mock mentioned in this class
	@InjectMocks
	//eg things whihc are not mock in this class will not be injected
	private TodosBusinessService businessService;
	//it will create mock bean instance
	@Mock
	private ToDoIntegrationService integrationService; 
	
	@Test
	public void testAutoInjection() {
		when(integrationService.fetchToDosForUser(anyString())).thenReturn(Arrays.asList("jai shree ram says spring"));
		assertThat(businessService.findSpringTodos("user1")).hasSize(1).contains("jai shree ram says spring");
	}
}
