package com.learning.java_junit_mockito.todos.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoIntegrationService {
	//static data for simulation
	//static content is shared among instances
	//also one instance of this map will exist per class
	//everytime we instantiate a new object even then it reflects to same static map
	private static final Map<String, List<String>> todosContent;
	//gets called once per class load
	//do not get called on constructor as we always going to have same data
	//data is read only and write is blocked
	static {
		todosContent = new HashMap<>();
		todosContent.put("user1", Arrays.asList("junit learning","spring boot","spring data jpa","java streams"));
		
		todosContent.put("user2", Arrays.asList("junit learning","spring boot","kafka","java generics"));
	
		todosContent.put("user3", Arrays.asList("junit learning","spring boot","rabbitmq","java lambda"));
		
		todosContent.put("user4", Arrays.asList("junit learning","spring boot","mongo","activemq"));
	}
	
	//actually this method could be taking data form DB/webservice both are external syste
	
	public List<String> fetchToDosForUser(String user){
		if(!todosContent.containsKey(user)) {
			throw new RuntimeException("user is not present");
		}
		return todosContent.get(user);
	}
	
	public void fakeMethod() {
		System.out.println("ToDoIntegrationService.fakemethod() called");
	}
	
	public void deleteTodosForUser(String user, String todo) {
		System.out.println("ToDoIntegrationService.deleteTodosForUser: Called for user "+user);
		
		/*
		 * List<String> todos = todosContent.get(user); List<String> newtodos = new
		 * ArrayList<String>(); for(String todoExisting : todos) {
		 * if(!todo.equals(todoExisting)) { newtodos.add(todoExisting); } }
		 * todosContent.put(user, newtodos);
		 */
	}
}
