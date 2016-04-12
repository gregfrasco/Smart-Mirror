package frascog.smartmirror.Modules;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.Transit.Direction;
import frascog.smartmirror.Transit.Mode;
import frascog.smartmirror.Transit.PredictionsByStop;
import frascog.smartmirror.Transit.Route;
import frascog.smartmirror.Transit.TransitTime;
import frascog.smartmirror.Transit.Trip;

/**
 * Created by frascog on 3/11/16.
 */
public class Transit {

    private Context context;
    private MainActivity mainActivity;

    private final String mbtaAPI = "http://realtime.mbta.com/developer/api/v2/";
    private final String apiKey = "?api_key=lxzqGfe9OUWHBR9elGklBg";
    private final String format = "&format=json";
    private boolean runnable = false;
    private long timeDelay = 9000;

    private TransitTime transitTimes = new TransitTime();

    public Transit(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public void getTransit() {
        new TransitTask().execute();
    }

    public void start(){
        this.runnable = true;
        this.getTransit();
    }

    public void stop(){
        this.runnable = false;
        this.mainActivity.clearTransitTimes();
    }

    private class TransitTask extends AsyncTask<String, Integer, Boolean> {

        private String symphonyOutbound = "70241";
        private String symphonyInbound  = "70242";
        private String massAveOutbound  = "70012";
        private String massAveInbound   = "70013";

        public TransitTask() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {;
            getTransit();
            Log.v("Transit","Get Transit");
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(transitTimes != null){
                Transit.this.mainActivity.setTransitTimes(Transit.this.transitTimes);
            } else {

            }
            if(runnable){
                try {
                    Thread.sleep(timeDelay);
                    getTransit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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

        public String getPredictionsByStop(String stationID){
            try {
                String apiResult = run(mbtaAPI + "predictionsbystop" + apiKey + "&stop=" + stationID + format);
                Gson gson = new Gson();
                PredictionsByStop predictionsByStop = gson.fromJson(apiResult, PredictionsByStop.class);
                if(predictionsByStop != null) {
                    String seconds = predictionsByStop.getMode().get(0).getRoute().get(0).getDirection().get(0).getTrip().get(0).getPreAway();
                    if (Integer.parseInt(seconds) < 120) {
                        if (predictionsByStop.getMode().get(0).getRoute().get(0).getDirection().get(0).getTrip().size() > 2) {
                            seconds = predictionsByStop.getMode().get(0).getRoute().get(0).getDirection().get(0).getTrip().get(1).getPreAway();
                        }
                    }
                    return seconds;
                }
                return "No Train Info";
            } catch (IndexOutOfBoundsException e){
                return "No Train Info";
            }
        }

        public void getTransit() {
            Transit.this.transitTimes.symphonyOutbound = getPredictionsByStop(this.symphonyOutbound);
            Transit.this.transitTimes.symphonyInbound = getPredictionsByStop(this.symphonyInbound);
            Transit.this.transitTimes.massAveInbound = getPredictionsByStop(this.massAveInbound);
            Transit.this.transitTimes.massAveOutbound = getPredictionsByStop(this.massAveOutbound);
        }
    }
}
