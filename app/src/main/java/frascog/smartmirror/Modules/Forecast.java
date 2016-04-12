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

    private final String API = "https://api.forecast.io/forecast/";
    private final String KEY = "bf6243fc7b46c22e5baf4ae4dc0fd109/";
    private double longitude = 42.338608099999995;
    private double latitude = -71.0821618;
    private long timeDelay = 90000;

    private Context context;
    private MainActivity mainActivity;
    private Weather weather;
    private boolean runnable;

    public Forecast(Context context,MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public void start(){
        this.runnable = true;
        this.getForcast();
    }

    public void stop(){
        this.runnable = false;
        this.mainActivity.clearforcast();
    }

    public void getForcast(){
        new ForecastTask().execute();
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
            if(precipitation < data.getPrecipProbability()){
                precipitation = data.getPrecipProbability();
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

    private class ForecastTask extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            getWeather();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(weather != null){
                Forecast.this.mainActivity.setTemperature(Forecast.this.getTemperature());
                Forecast.this.mainActivity.setIcon(Forecast.this.getIcon());
                Forecast.this.mainActivity.setSummary(Forecast.this.getSummary());
                Forecast.this.mainActivity.setPrecipitation(Forecast.this.getPrecipitation());
                Forecast.this.mainActivity.setBike(Forecast.this.canBike());
                Log.v("Forcast","Updated Forcast");
            } else {

            }
            if(runnable){
                try {
                    Thread.sleep(timeDelay);
                    getForcast();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void getWeather() {
            String apiResult = run(API + KEY + longitude + "," + latitude);
            Gson gson = new Gson();
            Forecast.this.weather = gson.fromJson(apiResult, Weather.class);
        }

        public String run(String query) {
            InputStream is = null;
            StringBuilder results = new StringBuilder();
            try {
                URL url = new URL(query);
                is = url.openStream();  // throws an IOException
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    results.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                } catch (IOException ioe) {
                    // nothing to see here
                }
            }
            return results.toString();
        }

    }
}
