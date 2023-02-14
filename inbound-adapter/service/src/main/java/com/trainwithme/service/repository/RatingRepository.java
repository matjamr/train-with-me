package com.trainwithme.service.repository;

import com.trainwithme.service.models.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
