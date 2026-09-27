#!/bin/bash

curl --request POST "http://localhost:8080/tags" \
-H "Content-Type: application/json" \
-d '{"type":"art"}'
