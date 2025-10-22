#!/bin/bash

# Simple script to compile and run Java files
# Usage: ./run.sh <java_file>

if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <java_file>"
    echo "Example: ./run.sh solutions/1-arrays_and_strings/IsUnique.java"
    echo ""
    echo "Available Java files:"
    find solutions -name "*.java" | sed 's|^|  |'
    exit 1
fi

JAVA_FILE="$1"

# Check if file exists
if [ ! -f "$JAVA_FILE" ]; then
    echo "Error: File '$JAVA_FILE' not found!"
    exit 1
fi

# Extract directory and filename
DIR=$(dirname "$JAVA_FILE")
FILENAME=$(basename "$JAVA_FILE" .java)

# Create build directory
BUILD_DIR="build"
mkdir -p "$BUILD_DIR"

# Compile the Java file
echo "Compiling $JAVA_FILE..."
javac -d "$BUILD_DIR" "$JAVA_FILE"

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running $FILENAME..."
    echo "=========================================="
    
    # Run the compiled class
    java -cp "$BUILD_DIR" "$FILENAME"
    
    echo "=========================================="
    echo "Execution completed!"
else
    echo "Compilation failed!"
    exit 1
fi
