# EdgeViewer

EdgeViewer is a cross-platform project demonstrating **real-time image processing** using the Android camera, C++ (via JNI + OpenCV), and OpenGL ES for rendering.  
It also includes a lightweight **TypeScript web viewer** for displaying processed frames with resolution and FPS overlays.

---

## 🧩 Features Implemented

### 📱 Android App
- Real-time **camera capture** using `TextureView` / `GLSurfaceView`
- **JNI bridge** between Kotlin and native C++ layer
- **OpenCV-based edge detection** (Canny) inside native code
- **OpenGL ES 2.0 renderer** to draw processed frames as textures
- Toggle between **raw camera view** and **edge-detected view**
- **FPS counter** and frame resolution overlay for performance tracking

### 💻 Web Viewer
- Built with **TypeScript + HTML**
- Displays a **sample processed frame** (from Android app)
- Overlays resolution and simulated FPS
- Simple, dependency-light viewer to show processed output for documentation/demo


## ⚙️ Setup Instructions (NDK + OpenCV Dependencies)

### 1️⃣ Prerequisites
- **Android Studio** (latest stable)
- **Android NDK** (e.g., `25.1.8937393`)
- **CMake** (installed via SDK Manager)
- **OpenCV Android SDK** (download from [OpenCV.org](https://opencv.org/releases/))
- **Node.js + npm** (for building the web viewer)

---

### 2️⃣ Android Build Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/<your-username>/EdgeViewer.git
   cd EdgeViewer/app

🧠 Quick Architecture Explanation
📸 Frame Flow (Android)

Camera Capture (Kotlin)

The Android app captures frames from the device camera using a TextureView or ImageReader.

Each frame is converted into a ByteArray (RGBA format).

JNI Bridge (Kotlin ↔️ C++)

Kotlin calls the native function processFrame(byte[] input, int width, int height) implemented in C++.

This is done via the JNI layer defined in NativeBridge.kt.

Native Processing (C++ + OpenCV)

The JNI method receives frame bytes.

The bytes are wrapped in a cv::Mat object.

OpenCV applies grayscale conversion and Canny edge detection.

The processed frame is returned as a new byte array (RGBA).

Rendering (OpenGL ES)

The processed RGBA data is uploaded to an OpenGL texture.

The texture is drawn on a full-screen quad using vertex + fragment shaders.

UI overlays (FPS, toggle button) are drawn on top.

🌐 TypeScript Part (Web Viewer)

The web component (/web) is a lightweight viewer that loads a base64-encoded processed frame (exported from the Android app).

It displays:

Image resolution (from metadata)

FPS (either hardcoded or dynamically updated)

Built using:

TypeScript for DOM logic

lite-server for local hosting
