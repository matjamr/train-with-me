from django.urls import path, include

from data_app.api.views import TrainingTypeAV, TrainingTypeByIdAV, TrainingAV, TrainingByIdAV

urlpatterns = [
    path('training/type/', TrainingTypeAV.as_view(), name="training-type"),
    path('training/type/<int:pk>', TrainingTypeByIdAV.as_view(), name="training-type-by-id"),
    path('training/', TrainingAV.as_view(), name="training"),
    path('training/<int:pk>', TrainingByIdAV.as_view(), name="training")
]