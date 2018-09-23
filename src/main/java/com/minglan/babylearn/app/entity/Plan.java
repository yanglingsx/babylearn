package com.minglan.babylearn.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Plan
 * 计划－任务
 * 18/9/23 11:20
 * @author yangling
 * @version 1.0
 */
@Entity
public class Plan {
    @Id
    @GeneratedValue
    private Integer id;

    private String startTime;

    private String endTime;
}
