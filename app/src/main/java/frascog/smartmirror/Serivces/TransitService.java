package frascog.smartmirror.Serivces;

import android.app.IntentService;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import frascog.smartmirror.R;
import frascog.smartmirror.Receivers.TransitReceiver;
import frascog.smartmirror.Transit.PredictionsByStop;
import frascog.smartmirror.Transit.TransitTime;

/**
 * Created by frascog on 4/12/16.
 */
public class TransitService extends IntentService {

    private final String mbtaAPI = "http://realtime.mbta.com/developer/api/v2/";
    private final String apiKey = "?api_key=lxzqGfe9OUWHBR9elGklBg";
    private final String format = "&format=json";
    private final long delay = 40000;

    private String symphonyOutbound = "70241";
    private String symphonyInbound  = "70242";
    private String massAveOutbound  = "70012";
    private String massAveInbound   = "70013";

    private TransitTime transitTime;

    public TransitService() {
        super(TransitService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
        this.getTransit();
        this.update();
    }

    public void getTransit() {
        this.transitTime = new TransitTime();
        this.transitTime.symphonyOutbound = getPredictionsByStop(this.symphonyOutbound);
        this.transitTime.symphonyInbound = getPredictionsByStop(this.symphonyInbound);
        this.transitTime.massAveInbound = getPredictionsByStop(this.massAveInbound);
        this.transitTime.massAveOutbound = getPredictionsByStop(this.massAveOutbound);
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

    private void update(){
        Intent forecastIntent = new Intent();
        forecastIntent.setAction(TransitReceiver.ACTION_RESP);
        forecastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        forecastIntent.putExtra("TransitTime", this.transitTime);
        sendBroadcast(forecastIntent);
    }
}
