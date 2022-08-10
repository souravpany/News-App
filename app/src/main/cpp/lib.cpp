#include <jni.h>
#include <string>
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_newsapplication_Keys_apiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "c7397337dfb7474caa976615ac923622";
    return env->NewStringUTF(api_key.c_str());
}