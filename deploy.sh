#!/bin/sh
kubectl apply -f namespace.yml
kubectl apply -f secretspec.yml
kubectl apply -f deployspec.yml
kubectl apply -f servicespec.yml