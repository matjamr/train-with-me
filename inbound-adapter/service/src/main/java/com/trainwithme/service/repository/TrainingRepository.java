package com.trainwithme.service.repository;

import com.trainwithme.service.models.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
