#!/bin/bash

# BrightSprouts Build Script
# This script helps build and install the app for both mobile and TV

set -e

echo "🌱 BrightSprouts Build Script"
echo "=============================="

# Function to display usage
usage() {
    echo "Usage: $0 [OPTION]"
    echo "Options:"
    echo "  mobile     Build and install mobile app"
    echo "  tv         Build and install TV app"
    echo "  both       Build and install both apps"
    echo "  clean      Clean all build artifacts"
    echo "  test       Run all tests"
    echo "  help       Show this help message"
}

# Function to build mobile app
build_mobile() {
    echo "📱 Building mobile app..."
    ./gradlew :app:assembleMobileDebug
    echo "✅ Mobile app built successfully!"
}

# Function to build TV app
build_tv() {
    echo "📺 Building TV app..."
    ./gradlew :tv:assembleTvDebug
    echo "✅ TV app built successfully!"
}

# Function to install mobile app
install_mobile() {
    echo "📱 Installing mobile app..."
    ./gradlew :app:installMobileDebug
    echo "✅ Mobile app installed successfully!"
}

# Function to install TV app
install_tv() {
    echo "📺 Installing TV app..."
    ./gradlew :tv:installTvDebug
    echo "✅ TV app installed successfully!"
}

# Function to clean build artifacts
clean_build() {
    echo "🧹 Cleaning build artifacts..."
    ./gradlew clean
    echo "✅ Build artifacts cleaned!"
}

# Function to run tests
run_tests() {
    echo "🧪 Running tests..."
    ./gradlew test
    echo "✅ Tests completed!"
}

# Main script logic
case "${1:-help}" in
    mobile)
        build_mobile
        install_mobile
        ;;
    tv)
        build_tv
        install_tv
        ;;
    both)
        build_mobile
        build_tv
        install_mobile
        install_tv
        ;;
    clean)
        clean_build
        ;;
    test)
        run_tests
        ;;
    help|--help|-h)
        usage
        ;;
    *)
        echo "❌ Unknown option: $1"
        usage
        exit 1
        ;;
esac

echo ""
echo "🎉 Done! Happy learning with BrightSprouts!"
