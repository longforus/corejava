/*
   @version 1.10 1997-07-01
   @author Cay Horstmann
*/

#include "HelloNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_v2ch12_helloNative_HelloNative_greeting(JNIEnv* env, jclass cl)
{  
   printf("Hello Native World!\n");
}
