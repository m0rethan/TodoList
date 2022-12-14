package com.codestates.todos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;


    @Column(nullable = false)
    private String title;

    private int todo_order;

    @Column(nullable = false)
    private boolean completed;

    public Todo(Long todoId) {
        this.todoId = todoId;
    }

}
/*
API 계층에서 전달 받은 요청 데이터를 기반으로
서비스 계층에서 비즈니스 로직을 처리하기 위해 필요한 데이터를 전달 받고,
비즈니스 로직을 처리한 후에는 결과 값을 다시 API 계층으로 리턴해주는 역할
 */