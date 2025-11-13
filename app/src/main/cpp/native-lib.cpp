
#include <jni.h>
#include <opencv2/opencv.hpp>
#include <android/log.h>

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,"native-lib",__VA_ARGS__)

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_example_edgeviewer1_NativeBridge_processFrame(JNIEnv *env, jobject thiz, jbyteArray in, jint width, jint height) {
    jbyte *inBytes = env->GetByteArrayElements(in, NULL);
    // Assume input is RGBA (4 bytes per pixel). If you pass a different format adapt accordingly.
    cv::Mat src(height, width, CV_8UC4, (unsigned char*)inBytes);
    cv::Mat gray, edges, rgba;
    cv::cvtColor(src, gray, cv::COLOR_RGBA2GRAY);
    cv::Canny(gray, edges, 50, 150);
    cv::cvtColor(edges, rgba, cv::COLOR_GRAY2RGBA);

    int size = width * height * 4;
    jbyteArray out = env->NewByteArray(size);
    env->SetByteArrayRegion(out, 0, size, reinterpret_cast<const jbyte*>(rgba.data));
    env->ReleaseByteArrayElements(in, inBytes, JNI_ABORT);
    return out;
}
