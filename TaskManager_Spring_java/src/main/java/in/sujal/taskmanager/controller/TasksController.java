package in.sujal.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sujal.taskmanager.dto.CreateTaskDTO;
import in.sujal.taskmanager.entities.TaskEntity;
import in.sujal.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	private final TaskService taskService;
	public TasksController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<TaskEntity>> getTasks(){
		var tasks = taskService.getTask();
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id")Integer id){
		var task = taskService.getTaskById(id);
		
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(task);
	}
	
	@PostMapping("")
	public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body){
		var task = taskService.addTask(body.getTitle(),body.getDescription(),body.getDeadline());
		return ResponseEntity.ok(task);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
