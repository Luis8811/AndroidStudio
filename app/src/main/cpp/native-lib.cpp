#include <jni.h>
#include <string>

extern "C"
jstring Java_es_ual_master_Histograma_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

/* Paso 3: Implementa la nueva función C++ histogramaC
 * Debe implementar en C++ el cálculo del histograma
 * Debe recibir los arrays imagen y h y
 * debe devolver el tiempo requerido para el cómputo */



/* Paso 4: Implementa una versión paralela de histogramaC
 * Aunque puedes hacerlo con OpenMP te recomendamos que uses
 * threads de C++ y privatices h o implementes h como un
 * array de atómicos*/

