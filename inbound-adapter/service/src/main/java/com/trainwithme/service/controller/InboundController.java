package com.trainwithme.service.controller;

import org.openapitools.api.TrainingApi;
import org.openapitools.model.RatingDto;
import org.openapitools.model.TrainingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class InboundController implements TrainingApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return TrainingApi.super.getRequest();
    }

    @Override
    public ResponseEntity<RatingDto> getRatingsForTraining(Integer id) {
        return TrainingApi.super.getRatingsForTraining(id);
    }

    @Override
    public ResponseEntity<TrainingDto> getTrainingById(Integer id) {
        return TrainingApi.super.getTrainingById(id);
    }

    @Override
    public ResponseEntity<TrainingDto> getTrainings(Integer limit) {
        return TrainingApi.super.getTrainings(limit);
    }
}
