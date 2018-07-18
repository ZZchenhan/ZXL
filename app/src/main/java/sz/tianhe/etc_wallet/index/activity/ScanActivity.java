package sz.tianhe.etc_wallet.index.activity;


import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.decode.CaptureActivityHandler;
import sz.tianhe.etc_wallet.decode.PreferencesActivity;
import sz.tianhe.etc_wallet.decode.ViewfinderView;
import sz.tianhe.etc_wallet.decode.camera.CameraManager;

public class ScanActivity extends BaseActivity implements SurfaceHolder.Callback {
    AdapterNavagation adapterNavagation;
    private SurfaceView surfaceView;

    private CameraManager cameraManager;

    private CaptureActivityHandler handler;

    private ViewfinderView viewfinderView;

    private Collection<BarcodeFormat> decodeFormats;

    private Map<DecodeHintType,?> decodeHints;

    private String characterSet;
    public CameraManager getCameraManager(){
        return cameraManager;
    }

    public Handler getHandler(){
        return handler;
    }

    public void handleDecode(Result obj, Bitmap barcode, float scaleFactor){
        Log.e("Load",obj.getText());
    }


    public void drawViewfinder(){
        viewfinderView.drawViewfinder();
    }

    @Override
    public int layoutId() {
        return R.layout.activity_scan;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle("收款码", 16, R.color.white);
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        decodeFormats = new ArrayList<>();
        decodeHints = new HashMap<>();
        decodeFormats.add(BarcodeFormat.QR_CODE);
        findviews();
    }

    @Override
    protected View bindViews() {
        return null;
    }

    private void findviews() {
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
    }


    boolean hasSurface = false;
    @Override
    protected void onResume() {
        super.onResume();
        cameraManager = new CameraManager(getApplicationContext());
        viewfinderView.setCameraManager(cameraManager);
        handler = null;


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if (prefs.getBoolean(PreferencesActivity.KEY_DISABLE_AUTO_ORIENTATION, true)) {
            setRequestedOrientation(getCurrentOrientation());
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        SurfaceHolder surfaceHolder = surfaceView.getHolder();


        if (hasSurface) {
            // The activity was paused but not stopped, so the surface still exists. Therefore
            // surfaceCreated() won't be called, so init the camera here.
            initCamera(surfaceHolder);
        } else {
            // Install the callback and wait for surfaceCreated() to init the camera.
            surfaceHolder.addCallback(this);
        }
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (cameraManager.isOpen()) {
                      return;
        }
        try {
            cameraManager.openDriver(surfaceHolder);
            // Creating the handler starts the preview, which can also throw a RuntimeException.
            if (handler == null) {
                handler = new CaptureActivityHandler(this, decodeFormats, decodeHints, characterSet, cameraManager);
            }

        } catch (IOException ioe) {

        } catch (RuntimeException e) {
        }
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {

        }
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;
    }

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    private int getCurrentOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            switch (rotation) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_90:
                    return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                default:
                    return ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            }
        } else {
            switch (rotation) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_270:
                    return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                default:
                    return ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            }
        }
    }
}
