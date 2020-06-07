FROM python:3
ADD test_service/ /test_service
WORKDIR /test_service
RUN apt-get update
RUN pip install -r requirements.txt
CMD python test_service.py
