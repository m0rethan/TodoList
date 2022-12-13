package com.codestates.todos.controller;

import com.codestates.todos.dto.TodoPatchDto;
import com.codestates.todos.dto.TodoPostDto;
import com.codestates.todos.dto.TodoResponseDto;
import com.codestates.todos.entity.Todo;
import com.codestates.todos.mapper.TodoMapper;
import com.codestates.todos.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoPostDto todoPostDto) {
        Todo response = todoService.createTodo(todoMapper.todoPostDtoToTodo(todoPostDto));

        return new ResponseEntity(todoMapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@PathVariable("id") int id,
                                    @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setId(id);

        Todo response = todoService.updateTodo(todoMapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity(todoMapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }


    //해당 todo만 조회
    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable("id") int id) {
        Todo response = todoService.findTodo(id);
        return new ResponseEntity(todoMapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    //전체 조회
    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todoList = todoService.findTodoList();

        //todoList 값이 List이므로 안에 Todo객체들을 하나씩 꺼내어
        // TodoResponseDto객체로 변환
        List<TodoResponseDto> response =
                todoList.stream()
                        .map(todo -> todoMapper.todoToTodoResponseDto(todo))
                        .collect(Collectors.toList());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //해당 todo만 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
        System.out.println("delete Todo");

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //전체 삭제
    @DeleteMapping
    public ResponseEntity deleteAll() {
        todoService.deleteTodoList();
        System.out.println("delete Todo List");

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
