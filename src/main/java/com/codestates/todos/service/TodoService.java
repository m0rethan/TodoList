package com.codestates.todos.service;

import com.codestates.todos.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public Todo createTodo(Todo todo) {
        Todo createdTodo = todo;
        return createdTodo;
    }

    public Todo updateTodo(Todo todo) {
        Todo updatedTodo = todo;
        return updatedTodo;
    }

    public Todo findTodo(int id) {
        Todo todo = new Todo(id, "title", 1, false);
        return todo;
    }

    public List<Todo> findTodoList() {
        List<Todo> todoList = List.of(
                new Todo(1, "title", 1, false),
                new Todo(2, "title", 1, false)
        );
        return todoList;
    }

    public void deleteTodo(int id) {
    }

    public void deleteTodoList() {
    }
}
