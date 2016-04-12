package frascog.smartmirror;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import frascog.smartmirror.Modules.Clock;
import frascog.smartmirror.Receivers.ForecastReceiver;
import frascog.smartmirror.Receivers.TransitReceiver;
import frascog.smartmirror.Serivces.ForecastService;
import frascog.smartmirror.Serivces.TransitService;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    private ForecastReceiver forecastReceiver;
    private TransitReceiver transitReceiver;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Clock
        Clock clock = new Clock(this);
        //Full Screen
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);

        //Receivers
        //*********
        //Forcast
        IntentFilter forecastFilter = new IntentFilter(ForecastReceiver.ACTION_RESP);
        forecastFilter.addCategory(Intent.CATEGORY_DEFAULT);
        forecastReceiver = new ForecastReceiver(this);
        registerReceiver(forecastReceiver,forecastFilter);
        //Transit
        IntentFilter transitFilter = new IntentFilter(TransitReceiver.ACTION_RESP);
        transitFilter.addCategory(Intent.CATEGORY_DEFAULT);
        transitReceiver = new TransitReceiver(this);
        registerReceiver(transitReceiver, transitFilter);
        //Service
        //*******
        Intent forecastIntent = new Intent(this, ForecastService.class);
        startService(forecastIntent);
        Intent transitIntent = new Intent(this, TransitService.class);
        startService(transitIntent);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(100);
    }


    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void updateTime(){
        //Time
        TextView timeText = (TextView) findViewById(R.id.time);
        Calendar c = Calendar.getInstance();
        int mintue = c.get(Calendar.MINUTE);
        String mintues = mintue + "";
        if(mintue < 10){
            mintues = "0"+mintues;
        }
        int hour = c.get(Calendar.HOUR);
        if(hour == 0){
            hour = 12;
        }
        timeText.setText(hour + ":" + mintues);
        //Date
        Date date = c.getTime();
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        dayOfWeek += " " + month_date.format(c.getTime());
        dayOfWeek += " " + c.get(Calendar.DAY_OF_MONTH);
        TextView dateText = (TextView) findViewById(R.id.date);
        dateText.setText(dayOfWeek);
        startandstopTasks(c);
    }

    private void startandstopTasks(Calendar c) {
        if((c.get(Calendar.AM_PM) == 1) && (c.get(Calendar.HOUR)+1 > 11)) {
            //stopTasks();
        } else if(c.get(Calendar.HOUR)+1 > 6){
            //startTasks();
        }
    }
}
