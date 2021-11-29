package com.MUL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Test {
    @Id
    @SequenceGenerator(
            name = "test_sequence_generator",
            sequenceName = "test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "test_sequence_generator"

    )
    private Long id;
    @Column(name="test_type"
    ,nullable = false)
    private String testType;
    @Column(name="test_name",
    nullable = false
    )
    private String testName;
    @Column(name="test_level")
    private String level;

    @OneToMany(mappedBy = "test" ,fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Question> questionList;

}
