package com.trainwithme.service.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.model.TrainingDto;
import org.openapitools.model.UserDto;

@Entity
@Table(name = "rating")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private Integer id;
    private Object title;
    private Object stars;
    private UserDto createdBy;
    private TrainingDto training;
}
