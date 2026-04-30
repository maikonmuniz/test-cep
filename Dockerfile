FROM ubuntu:latest
LABEL authors="mikemike"

ENTRYPOINT ["top", "-b"]