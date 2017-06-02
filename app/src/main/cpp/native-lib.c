#include <jni.h>
#include <stdlib.h>
int getPressure(){
    return rand()%101;
}
int flag = 1;
/*
 * Class:     com_huangjie_demo10pressure2_MainActivity
 * Method:    startMonitor
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_huangjie_demo10pressure2_MainActivity_startMonitor
        (JNIEnv *env, jobject obj) {
    //①获取字节码
    jclass clazz = (*env)->FindClass(env, "com/huangjie/demo10pressure2/MainActivity");
    //②找到方法
    jmethodID methodID  = (*env)->GetMethodID(env,clazz,"setPressure","(I)V");
    //③调用方法
    flag = 1;
    while (flag){
        sleep(1);
        (*env)->CallVoidMethod(env,obj,methodID,getPressure());
    }
}
/*
 * Class:     com_huangjie_demo10pressure2_MainActivity
 * Method:    stopMonitor
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_huangjie_demo10pressure2_MainActivity_stopMonitor
        (JNIEnv *env, jobject obj){
    flag=0;
}
