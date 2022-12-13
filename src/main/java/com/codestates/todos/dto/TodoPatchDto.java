package com.codestates.todos.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoPatchDto {
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private int todo_order;

    @NotBlank
    private boolean completed;

    /*
    setCoffeeId()가 필요한 이유
    핸들러 메서드에서 path variable로 전달 받은 id를 setId()를 통해
    필드를 채움으로써 response body에 포함시킬 수 있습니다.
    */
}
