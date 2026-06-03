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
@Table(name = "tests")
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(name = "name")
    private  String name;

    @Column(name = "description")
    private  String description;

    @Column(name = "image_link")
    private  Integer image_link;

    @Column(name = "created_by")
    private  Long created_by;

}
