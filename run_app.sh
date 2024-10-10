#!/bin/bash

# Get the directory where this script is located
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)

# Set the paths relative to this directory
DOCKER_COMPOSE_PATH="$SCRIPT_DIR/docker-compose.yml"
ENV_PATH="$SCRIPT_DIR/.env"

# Check if the required arguments (environment and config directory) are provided
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <environment> <config_directory>"
  echo "Example: $0 prod /path/to/config"
  exit 1
fi

# Capture the environment argument (prod, preprod, dev, etc.)
ENVIRONMENT=$1

# Check if the appropriate docker-compose file exists for the given environment
DOCKER_COMPOSE_ENV_FILE="$SCRIPT_DIR/docker-compose.$ENVIRONMENT.yml"
if [ ! -f "$DOCKER_COMPOSE_ENV_FILE" ]; then
  echo "Error: docker-compose.$ENVIRONMENT.yml not found in $SCRIPT_DIR"
  exit 1
fi

# Capture the configuration directory argument
CONFIG_DIR=$2
CONFIG_FILE="$CONFIG_DIR/config.conf"  # Path to the configuration file
#CONFIG_FILE="/home/yascode/config/hexagonale_product_management/config.conf"

# Check if the docker-compose.yml exists
if [ ! -f "$DOCKER_COMPOSE_PATH" ]; then
  echo "Error: docker-compose.yml not found in $SCRIPT_DIR"
  exit 1
fi

# Check if the configuration file exists
if [ ! -f "$CONFIG_FILE" ]; then
  echo "Error: Configuration file config.conf not found in $CONFIG_DIR"
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
DB_NAME=$DB_NAME
MYSQL_USER=$MYSQL_USER
MYSQL_PASSWORD=$MYSQL_PASSWORD
DB_USER=$DB_USER
DB_PASSWORD=$DB_PASSWORD
REDIS_HOST=$VM_IP
EOL

# Navigate to the directory containing the docker-compose.yml
cd "$SCRIPT_DIR" || exit

# Run the docker-compose up command with the selected environment
docker-compose -f docker-compose.yml -f docker-compose.$ENVIRONMENT.yml up -d --build

# Display a message indicating the completion
echo "docker-compose up -d --build executed successfully for $ENVIRONMENT environment"
