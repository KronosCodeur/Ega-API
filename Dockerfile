FROM ubuntu:latest
LABEL authors="flutt"

ENTRYPOINT ["top", "-b"]