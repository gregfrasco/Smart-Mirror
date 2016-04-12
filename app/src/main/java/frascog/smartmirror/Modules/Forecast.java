package frascog.smartmirror.Modules;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.R;
import frascog.smartmirror.Weather.Datum_;
import frascog.smartmirror.Weather.Datum__;
import frascog.smartmirror.Weather.Weather;

/**
 * Created by frascog on 3/11/16.
 */
public class Forecast {

    private Weather weather;
    private Context context;

    public Forecast(Weather weather,Context context) {
        this.weather = weather;
        this.context = context;
    }

    public String getTemperature() {
        return ((int)weather.getCurrently().getTemperature()) + "°";
    }

    public Drawable getIcon() {
        Drawable drawable = null;
        switch (weather.getCurrently().getIcon()){
            case "clear-day" :
                drawable = this.context.getResources().getDrawable(R.drawable.weatherclear);
                break;
            case "clear-night":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherclearnight);
                break;
            case "rain":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherdrizzleday);
                break;
            case "snow":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherbigsnow);
                break;
            case "sleet":
                drawable = this.context.getResources().getDrawable(R.drawable.weathersnowrain);
                break;
            case "wind":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherwind);
                break;
            case "fog":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherhaze);
                break;
            case "cloudy":
                drawable = this.context.getResources().getDrawable(R.drawable.weathercloudsnight);
                break;
            case "partly-cloudy-day":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherfewclouds);
                break;
            case "partly-cloudy-night":
                drawable = this.context.getResources().getDrawable(R.drawable.weatherfewcloudsnight);
                break;
        }
        return new BitmapDrawable(this.context.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), 200, 200, true));
    }

    public String getSummary() {
        return "Currently " + this.weather.getCurrently().getSummary() + "\n" + this.weather.getDaily().getSummary();
    }

    public String getPrecipitation() {
        double precipitation = 0;
        for(Datum__ data: this.weather.getDaily().getData()){
            int newValue = (int) (data.getPrecipProbability() * 100);
            if(precipitation < newValue){
                precipitation = newValue;
            }
        }
        return new Double(precipitation).intValue() + "%";
    }

    public boolean canBike(){
        boolean bike = true;
        for(Datum_ hour :this.weather.getHourly().getData()){
            if(hour.getPrecipProbability() >= 0.3 || hour.getTemperature() <= 50){
                bike = false;
                break;
            }
        }
        return bike;
    }
}
