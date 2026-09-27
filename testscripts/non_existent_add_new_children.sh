#!/bin/bash

curl --request PUT "http://localhost:8080/tags/art/jkifsidk?parent=true" \
-H "Content-Type: application/json" \
-d '[{"type":"art", "name":"sword"}]'
