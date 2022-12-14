package com.codestates.todos.mapstruct.mapper;

import com.codestates.todos.dto.TodoPatchDto;
import com.codestates.todos.dto.TodoPostDto;
import com.codestates.todos.dto.TodoResponseDto;
import com.codestates.todos.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
}

//MapStruct 기반의 매퍼(Mapper)
