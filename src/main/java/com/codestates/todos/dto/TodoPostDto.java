package com.codestates.todos.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoPostDto {
    @NotBlank
    private String title;

    @NotBlank
    private int todo_order;

    @NotBlank
    private boolean completed;

    /*
    getter가 필요한 이유
    Controller에서 PostDto를 response body로 전달 하므로,
    MappingJackson2HttpMessageConverter가 PostDto를 JSON 문자열로 변환할 때 getter를 사용하므로
    */
}
