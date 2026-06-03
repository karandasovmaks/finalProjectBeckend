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
@Table(name = "assignments")
public class Assignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(name = "test_id")
    @JsonProperty("test_id")
    private Long testId;

    @Column(name = "class_id")
    @JsonProperty("class_id")
    private Long classId;

    @Column(name = "teacher_id")
    @JsonProperty("teacher_id")
    private Long teacherId;
}
