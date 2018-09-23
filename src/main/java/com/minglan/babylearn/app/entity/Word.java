package com.minglan.babylearn.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Word
 * 单词
 * 18/9/23 11:20
 * @author yangling
 * @version 1.0
 */
@Entity
public class Word {
    @Id
    @GeneratedValue
    private Integer id;
    private String enword;
    private String cnword;
}
