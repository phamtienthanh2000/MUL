package com.MUL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "article" ,fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST , CascadeType.MERGE}, orphanRemoval = true)
    private List<Tag> tag;
    private String level;
    private String description;
    @Column(name = "picture_source")
    private String pictureSource;
}
