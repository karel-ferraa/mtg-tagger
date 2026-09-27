#!/bin/bash

curl --request DELETE "http://localhost:8080/tags/art/weapon?parent=true" \
-H "Content-Type: application/json" \
-d '[{"type":"art", "name":"sword"}]'
