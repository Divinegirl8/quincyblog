package com.quincyblog.data.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Blog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String url;
    @Column(length = 10000)
    private String description;
    private String postNumber;
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Comment> comments;
}
