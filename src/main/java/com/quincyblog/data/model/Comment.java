package com.quincyblog.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> messages;
    private String name;
}
