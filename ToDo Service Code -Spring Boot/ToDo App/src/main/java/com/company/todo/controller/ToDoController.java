package com.company.todo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.todo.impl.ToDo;
import com.company.todo.model.Task;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

	private static final Logger LOGGER = Logger.getLogger(ToDoController.class);

	@Autowired
	private ToDo todo;

	@CrossOrigin
	@RequestMapping(value = "/task/{taskStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> fetchTask(@PathVariable("taskStatus") String taskStatus) {
		LOGGER.info("Entered ToDoController :: fetchTask ");
		List<Task> taskList = todo.retriveTask();
		return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	public ResponseEntity<List<Task>> createUser(@RequestBody String taskName) {
		LOGGER.info("Entered ToDoController :: createUser ");
		// Create Task
		List<Task> taskList = todo.insertTask(taskName);
	//	LOGGER.info(task  + " test " + task.toString() + " id " + task.getId());
		return new ResponseEntity<List<Task>>(taskList, HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/updateTask/{taskName}", method = RequestMethod.PUT)
	public ResponseEntity<List<Task>> updateTask(@PathVariable("taskName") String taskName, @RequestBody Task task) {
		LOGGER.info("Entered ToDoController :: updateTask ");
		// Update Task as Completed
		List<Task> taskList = todo.updateTask(task);
		return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Task>> deleteTask(@PathVariable("taskId") String taskId) {
		LOGGER.info("Entered ToDoController :: deleteTask ");
		List<Task> taskList = todo.deleteTask(taskId);
		return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
	}

}
