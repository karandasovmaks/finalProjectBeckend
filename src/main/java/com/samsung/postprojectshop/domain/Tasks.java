package com.samsung.postprojectshop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(name = "test_id")
    @JsonProperty("test_id")
    private Long testId;

    @Column(name = "task_text")
    @JsonProperty("task_text")
    private String taskText;

    @Column(name = "answer")
    private String answer;

    @Column(name = "order_num")
    @JsonProperty("order_num")
    private Long orderNum;
}
