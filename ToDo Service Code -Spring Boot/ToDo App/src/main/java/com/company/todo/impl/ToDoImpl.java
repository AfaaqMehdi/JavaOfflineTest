package com.company.todo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.company.todo.dao.TaskRepository;
import com.company.todo.model.Task;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Service
public class ToDoImpl implements ToDo {

	@Autowired
	private TaskRepository repository;

	@Override
	public List<Task> insertTask(String taskName) {
		Task task = new Task();
		task.setTaskName(taskName);
		task.setTaskStatus("Pending");
		repository.save(task);

		return retriveTask();
	}

	@Override
	public List<Task> updateTask(Task task) {
		Task taskRetrieved = repository.findById(task.getId());
		taskRetrieved.setTaskStatus("Completed");
		repository.save(taskRetrieved);
		return retriveTask();
	}

	@Override
	public List<Task> retriveTask() {
		List<Task> taskList = repository.findAll();
		return taskList;
	}

	@Override
	public List<Task> deleteTask(String taskId) {
		Task task = new Task();
		task.setId(taskId);
		repository.delete(task);
		return retriveTask();
	}

	public TaskRepository getRepository() {
		return repository;
	}

	public void setRepository(TaskRepository repository) {
		this.repository = repository;
	}

}
