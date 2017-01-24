package com.monster.mgs.test.model;

import com.monster.mgs.test.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAINING_COURSE_SECTION")
public class TrainingCourseSection {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_SECTION_ID")
  private Long id;

  @Column(name="NAME", length = Constants.MAX_TRAINING_COURSE_SECTION_NAME, nullable = false)
  private String name;

  @Column(name="TRAINING_COURSE_ID", nullable = false)
  private Long trainingCourseId;

  /**
   * Default...
   */
  public TrainingCourseSection() {
    //empty
  }

  public TrainingCourseSection(Long id, String name, Long trainingCourseId) {
    this.id = id;
    this.name = name;
    this.trainingCourseId = trainingCourseId;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTrainingCourseId() {
    return trainingCourseId;
  }

  public void setTrainingCourseId(Long trainingCourseId) {
    this.trainingCourseId = trainingCourseId;
  }

  @Override
  public String toString() {
    return "TrainingCourseSection{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}