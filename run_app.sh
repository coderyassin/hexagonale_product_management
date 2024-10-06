#!/bin/bash

# Get the directory where this script is located
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)

# Set the paths relative to this directory
DOCKER_COMPOSE_PATH="$SCRIPT_DIR/docker-compose.yml"
ENV_PATH="$SCRIPT_DIR/.env"

# Check if the required argument (directory path) is provided
if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <path_to_directory>"
  exit 1
fi

CONFIG_DIR=$1
CONFIG_FILE="$CONFIG_DIR/config.conf"  # Path to the configuration file

# Check if docker-compose.yml exists
if [ ! -f "$DOCKER_COMPOSE_PATH" ]; then
  echo "Error: docker-compose.yml not found in $SCRIPT_DIR"
  exit 1
fi

# Check if the configuration file exists
if [ ! -f "$CONFIG_FILE" ]; then
  echo "Error: Configuration file config.conf not found in $SCRIPT_DIR"
  exit 1
fi

# Dynamically retrieve the machine's IP address
VM_IP=$(hostname -I | awk '{print $1}')

# Source the configuration file to load the MySQL credentials
source "$CONFIG_FILE"

# Check if the .env file exists, and remove it if it does
if [ -f "$ENV_PATH" ]; then
  echo ".env file found, deleting it."
  rm "$ENV_PATH"
fi

# Create the .env file with the VM_IP and MySQL variables
cat <<EOL > "$ENV_PATH"
VM_IP=$VM_IP
MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD
MYSQL_USER=$MYSQL_USER
MYSQL_PASSWORD=$MYSQL_PASSWORD
EOL

# Navigate to the directory containing the docker-compose.yml
cd "$SCRIPT_DIR" || exit

# Run the docker-compose up -d --build command
docker-compose up -d --build

# Display a message indicating the completion
echo "docker-compose up -d --build executed successfully"