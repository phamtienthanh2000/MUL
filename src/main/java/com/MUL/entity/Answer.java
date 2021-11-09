package com.MUL.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_sequence_generator",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence_generator"

    )
    private Long id;

    @Column(name= "answer_name")
    private String answerName;

    @Column(name ="answer_content")
    private String answerContent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "question_id")
    private Question question;



}
