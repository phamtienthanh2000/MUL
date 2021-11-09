package com.MUL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadingTest extends Test{
    @Column(name = "text_theme")
    private String textTheme;
    private String paragraph;


}
