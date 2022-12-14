package com.codestates.todos.service;

import com.codestates.todos.entity.Todo;
import com.codestates.todos.exception.BusinessLogicException;
import com.codestates.todos.exception.ExceptionCode;
import com.codestates.todos.repository.TodoRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Todo findTodo = findVerifiedTodo(todo.getTodoId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.isCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public Todo findTodo(Long todoId) {
        return findVerifiedTodo(todoId);
    }

    public List<Todo> findTodoList() {
        return todoRepository.findAll();
    }

    public void deleteTodo(Long todoId) {
        Todo findTodo = findVerifiedTodo(todoId);
        todoRepository.deleteById(findTodo.getTodoId());
    }

    public void deleteTodoList() {
        todoRepository.deleteAll();
    }

    public Todo findVerifiedTodo(Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo findTodo = optionalTodo.orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return findTodo;
    }
}
