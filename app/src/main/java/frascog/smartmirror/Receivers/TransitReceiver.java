package frascog.smartmirror.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.Modules.Forecast;
import frascog.smartmirror.R;
import frascog.smartmirror.Serivces.ForecastService;
import frascog.smartmirror.Serivces.TransitService;
import frascog.smartmirror.Transit.TransitTime;
import frascog.smartmirror.Weather.Weather;

/**
 * Created by frascog on 4/12/16.
 */
public class TransitReceiver extends BroadcastReceiver {

    public static final String ACTION_RESP = "transit.MESSAGE_PROCESSED";
    private MainActivity mainActivity;
    private TransitTime transitTime;

    public TransitReceiver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.transitTime = (TransitTime) intent.getExtras().getSerializable("TransitTime");
        if(transitTime != null){
            setTransitTimes(this.transitTime);
            Log.v("Transit", "Updated Transit");
            Intent transitIntent = new Intent(mainActivity, TransitService.class);
            mainActivity.startService(transitIntent);
        }
    }

    private void setTransitTimes(TransitTime transitTimes) {
        TextView massAve1 = (TextView) mainActivity.findViewById(R.id.MassAve1);
        if(transitTimes.massAveOutbound.equals("No Train Info")){
            massAve1.setText("Forest Hills\t" + "No Data");
        } else {
            massAve1.setText("Forest Hills\t" + (Integer.parseInt(transitTimes.massAveOutbound) / 60 + 1) + " min");
        }

        TextView massAve2 = (TextView) mainActivity.findViewById(R.id.MassAve2);
        if(transitTimes.massAveInbound.equals("No Train Info")){
            massAve2.setText("Oak Grove\t" + "No Data");
        } else {
            massAve2.setText("Oak Grove\t" + (Integer.parseInt(transitTimes.massAveInbound)/60 + 1) + " min");
        }

        TextView sym1 = (TextView) mainActivity.findViewById(R.id.Sym1);
        if(transitTimes.symphonyOutbound.equals("No Train Info")){
            sym1.setText("Heath Street\t" + "No Data");
        } else {
            sym1.setText("Heath Street\t" + (Integer.parseInt(transitTimes.symphonyOutbound)/60 + 1) + " min");
        }

        TextView sym2 = (TextView) mainActivity.findViewById(R.id.Sym2);
        if(transitTimes.symphonyOutbound.equals("No Train Info")){
            sym2.setText("Lechmere\t" + "No Data");
        } else {
            sym2.setText("Lechmere\t" + (Integer.parseInt(transitTimes.symphonyInbound)/60  + 1) + " min");
        }

        ImageView img1 = (ImageView) mainActivity.findViewById(R.id.MassAve);
        img1.setVisibility(View.VISIBLE);
        ImageView img2 = (ImageView) mainActivity.findViewById(R.id.tram);
        img2.setVisibility(View.VISIBLE);
    }

    private void clearTransitTimes(){
        TextView massAve1 = (TextView) mainActivity.findViewById(R.id.MassAve1);
        massAve1.setText("");
        TextView massAve2 = (TextView) mainActivity.findViewById(R.id.MassAve2);
        massAve2.setText("");
        TextView sym1 = (TextView) mainActivity.findViewById(R.id.Sym1);
        sym1.setText("");
        TextView sym2 = (TextView) mainActivity.findViewById(R.id.Sym2);
        sym2.setText("");
        ImageView img1 = (ImageView) mainActivity.findViewById(R.id.MassAve);
        img1.setVisibility(View.GONE);
        ImageView img2 = (ImageView) mainActivity.findViewById(R.id.tram);
        img2.setVisibility(View.GONE);
    }
}
