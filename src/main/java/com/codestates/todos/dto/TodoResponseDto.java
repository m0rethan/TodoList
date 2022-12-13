package com.codestates.todos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private int id;
    private String title;
    private int todo_order;
    private boolean completed;
}
