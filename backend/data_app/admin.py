from django.contrib import admin
from data_app.models.data_models import Training, TrainingType

# Register your models here.

admin.site  .register([Training, TrainingType])

