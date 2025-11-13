package com.example.edgeviewer1

import android.content.Context
import android.opengl.EGLConfig
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import javax.microedition.khronos.opengles.GL10

class GLRenderer(private val context: Context): GLSurfaceView.Renderer {
    private var textureId = IntArray(1)
    private var width = 0
    private var height = 0

    override fun onSurfaceCreated(gl: GL10, config: javax.microedition.khronos.egl.EGLConfig) {
        GLES20.glGenTextures(1, textureId, 0)
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId[0])
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR)
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR)
        // setup shaders & program (vertex + fragment)
    }

    fun updateTextureFromByteArray(buf: ByteBuffer, w: Int, h: Int) {
        width = w; height = h
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId[0])
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, w, h, 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, buf)
    }

    override fun onDrawFrame(gl: GL10?) {
        // draw textured quad using program
    }

    override fun onSurfaceChanged(
        gl: GL10?,
        width: Int,
        height: Int
    ) {
        TODO("Not yet implemented")
    }


}
