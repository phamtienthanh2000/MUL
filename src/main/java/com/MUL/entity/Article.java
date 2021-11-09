package com.MUL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_sequence_generator",
            sequenceName = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_sequence_generator"
    )
    private Long id;
    private String title;
    private String tag;
    private String level;
    private String description;
    @Column(name = "picture_source")
    private String pictureSource;
}
