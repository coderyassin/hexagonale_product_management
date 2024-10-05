#!/bin/bash

# Check if the required arguments are provided
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <path_to_docker_compose.yml> <path_to_.env>"
  exit 1
fi

# Get the paths from the arguments
DOCKER_COMPOSE_PATH=$1
ENV_PATH=$2

# Dynamically retrieve the machine's IP address
VM_IP=$(hostname -I | awk '{print $1}')

# Create the .env file with the VM_IP variable
echo "VM_IP=$VM_IP" > "$ENV_PATH"

# Display a confirmation message
echo ".env file created at: $ENV_PATH with VM_IP=$VM_IP"

# Navigate to the directory containing the docker-compose.yml
cd "$(dirname "$DOCKER_COMPOSE_PATH")" || exit

# Run the docker-compose up -d --build command
docker-compose -f "$(basename "$DOCKER_COMPOSE_PATH")" up -d --build

# Display a message indicating the completion
echo "docker-compose up -d --build executed"