@echo off
REM BrightSprouts Build Script for Windows
REM This script helps build and install the app for both mobile and TV

echo 🌱 BrightSprouts Build Script
echo ==============================

if "%1"=="mobile" goto build_mobile
if "%1"=="tv" goto build_tv
if "%1"=="both" goto build_both
if "%1"=="clean" goto clean_build
if "%1"=="test" goto run_tests
if "%1"=="help" goto show_help
if "%1"=="--help" goto show_help
if "%1"=="-h" goto show_help
if "%1"=="" goto show_help

echo ❌ Unknown option: %1
goto show_help

:build_mobile
echo 📱 Building mobile app...
call gradlew.bat :app:assembleMobileDebug
if %errorlevel% neq 0 goto error
echo 📱 Installing mobile app...
call gradlew.bat :app:installMobileDebug
if %errorlevel% neq 0 goto error
echo ✅ Mobile app built and installed successfully!
goto end

:build_tv
echo 📺 Building TV app...
call gradlew.bat :tv:assembleTvDebug
if %errorlevel% neq 0 goto error
echo 📺 Installing TV app...
call gradlew.bat :tv:installTvDebug
if %errorlevel% neq 0 goto error
echo ✅ TV app built and installed successfully!
goto end

:build_both
echo 📱 Building mobile app...
call gradlew.bat :app:assembleMobileDebug
if %errorlevel% neq 0 goto error
echo 📺 Building TV app...
call gradlew.bat :tv:assembleTvDebug
if %errorlevel% neq 0 goto error
echo 📱 Installing mobile app...
call gradlew.bat :app:installMobileDebug
if %errorlevel% neq 0 goto error
echo 📺 Installing TV app...
call gradlew.bat :tv:installTvDebug
if %errorlevel% neq 0 goto error
echo ✅ Both apps built and installed successfully!
goto end

:clean_build
echo 🧹 Cleaning build artifacts...
call gradlew.bat clean
if %errorlevel% neq 0 goto error
echo ✅ Build artifacts cleaned!
goto end

:run_tests
echo 🧪 Running tests...
call gradlew.bat test
if %errorlevel% neq 0 goto error
echo ✅ Tests completed!
goto end

:show_help
echo Usage: %0 [OPTION]
echo Options:
echo   mobile     Build and install mobile app
echo   tv         Build and install TV app
echo   both       Build and install both apps
echo   clean      Clean all build artifacts
echo   test       Run all tests
echo   help       Show this help message
goto end

:error
echo ❌ Build failed!
exit /b 1

:end
echo.
echo 🎉 Done! Happy learning with BrightSprouts!
