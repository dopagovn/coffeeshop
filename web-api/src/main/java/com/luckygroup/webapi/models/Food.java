package com.luckygroup.webapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer idFood;

  private String nameFood;

  private String description;


  public Integer getIdFood() {
    return idFood;
  }

  public void setIdFood(Integer idFood) {
    this.idFood = idFood;
  }

  public String getNameFood() {
    return nameFood;
  }

  public void setNameFood(String nameFood) {
    this.nameFood = nameFood;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
