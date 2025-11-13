package com.example.edgeviewer1

object NativeBridge {
    init { System.loadLibrary("native-lib") }
    external fun processFrame(input: ByteArray, width: Int, height: Int): ByteArray
}
