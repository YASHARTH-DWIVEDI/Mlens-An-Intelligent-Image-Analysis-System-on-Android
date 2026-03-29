# MLens: An Intelligent Image Analysis System on Android

[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple.svg)](https://kotlinlang.org)

**MLens** is a high-performance, modular computer vision framework designed for real-time video analytics and intelligent scene perception. Engineered with a focus on **Edge AI**, MLens moves beyond simple object detection to provide deep contextual and spatial understanding of environments, making it ideal for high-stakes industries like professional sports analytics (F1, Soccer), autonomous monitoring, and strategic event tracking.

---

## 🚀 Key Features

### 1. High-Speed Object Detection (YOLO)
Utilizes a **YOLO-based pipeline** optimized for mobile edge devices. MLens achieves high-frequency frame processing, enabling sub-millisecond response times for object localization and tracking.

### 2. Spatial Relationship Analyzer
Unlike standard detection systems, MLens features a proprietary **Spatial Intelligence Layer**. It interprets the proximity, orientation, and interaction between entities (e.g., "Player A is *intercepting* the ball" or "Vehicle X is *entering* a restricted zone").

### 3. Advanced Scene & Text Perception
- **Enhanced Scene Descriptor**: Generates natural language summaries of visual environments using multimodal AI models.
- **Precision Text Recognition**: Real-time OCR capability for reading environmental signifiers, scoreboard data, or license plates.

### 4. Privacy-First Edge Processing
All ML inference and data processing occur **on-device**. This ensures:
- **Zero Latency**: No round-trips to the cloud.
- **GDPR Compliance**: Sensitive visual data never leaves the device.
- **Offline Reliability**: Critical functionality maintained in remote or high-interference locations.

### 5. Persistent Metadata Engine
Powered by **Room Persistence**, MLens archives every detection event into a searchable, relational metadata structure. This allows for complex retrospective analysis and temporal trend filtering.

---

## 🛠 Tech Stack

- **Lanuage**: Kotlin (1.9+)
- **UI Framework**: Jetpack Compose (Modern, Reactive MVI Architecture)
- **Asynchronous Flow**: Kotlin Coroutines & Flow API
- **ML Engines**: 
    - TensorFlow Lite (Scene Analysis)
    - YOLO / ONNX Runtime (Object Detection)
- **Database**: Room (SQLite) for high-performance metadata indexing
- **Dependency Injection**: Manual / Hilt-ready architecture

---

## 📂 Project Structure

```text
app/src/main/java/com/mlens/app/
├── data/
│   ├── database/     # Room entities, DAOs, and Migration logic
│   └── repository/   # Unified data access and ML result caching
├── ml/
│   ├── core/         # YOLO and TFLite implementation details
│   ├── processors/   # Specialized analytics: Spatial, Scene, Text
│   └── MLProcessor   # Centralized inference orchestrator
└── ui/
    ├── screens/      # Jetpack Compose Screens (ImageDisplay, Search, Upload)
    └── viewmodels/   # State management and ML task orchestration
```

---

## ⚙️ Getting Started

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or newer.
- Android device with API level 24 (Nougat) or higher (Physical device recommended for camera performance).

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/mlens.git
   ```
2. Place your YOLO model (e.g., `yolo11m_float16.tflite`) in `app/src/main/assets/`.
3. Sync Gradle and build the project.
4. Run the app on your device.

---

## 🎯 Industrial Alignment

MLens is specifically architected to support the mission-critical needs of:
- **Professional Sports**: Real-time tactical analysis for coaches and broadcasters.
- **Critical Infrastructure**: Automated monitoring of restricted areas with spatial context.
- **Smart Marketing**: GDPR-compliant audience analysis and engagement tracking.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
