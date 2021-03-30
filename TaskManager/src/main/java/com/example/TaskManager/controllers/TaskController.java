package com.example.TaskManager.controllers;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.entities.User;

@Controller
public class TaskController {
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);

	
	@Autowired
	TaskService taskService; 

	@GetMapping(value="/")
    public String showIndexPage() {   
		 return "index";
    }
	
	@GetMapping(value="/add-task")
    public String addTaskForm() {   

		return "add-task";
	}
	
	@PostMapping("/add-task") 
	public String submitTaskPage(ModelMap model, @RequestParam String name,@RequestParam String desc, @RequestParam Date sdate, @RequestParam Date edate,
			@RequestParam String email, @RequestParam String sev) {
		Task t = new Task();
		t.setName(name);
		t.setDescription(desc);
		t.setStartDate(sdate);
		t.setEndDate(edate);
		t.setEmail(email);
		t.setSeverity(sev);
		model.addAttribute("task",t);
		taskService.UpdateTask(t);
		
		
		return "task-added";
	}
	
	@GetMapping(value="tasks")
	public String taskMenu() {
		
		return "tasks";
	}
	
	@GetMapping("show-tasks")
	public String showTasks(ModelMap model) {
		logger.info("Getting all Users");
		Iterable<Task> tasks = taskService.GetAllTasks();
			
		logger.info("Passing users to view");
		    model.addAttribute("task", tasks);    
			
	        return "show-tasks";
	    }
	
	
	@GetMapping("delete-task")
	public String deleteTask() {
		
		return "delete-task";
	}
	

	@PostMapping("/delete-task")
	public String deletedTask(@RequestParam int id) {
		Task t = new Task();
		t = taskService.GetTaskById(id);
		taskService.DeleteTask(t.getId());
		
		return "delete-success";
		
	}
	
	@GetMapping("edit-task")
	public String editTaskForm() {
		
		return "edit-task";
	}
	
	
	@PostMapping("edit-task")
	public String editTask(ModelMap model, @RequestParam int id,  @RequestParam String name,@RequestParam String desc, @RequestParam Date sdate, @RequestParam Date edate,
			@RequestParam String email, @RequestParam String sev) {
		Task t = taskService.GetTaskById(id);
		t.setName(name);
		t.setDescription(desc);
		t.setStartDate(sdate);
		t.setEndDate(edate);
		t.setEmail(email);
		t.setSeverity(sev);
		model.addAttribute("task",t);
		taskService.UpdateTask(t);
		return "edit-success";
	}


	
	}

	


