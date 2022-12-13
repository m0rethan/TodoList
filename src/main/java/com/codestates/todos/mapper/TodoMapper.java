package com.codestates.todos.mapper;

import com.codestates.todos.dto.TodoPatchDto;
import com.codestates.todos.dto.TodoPostDto;
import com.codestates.todos.dto.TodoResponseDto;
import com.codestates.todos.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    //TodoPostDto를 Todo로 변환
    public Todo todoPostDtoToTodo(TodoPostDto todoPostDto) {
        return new Todo(0,
                todoPostDto.getTitle(),
                todoPostDto.getTodo_order(),
                todoPostDto.isCompleted());
    }

    //TodoPatchDto를 Todo로 변환
    public Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto) {
        return new Todo(todoPatchDto.getId(),
                todoPatchDto.getTitle(),
                todoPatchDto.getTodo_order(),
                todoPatchDto.isCompleted());
    }

    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        return new TodoResponseDto(todo.getId(),
                todo.getTitle(),
                todo.getTodo_order(),
                todo.isCompleted());
    }
}
