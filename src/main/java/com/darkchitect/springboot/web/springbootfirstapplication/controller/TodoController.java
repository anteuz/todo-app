package com.darkchitect.springboot.web.springbootfirstapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.darkchitect.springboot.web.model.Todo;
import com.darkchitect.springboot.web.service.TodoRepository;

/*
 * Handles the simple login
 */
@Controller
public class TodoController {
	
	@Autowired
	TodoRepository repository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET )
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", repository.findByUsername(name));
		model.put("name", name);
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Default Desc", new Date(), false));
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST )
	public String addOrUpdateTodo(ModelMap model, @Valid Todo todo, BindingResult results) {
		if(results.hasErrors()) {
			return "add-todo";
		}
		
		todo.setUsername(getLoggedInUserName(model));
	
		repository.save(todo);
		
		//service.addTodo( name, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET )
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		repository.deleteById(id);
		//service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.GET )
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		//Todo todo = service.retrieveTodo(id);
		Optional<Todo> todo = repository.findById(id);
		if(todo.isPresent())
			model.put("todo", todo.get());
		return "add-todo";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.POST )
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todo";
		}
		
		todo.setUsername( getLoggedInUserName(model));
		repository.save(todo);
		//service.updateTodo(todo);
		
		return "redirect:/list-todos";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
}
