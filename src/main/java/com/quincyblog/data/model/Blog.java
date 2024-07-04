package com.quincyblog.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String url;
    @Column(length = 10000)
    private String description;
}
