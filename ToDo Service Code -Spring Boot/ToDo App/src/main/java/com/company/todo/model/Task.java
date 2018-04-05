package com.company.todo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","taskName", "taskStatus" })
public class Task {

	@JsonProperty("id")
	private String id;
	@JsonProperty("taskName")
	private String taskName;
	@JsonProperty("taskStatus")
	private String taskStatus;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("taskName")
	public String getTaskName() {
		return taskName;
	}

	@JsonProperty("taskName")
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	
	@JsonProperty("taskStatus")
	public String getTaskStatus() {
		return taskStatus;
	}

	@JsonProperty("taskStatus")
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
