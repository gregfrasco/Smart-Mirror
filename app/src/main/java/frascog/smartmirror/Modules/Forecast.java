package frascog.smartmirror.Modules;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.Weather.Weather;

/**
 * Created by frascog on 3/11/16.
 */
public class Forecast {

    private final String API = "https://api.forecast.io/forecast/";
    private final String KEY = "bf6243fc7b46c22e5baf4ae4dc0fd109/";
    private double longitude = 37.8267;
    private double latitude = -122.423;

    private MainActivity activity;
    private Weather weather;

    public void getForcast(){
        new ForecastTask().execute();

    }

    private class ForecastTask extends AsyncTask<String, Integer, Boolean> {

        private final ProgressDialog dialog = new ProgressDialog(Forecast.this.activity);

        public ForecastTask() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Getting Weather...");
            this.dialog.setIndeterminate(true);
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                Thread.sleep(0);
                getWeather();
            } catch (InterruptedException e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            //Close the loading dialog
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if(weather != null){

            } else {

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
