package com.trainwithme.service.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.model.UserDto;

@Entity
@Table(name = "trainings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    private Integer id;
    private String title;
    private String description;
    private String overallRating;
    private String trainingLevel;

    private String imageUrl;
    private UserDto createdBy;
}
