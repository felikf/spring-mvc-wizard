package com.monster.mgs.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TRAINING_COURSE_FEEDBACK")
public class TrainingCourseFeedback {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_FEEDBACK_ID")
  private Long id;

  @ManyToOne(optional=false, fetch = FetchType.EAGER)
  @JoinColumn(name="VISITOR_ID", nullable=false, updatable=false)
  private Visitor visitor;

  @ManyToOne(optional=false, fetch = FetchType.EAGER)
  @JoinColumn(name="TRAINING_COURSE_ID", nullable=false, updatable=false)
  private TrainingCourse trainingCourse;

  @ManyToOne(optional=false, fetch = FetchType.EAGER)
  @JoinColumn(name="FAVORITE_SECTION_ID", nullable=false, updatable=false)
  private TrainingCourseSection favoriteSection;

  @Column(name = "RATING", nullable = false)
  private Integer rating;

  @Column(name = "TRAINING_COURSE_DATE", nullable = false)
  private Date date;

  @Column(name="COMMENT", length = Constants.MAX_COMMENT_LENGTH)
  String comment;

  public Long getId() {
    return id;
  }

  public Visitor getVisitor() {
    return visitor;
  }

  public void setVisitor(Visitor visitor) {
    this.visitor = visitor;
  }

  public TrainingCourse getTrainingCourse() {
    return trainingCourse;
  }

  public void setTrainingCourse(TrainingCourse trainingCourse) {
    this.trainingCourse = trainingCourse;
  }

  public TrainingCourseSection getFavoriteSection() {
    return favoriteSection;
  }

  public void setFavoriteSection(TrainingCourseSection favoriteSection) {
    this.favoriteSection = favoriteSection;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}