package com.learning.java_junit_mockito.todos.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

@RunWith(MockitoJUnitRunner.class)
public class TodosBusinessServiceVerifyTest {

	// we need to mock this instead of stub/actual method call
	// private ToDoIntegrationService integrationService =
	// mock(ToDoIntegrationService.class);
	@Mock
	private ToDoIntegrationService integrationService;
	// using mocked integration service for dependency injection
	// private TodosBusinessService businessService = new
	// TodosBusinessService(integrationService);
	// auto injection of dependenies mentioned in @mock
	@InjectMocks
	private TodosBusinessService businessService = new TodosBusinessService(integrationService);

	@Test(expected = RuntimeException.class)
	public void testfindSpringTodos() {
		// not using mock to actually return some vlaue from method as of now
		List<String> springTodsList = businessService.findSpringTodos("user1");
		// mock wont return and hence runtime excpetion will occur
		// fetchToDosForUser method shud be called only once by passing string user1 as
		// input argument
		verify(integrationService).fetchToDosForUser("user1");
	}

	@Test
	public void testfindSpringTodos_basic2() {
		// anystring passed will return same data
		when(integrationService.fetchToDosForUser(anyString()))
				.thenReturn(Arrays.asList("spring boot", "java 8", "spring data jpa"));
		List<String> springTodsList = businessService.findSpringTodos("user1");
		assertThat(springTodsList).hasSize(2).allMatch(e -> e.contains("spring"));

		// mock wont return and hence runtime excpetion will occur
		// fetchToDosForUser method shud be called only once by passing string user1 as
		// input argument
		verify(integrationService).fetchToDosForUser(anyString());
	}

	@Test
	public void testfindSpringTodos_basic3() {
		// anystring passed will return same data
		when(integrationService.fetchToDosForUser(anyString()))
				.thenReturn(Arrays.asList("spring boot", "java 8", "spring data jpa"));
		List<String> springTodsList = businessService.findSpringTodos("user1");
		assertThat(springTodsList).hasSize(2).allMatch(e -> e.contains("spring"));

		// mock wont return and hence runtime excpetion will occur
		// fetchToDosForUser method shud be called only once by passing string user1 as
		// input argument
		verify(integrationService).fetchToDosForUser(anyString());
		// method shud never be called
		verify(integrationService, never()).fakeMethod();
	}

	@Test
	public void testfindSpringTodos_argumentCaptor() {
		// anystring passed will return same data
		when(integrationService.fetchToDosForUser(anyString()))
				.thenReturn(Arrays.asList("spring boot", "java 8", "spring data jpa"));
		List<String> springTodsList = businessService.findSpringTodos("user1");
		List<String> springTodsList2 = businessService.findSpringTodos("user12");
		assertThat(springTodsList).hasSize(2).allMatch(e -> e.contains("spring"));
		assertThat(springTodsList2).hasSize(2).allMatch(e -> e.contains("spring"));

		// mock wont return and hence runtime excpetion will occur
		// fetchToDosForUser method shud be called only once by passing string user1 as
		// input argument
		verify(integrationService, times(2)).fetchToDosForUser(anyString());
		// method shud never be called
		verify(integrationService, never()).fakeMethod();

		// argument captor
		// verifying if smae user id is passed to integration service

		ArgumentCaptor<String> arg1 = ArgumentCaptor.forClass(String.class);
		verify(integrationService, times(2)).fetchToDosForUser(arg1.capture());

		String firstTimeArg = arg1.getAllValues().get(0);
		String secondTimeArg = arg1.getAllValues().get(1);
		assertEquals("user1", firstTimeArg);
		assertEquals("user12", secondTimeArg);
	}
	
	public void verifyDeleteCalls_basic1() {
		when(integrationService.fetchToDosForUser("user1"))
		.thenReturn(Arrays.asList("spring boot", "java 8" , "spring data jpa"
				,"maven","git"
				));
		
		businessService.deleteNonSpringTodos("user1");
		//3 non spring todos exist to get dleeted
		//hence clal is 3 times
		verify(integrationService,times(3)).deleteTodosForUser("user1", anyString());
	}
	@Test
	public void verifyDeleteCalls_withArguments() {
		when(integrationService.fetchToDosForUser("user1"))
		.thenReturn(Arrays.asList("spring boot", "java 8" , "spring data jpa"
				,"maven","git"
				));
		
		businessService.deleteNonSpringTodos("user1");
		//3 non spring todos exist to get dleeted
		//hence clal is 3 times
		verify(integrationService,times(3)).deleteTodosForUser(anyString(), anyString());
		
		ArgumentCaptor<String> arg1Captor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> arg2Captor = ArgumentCaptor.forClass(String.class);
				
		verify(integrationService,times(3)).deleteTodosForUser(arg1Captor.capture(), arg2Captor.capture());
		arg1Captor.getAllValues().forEach(a -> assertEquals("user1", a));
		
		//better in old days when streams were not there
		assertThat(arg1Captor.getAllValues()).hasSize(3).allMatch(a -> a.equals("user1"));
		assertThat(arg2Captor.getAllValues()).hasSize(3).allMatch(a -> !a.contains("spring"));
		
	}
}
