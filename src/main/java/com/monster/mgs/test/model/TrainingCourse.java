package com.monster.mgs.test.model;

import com.monster.mgs.test.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAINING_COURSE")
public class TrainingCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_ID")
  private Long id;

  @Column(name="NAME", length = Constants.MAX_TRAINING_COURSE_NAME, nullable = false)
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "TrainingCourse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  
}