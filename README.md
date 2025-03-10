# KMP Cat App

[//]: # (Screenshot)
<p align="center">
  <img width="270" src="URL_DE_TU_CAPTURA_ANDROID" alt="Android Screenshot"/>
  <img width="320" src="URL_DE_TU_CAPTURA_IOS" alt="iOS Screenshot"/>
</p>

## Content

This application utilizes two cat-related APIs:

1.  **The Cat API:** Displays cat images. You can find the documentation here: [The Cat API Documentation](https://developers.thecatapi.com/ "The Cat API Documentation").
2.  **Fact Cat API:** Provides interesting facts about cats.

## Configuration

To use The Cat API, you'll need an API key. You can configure this in your project's local properties.

```properties
apiKey="{your-api-key}"
```

## Environment Setup

> **Warning**
> You need a Mac with macOS to write and run iOS-specific code on simulated or real devices.
> This is an Apple requirement.

To work with this template, you'll need the following:

* A machine running a recent version of macOS.
* [Xcode](https://apps.apple.com/us/app/xcode/id497799835)
* [Android Studio](https://developer.android.com/studio)
* The [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
* The [CocoaPods dependency manager](https://kotlinlang.org/docs/native-cocoapods.html)

### Check your environment

Before you start, use the [KDoctor](https://github.com/Kotlin/kdoctor) tool to ensure your development environment is correctly configured:

1.  Install KDoctor with [Homebrew](https://brew.sh/):

    ```text
    brew install kdoctor
    ```

2.  Run KDoctor in your terminal:

    ```text
    kdoctor
    ```

    If everything is set up correctly, you'll see valid output:

    ```text
    Environment diagnose (to see all details, use -v option):
    [✓] Operation System
    [✓] Java
    [✓] Android Studio
    [✓] Xcode
    [✓] Cocoapods

    Conclusion:
        ✓ Your system is ready for Kotlin Multiplatform Mobile development!
    ```

    Otherwise, KDoctor will highlight which parts of your setup still need to be configured and suggest a way to fix them.

## Dependencies

```toml
[versions]
agp = "8.8.2"
android-compileSdk = "35"
android-minSdk = "24"
android-targetSdk = "35"
androidx-activityCompose = "1.9.3"
androidx-appcompat = "1.7.0"
androidx-constraintlayout = "2.2.0"
androidx-core-ktx = "1.15.0"
androidx-espresso-core = "3.6.1"
androidx-lifecycle = "2.8.4"
androidx-material = "1.12.0"
androidx-test-junit = "1.2.1"
compose-multiplatform = "1.7.0"
junit = "5.10.2"
kotlin = "2.1.10"
ktor = "3.1.1"
coroutines = "1.10.1"
coil = "3.1.0"
mockative = "3.0.1"
slf4j = "2.0.9"
material3Android = "1.3.1"
```
