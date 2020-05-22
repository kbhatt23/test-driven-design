package com.learning.java_junit_mockito.todos.business;
//This calls is system under test

import java.util.List;
import java.util.stream.Collectors;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class TodosBusinessService {
	public TodosBusinessService(ToDoIntegrationService integrationservice) {
		this.integrationservice = integrationservice;
	}
	private String fakeMessage;

	public TodosBusinessService(String fakeMessage, ToDoIntegrationService integrationservice) {
		this.fakeMessage = fakeMessage;
		this.integrationservice = integrationservice;
	}
	private ToDoIntegrationService integrationservice;
	
	public List<String> findSpringTodos(String user){
		List<String> todosSpring = integrationservice.fetchToDosForUser(user)
				.stream()
				.filter(todos -> todos.contains("spring"))
				.collect(Collectors.toList());
		if(todosSpring == null || todosSpring.isEmpty()) {
			throw new RuntimeException("no todos found");
		}
		return todosSpring;
	}
	
	public TodosBusinessService() {
		super();
	}

	public void fakeMethod() {
		System.out.println("TodosBusinessService.fakemethod() called "+fakeMessage);
	}
	
	public void deleteNonSpringTodos(String user) {
		List<String> fetchToDosForUser = integrationservice.fetchToDosForUser(user);
		for(String todo : fetchToDosForUser) {
			if(!todo.contains("spring")) {
				integrationservice.deleteTodosForUser(user,todo);
			}
		}
		
	}
	
}
