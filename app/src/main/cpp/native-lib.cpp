#include <jni.h>
#include <android/log.h>

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yourpackage_NativeBridge_processFrame(JNIEnv *env, jobject thiz, jbyteArray in, jint w, jint h) {
    // stub: just return the input for now
    return in;
}
