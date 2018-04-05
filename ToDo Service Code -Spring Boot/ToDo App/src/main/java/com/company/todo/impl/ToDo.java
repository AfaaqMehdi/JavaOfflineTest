package com.company.todo.impl;

import java.util.List;

import com.company.todo.model.Task;

public interface ToDo {

	public List<Task> insertTask(String taskName);
	
	public List<Task> updateTask(Task task);
	
	public List<Task> retriveTask();
	
	public List<Task> deleteTask(String taskId);
	
}