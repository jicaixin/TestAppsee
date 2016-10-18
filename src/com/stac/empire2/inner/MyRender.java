package com.stac.empire2.inner;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.appsee.Appsee;

import android.opengl.GLSurfaceView;

public class MyRender implements GLSurfaceView.Renderer{

	public class Triangle { 
	     
	    public Triangle() 
	    { 
	         float triangleCoords[] = {  
	                    -0.5f, -0.25f, 0, 
	                     0.5f, -0.25f, 0, 
	                     0.0f,  0.559016994f, 0 
	                };  
	                   
	                ByteBuffer vbb = ByteBuffer.allocateDirect( 
	                        // (# of coordinate values * 4 bytes per float)  
	                        triangleCoords.length * 4);  
	                vbb.order(ByteOrder.nativeOrder()); 
	                triangleVB = vbb.asFloatBuffer(); 
	                triangleVB.put(triangleCoords); 
	                triangleVB.position(0);
	    } 
	     
	    public void draw(GL10 gl) 
	    { 
	        gl.glColor4f(0.63671875f, 0.76953125f, 0.22265625f, 0.0f);
	        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleVB);
	        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
	    } 
	     
	    private FloatBuffer triangleVB; 
	} 
	
	
	
	private Triangle mTriangle;
	
	@Override
	public void onDrawFrame(GL10 gl) {
		Appsee.onBeginRenderLoop();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); 

        mTriangle.draw(gl); 
                
        Appsee.appendGLFrame();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		Appsee.onGLSurfaceChanged(MainActivity.mGLSurfaceView, width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		 mTriangle = new Triangle(); 
		 
		 gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f); 
	     gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); 
	}

}
