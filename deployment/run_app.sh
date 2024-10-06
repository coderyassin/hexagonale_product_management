#!/bin/bash

# Get the directory where this script is located
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)

# Set the paths relative to this directory
DOCKER_COMPOSE_PATH="$SCRIPT_DIR/docker-compose.yml"
ENV_PATH="$SCRIPT_DIR/.env"

# Check if docker-compose.yml exists
if [ ! -f "$DOCKER_COMPOSE_PATH" ]; then
  echo "Error: docker-compose.yml not found in $SCRIPT_DIR"
  exit 1
fi

# Dynamically retrieve the machine's IP address
VM_IP=$(hostname -I | awk '{print $1}')

# Create the .env file with the VM_IP variable
echo "VM_IP=$VM_IP" > "$ENV_PATH"

# Display a confirmation message
echo ".env file created at: $ENV_PATH with VM_IP=$VM_IP"

# Navigate to the directory containing the docker-compose.yml
cd "$SCRIPT_DIR" || exit

# Run the docker-compose up -d --build command
docker-compose up -d --build

# Display a message indicating the completion
echo "docker-compose up -d --build executed successfully"