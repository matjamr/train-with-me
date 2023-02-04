from django.db import models
from django.utils.translation import gettext_lazy as _


class TrainingType(models.Model):
    type = models.CharField(max_length=20)
    added_by = models.CharField(max_length=20)
    creation_time = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.type


class Training(models.Model):

    class Difficulty(models.TextChoices):
        ADVANCED = 'AV', _("ADVANCED")
        MEDIUM = 'MD', _("MEDIUM")
        EASY = 'ES', _("EASY")
        TODDLER = 'TD', _("TODDLER")

    name = models.CharField(max_length=30)
    description = models.CharField(max_length=100)
    exercises = models.CharField(max_length=100)
    training_type = models.ForeignKey(TrainingType, on_delete=models.PROTECT, db_constraint=False)

    difficulty = models.CharField(
        max_length=2,
        choices=Difficulty.choices,
        default=Difficulty.MEDIUM
    )

    def __str__(self):
        return self.name

    # def create(self, validated_data: dict[str:str]):
    #     training_type = validated_data.pop('training_type')
    #
    #     model = Training.objects.create(**)

