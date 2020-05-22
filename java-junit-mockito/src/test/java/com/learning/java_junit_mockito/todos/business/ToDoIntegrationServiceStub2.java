package com.learning.java_junit_mockito.todos.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.java_junit_mockito.todos.integration.ToDoIntegrationService;

public class ToDoIntegrationServiceStub2 extends ToDoIntegrationService {
	private static final Map<String, List<String>> todosContent;
	//gets called once per class load
	//do not get called on constructor as we always going to have same data
	//data is read only and write is blocked
	static {
		todosContent = new HashMap<>();
		todosContent.put("user1", Arrays.asList("junit learning","spring boot","spring data jpa","java streams"));
		
		todosContent.put("user2", Arrays.asList("junit learning","spring boot","kafka","java generics"));
	
		//todosContent.put("user3", Arrays.asList("junit learning","spring boot","rabbitmq","java lambda"));
		
		todosContent.put("user4", Arrays.asList("junit learning","spring boot","mongo","activemq"));
	}
	
	//actually this method could be taking data form DB/webservice both are external syste
	
	public List<String> fetchToDosForUser(String user){
		if(!todosContent.containsKey(user)) {
			throw new RuntimeException("user is not present");
		}
		return todosContent.get(user);
	}
	
}
