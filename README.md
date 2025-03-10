# KMP Cat App

[//]: # (Screenshot)
<p align="center">
  <img width="270" src="URL_DE_TU_CAPTURA_ANDROID" alt="Captura Android"/>
  <img width="320" src="URL_DE_TU_CAPTURA_IOS" alt="Captura iOS"/>
</p>

## Contenido

Esta aplicación utiliza dos APIs relacionadas con gatos:

1.  **The Cat API:** Muestra imágenes de gatos. Puedes encontrar la documentación aquí: [The Cat API Documentation](https://developers.thecatapi.com/ "The Cat API Documentation").
2.  **Fact Cat API:** Proporciona datos curiosos sobre gatos.

## Configuración

Para utilizar la API de The Cat API, necesitarás una clave API. Puedes configurarla en las propiedades locales de tu proyecto.

```properties
apiKey="{tu-api-key}"
```

## Configuración del entorno

> **Advertencia**
> Necesitas una Mac con macOS para escribir y ejecutar código específico de iOS en dispositivos simulados o reales.
> Este es un requisito de Apple.

Para trabajar con esta plantilla, necesitas lo siguiente:

* Una máquina con una versión reciente de macOS.
* [Xcode](https://apps.apple.com/us/app/xcode/id497799835)
* [Android Studio](https://developer.android.com/studio)
* El plugin [Kotlin Multiplatform Mobile](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
* El administrador de dependencias [CocoaPods](https://kotlinlang.org/docs/native-cocoapods.html)

### Verifica tu entorno

Antes de comenzar, utiliza la herramienta [KDoctor](https://github.com/Kotlin/kdoctor) para asegurarte de que tu entorno de desarrollo esté configurado correctamente:

1.  Instala KDoctor con [Homebrew](https://brew.sh/):

    ```text
    brew install kdoctor
    ```

2.  Ejecuta KDoctor en tu terminal:

    ```text
    kdoctor
    ```

    Si todo está configurado correctamente, verás una salida válida:

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

    De lo contrario, KDoctor resaltará qué partes de tu configuración aún necesitan ser configuradas y sugerirá una forma de solucionarlas.

## Dependencias

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
