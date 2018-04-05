package com.company.todo.dao;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.todo.model.Task;

@Document(collection = "task")
public interface TaskRepository extends MongoRepository<Task, String> {

	public Task findById(String taskId);
	
	public Task findByTaskStatus(String taskStatus);
	
	public Task findByTaskName(String taskName);

}