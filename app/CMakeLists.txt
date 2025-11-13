cmake_minimum_required(VERSION 3.10)
project(edgeviewer_native)

add_library(native-lib SHARED src/main/cpp/native-lib.cpp)

find_library(log-lib log)

target_include_directories(native-lib PRIVATE ../src/main/cpp)
target_link_libraries(native-lib ${log-lib})


set(OpenCV_DIR "C:/Users/sikan/Desktop/Android studio/OpenCV-android-sdk/sdk/native/jni")
find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})
add_library(native-lib SHARED src/main/cpp/native-lib.cpp)
target_link_libraries(native-lib ${OpenCV_LIBS} ${log-lib})
