from rest_framework import serializers
from rest_framework.response import Response

from data_app.models.data_models import TrainingType, Training


class TrainingTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = TrainingType
        fields = "__all__"


class TrainingSerializer(serializers.ModelSerializer):
    class Meta:
        model = Training
        fields = "__all__"

    def to_representation(self, instance: Training):
        response: Response = super().to_representation(instance)
        response['training_type'] = TrainingTypeSerializer(instance.training_type).data
        return response
