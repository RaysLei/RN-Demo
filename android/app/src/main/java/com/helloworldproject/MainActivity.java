package com.helloworldproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.textView2).post(new Runnable() {
            @Override
            public void run() {
                if (isFinishing()) {
                    return;
                }
                final long l = SystemClock.elapsedRealtime();
                SoLoader.init(getApplicationContext(), /* native exopackage */ false);
                Log.i(MainActivity.class.getSimpleName(), "Runnable: SoLoader.init: " + (SystemClock.elapsedRealtime() - l));
                final ReactInstanceManager reactInstanceManager = ((ReactApplication) getApplication()).getReactNativeHost().getReactInstanceManager();
                Log.i(MainActivity.class.getSimpleName(), "Runnable: getReactInstanceManager: " + (SystemClock.elapsedRealtime() - l));
                // 判定是否已经加载js
                if (!reactInstanceManager.hasStartedCreatingInitialContext()) {
                    // js加载完成的回调
                    reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                        @Override
                        public void onReactContextInitialized(ReactContext context) {
                            Log.i(MainActivity.class.getSimpleName(), "Runnable: onReactContextInitialized: " + (SystemClock.elapsedRealtime() - l));
                            if (isFinishing()) {
                                return;
                            }
                            reactInstanceManager.removeReactInstanceEventListener(this);
                            startActivity(new Intent(MainActivity.this, SplashActivity.class));
                        }
                    });
                    // 加载js，此方法必须在UI线程运行，内部加载js会在其它子线程
                    reactInstanceManager.createReactContextInBackground();
                    Log.i(MainActivity.class.getSimpleName(), "Runnable: createReactContextInBackground: " + (SystemClock.elapsedRealtime() - l));
                }
            }
        });
    }

    public void onStartMain(View view) {
        startActivity(new Intent(this, SplashActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MainActivity.class.getSimpleName(), "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MainActivity.class.getSimpleName(), "onResume()");
    }
}
