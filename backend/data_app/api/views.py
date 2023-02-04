from rest_framework import views, status
from rest_framework.response import Response
from rest_framework.request import Request

from data_app.api.serializers import TrainingTypeSerializer, TrainingSerializer
from data_app.models.data_models import TrainingType, Training


class TrainingTypeAV(views.APIView):

    def get(self, request: Request) -> Response:
        models: list[TrainingType] = TrainingType.objects.all()
        serializer = TrainingTypeSerializer(models, many=True)
        return Response(serializer.data)

    def post(self, request: Request) -> Response:
        serializer = TrainingTypeSerializer(data=request.data)

        if not serializer.is_valid():
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        serializer.save()

        return Response(serializer.data, status=status.HTTP_201_CREATED)


class TrainingTypeByIdAV(views.APIView):

    def get(self, request: Request, pk: int) -> Response:
        model: TrainingType = TrainingType.objects.get(pk=pk)

        if model is None:
            return Response({"error": "There is no training type with id {}".format(pk)})

        serializer = TrainingTypeSerializer(model)
        return Response(serializer.data)

    def post(self, request: Request) -> Response:
        serializer = TrainingTypeSerializer(data=request.data)

        if not serializer.is_valid():
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)


class TrainingAV(views.APIView):

    def get(self, request: Request) -> Response:
        models: list[Training] = Training.objects.all()
        serializer = TrainingSerializer(models, many=True)
        return Response(serializer.data)

    def post(self, request: Request) -> Response:
        serializer = TrainingSerializer(data=request.data)

        if not serializer.is_valid():
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)


class TrainingByIdAV(views.APIView):

    def get(self, request: Request, pk: int) -> Response:
        model: Training = Training.objects.get(pk=pk)

        if model is None:
            return Response({"error": "There is no training type with id {}".format(pk)})

        serializer = TrainingSerializer(model)
        return Response(serializer.data)

    def post(self, request: Request) -> Response:
        serializer = TrainingSerializer(data=request.data)

        if not serializer.is_valid():
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
