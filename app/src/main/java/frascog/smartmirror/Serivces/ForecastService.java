package frascog.smartmirror.Serivces;

import android.app.IntentService;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.Receivers.ForecastReceiver;
import frascog.smartmirror.Weather.Weather;

/**
 * Created by frascog on 4/12/16.
 */
public class ForecastService extends IntentService {

    private final String API = "https://api.forecast.io/forecast/";
    private final String KEY = "bf6243fc7b46c22e5baf4ae4dc0fd109/";
    private double longitude = 42.338608099999995;
    private double latitude = -71.0821618;
    private final long delay = 90000;


    private Weather weather;

    public ForecastService() {
        super(ForecastService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
        this.getWeather();
        this.update();
    }

    private void getWeather() {
        String apiResult = run(API + KEY + longitude + "," + latitude);
        Gson gson = new Gson();
       this.weather = gson.fromJson(apiResult, Weather.class);
    }

    private String run(String query) {
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

    private void update(){
        Intent forecastIntent = new Intent();
        forecastIntent.setAction(ForecastReceiver.ACTION_RESP);
        forecastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        forecastIntent.putExtra("Weather",weather);
        sendBroadcast(forecastIntent);
    }

}

