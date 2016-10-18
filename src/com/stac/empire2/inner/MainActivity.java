package com.stac.empire2.inner;

import com.appsee.Appsee;
import com.appsee.AppseeGLSurfaceViewRenderer;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	protected static FrameLayout mFrameLayout;
	public static MyGLSurfaceView mGLSurfaceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


//		setContentView(R.layout.activity_main);

		
		ViewGroup.LayoutParams framelayout_params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		mFrameLayout = new FrameLayout(this);
		mFrameLayout.setLayoutParams(framelayout_params);
		
		this.mGLSurfaceView = new MyGLSurfaceView(this);
		
		mFrameLayout.addView(this.mGLSurfaceView);
		
		AppseeGLSurfaceViewRenderer render = new AppseeGLSurfaceViewRenderer(mGLSurfaceView, new MyRender());
		
		mGLSurfaceView.setRenderer(render);
		
//		mGLSurfaceView.setRenderer(new MyRender());
		setContentView(mFrameLayout);
		

		Appsee.setDebugToLogcat(true);
		Appsee.start("4b627e62d7574b22ad3a2d82ba9e0b03");
	}
}
