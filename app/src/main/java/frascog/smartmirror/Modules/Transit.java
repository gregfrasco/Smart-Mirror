package frascog.smartmirror.Modules;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

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
    private final String apiKey = "?api_key=RpDBj89zSU6aOljozJLfpg";
    private final String format = "&format=json";

    private TransitTime transitTimes = new TransitTime();

    public Transit(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public void getTransit() {
        new TransitTask().execute();
    }

    private class TransitTask extends AsyncTask<String, Integer, Boolean> {

        private final ProgressDialog dialog = new ProgressDialog(Transit.this.context);

        private String symphonyOutbound = "70241";
        private String symphonyInbound  = "70242";
        private String massAveOutbound  = "70012";
        private String massAveInbound   = "70013";

        public TransitTask() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Getting Transit Data...");
            this.dialog.setIndeterminate(true);
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                Thread.sleep(0);
                getTransit();
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
            if(transitTimes != null){
                Transit.this.mainActivity.setTransitTimes(Transit.this.transitTimes);
            } else {

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
                return predictionsByStop.getMode().get(0).getRoute().get(0).getDirection().get(0).getTrip().get(0).getPreAway();
            } catch (IndexOutOfBoundsException e){
                return "0";
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
