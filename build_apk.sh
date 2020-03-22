#!/bin/bash

docker build -t telegram-build .
docker run --rm -v "$PWD":/home/gradle/ -w /home/gradle telegram-build gradle assembleRelease
