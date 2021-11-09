package com.MUL.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @SequenceGenerator(
            name =  "question_sequence_generator",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence_generator"
    )
    private Long id;

    @Column(name = "question_number")
    private int questionNumber;
    /*
     correctAnswer
     */

    @Column(name = "correct_answer_name")
    private String correctAnswerName;

    @Column(name ="question_content")
    private String questionContent;

    private String explaination;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Answer> answerList;




}
