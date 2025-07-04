package com.hoa.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(0, new Todo(++todosCount, "Hoaabc", "Learn Spring 1", LocalDate.now().plusMonths(6), false));
		todos.add(1, new Todo(++todosCount, "Hoaabc", "Learn REST 1", LocalDate.now().plusMonths(10), false));
		todos.add(2, new Todo(++todosCount, "Hoaabc", "Learn DevOps 1", LocalDate.now().plusYears(1), false));
		todos.add(3, new Todo(++todosCount, "Hoaabc", "Confess 1", LocalDate.now().plusMonths(1), false));
	}
	//static list: danh sách đc làm mới mỗi lần sever khởi động lại
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate );
	}
	

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
}
