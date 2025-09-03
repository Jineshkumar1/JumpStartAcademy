# BrightSprouts Setup Guide

## 🚀 Quick Start

### Prerequisites
- Android Studio Hedgehog or later
- JDK 8 or later
- Android SDK 24+ (Android 7.0)
- Target SDK 35 (Android 15)

### Installation Steps

1. **Clone and Open**
   ```bash
   git clone <repository-url>
   cd brightsprouts
   ```
   Open the project in Android Studio.

2. **Sync Project**
   - Android Studio will automatically sync Gradle files
   - Wait for the sync to complete

3. **Build and Run**
   
   **For Windows:**
   ```cmd
   build.bat mobile    # Build and install mobile app
   build.bat tv        # Build and install TV app
   build.bat both      # Build and install both apps
   ```
   
   **For macOS/Linux:**
   ```bash
   ./build.sh mobile   # Build and install mobile app
   ./build.sh tv       # Build and install TV app
   ./build.sh both     # Build and install both apps
   ```

   **Or use Gradle directly:**
   ```bash
   ./gradlew :app:installMobileDebug
   ./gradlew :tv:installTvDebug
   ```

## 📱 Testing the Apps

### Mobile App
1. Install on Android device or emulator
2. Launch "BrightSprouts" app
3. Navigate through different learning categories
4. Test lesson interactions

### Android TV App
1. Install on Android TV device or emulator
2. Launch "BrightSprouts TV" from Leanback launcher
3. Use D-pad to navigate
4. Test TV-specific interactions

## 🏗️ Project Structure

```
brightsprouts/
├── app/                    # Mobile app (Material 3 + Compose)
├── tv/                     # Android TV app (Compose for TV)
├── core/                   # Domain models, use cases, repositories
├── data/                   # Room DB, DataStore, content loading
├── design/                 # Theme, components, screens
├── feature-math/           # Math lessons and UI
├── feature-english/        # English lessons and UI
├── feature-animals/        # Animal lessons and UI
├── feature-kg/             # Kindergarten topics and UI
├── testing/                # Test utilities and fixtures
└── content/                # JSON content and assets
```

## 🎯 Key Features Implemented

### ✅ Completed
- **Project Structure**: Monorepo with all required modules
- **Architecture**: Clean Architecture + MVVM + Hilt DI
- **UI Framework**: Jetpack Compose + Material 3
- **TV Support**: Compose for TV with focus handling
- **Data Layer**: Room database + DataStore preferences
- **Content System**: JSON-based lesson definitions
- **Design System**: Kid-friendly colors, typography, spacing
- **Navigation**: Multi-module navigation setup
- **Testing**: Unit tests and test utilities
- **Build System**: Gradle with product flavors

### 🚧 Partially Implemented
- **Lesson Engine**: Basic card types (prompt, choice)
- **TV Focus**: Basic focus handling
- **Rewards System**: Data models and basic UI
- **Parental Gate**: Math-based verification component

### 📋 Next Steps
1. **Complete Lesson Engine**: Add drag, trace, and other card types
2. **Enhance TV Focus**: Implement advanced focus management
3. **Build Rewards System**: Sticker book and progress tracking
4. **Add TTS Support**: Text-to-speech for lesson prompts
5. **Create More Content**: Additional lessons for each domain
6. **Implement Settings**: Parental controls and preferences
7. **Add Analytics**: Usage tracking (COPPA compliant)
8. **Performance Optimization**: Image loading, memory management

## 🧪 Testing

```bash
# Run all tests
./gradlew test

# Run specific module tests
./gradlew :core:test
./gradlew :data:test

# Run UI tests
./gradlew connectedAndroidTest
```

## 📦 Building for Release

```bash
# Generate signed APKs
./gradlew assembleMobileRelease
./gradlew assembleTvRelease

# Generate App Bundles
./gradlew bundleMobileRelease
./gradlew bundleTvRelease
```

## 🎨 Customization

### Adding New Lessons
1. Create lesson JSON in `app/src/main/assets/content/lessons.json`
2. Follow the lesson schema defined in the README
3. Add corresponding assets to the assets folder

### Modifying Design
1. Update colors in `design/src/main/java/com/brightsprouts/design/theme/Color.kt`
2. Modify typography in `design/src/main/java/com/brightsprouts/design/theme/Typography.kt`
3. Adjust spacing in `design/src/main/java/com/brightsprouts/design/dimensions/Dimensions.kt`

### Adding New Features
1. Create new feature module following the existing pattern
2. Add navigation routes in the respective navigation files
3. Update the main app modules to include the new feature

## 🐛 Troubleshooting

### Common Issues

1. **Build Failures**
   - Ensure all dependencies are properly synced
   - Check that all required SDK versions are installed
   - Clean and rebuild: `./gradlew clean build`

2. **TV App Not Showing in Leanback**
   - Verify the manifest has the correct intent filter
   - Check that the TV banner drawable exists
   - Ensure the app is installed on an Android TV device

3. **Content Not Loading**
   - Verify the JSON file exists in assets
   - Check the JSON format matches the schema
   - Ensure the ContentLoader is properly injected

## 📞 Support

For issues or questions:
1. Check the troubleshooting section above
2. Review the README.md for detailed documentation
3. Create an issue in the repository
4. Contact the development team

---

**Happy Learning with BrightSprouts! 🌱**
