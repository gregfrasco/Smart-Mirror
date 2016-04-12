package frascog.smartmirror.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import frascog.smartmirror.MainActivity;
import frascog.smartmirror.Modules.Forecast;
import frascog.smartmirror.R;
import frascog.smartmirror.Serivces.ForecastService;
import frascog.smartmirror.Weather.Weather;

/**
 * Created by frascog on 4/12/16.
 */
public class ForecastReceiver extends BroadcastReceiver {

    public static final String ACTION_RESP = "forecast.MESSAGE_PROCESSED";
    private MainActivity mainActivity;
    private Weather weather;

    public ForecastReceiver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.weather = (Weather) intent.getExtras().getSerializable("Weather");
        Forecast forecast = new Forecast(weather,context);
        if(weather != null){
            setTemperature(forecast.getTemperature());
            setIcon(forecast.getIcon());
            setSummary(forecast.getSummary());
            setPrecipitation(forecast.getPrecipitation());
            setBike(forecast.canBike());
            Log.v("Forcast", "Updated Forcast");
            Intent forecastIntent = new Intent(mainActivity, ForecastService.class);
            mainActivity.startService(forecastIntent);
        }
    }

    public void setTemperature(String degrees) {
        TextView temperature = (TextView) mainActivity.findViewById(R.id.temperature);
        temperature.setText(degrees);
    }

    public void setIcon(Drawable icon) {
        ImageView imageView = (ImageView) mainActivity.findViewById(R.id.weatherIcon);
        imageView.setImageDrawable(icon);
        imageView.setVisibility(View.VISIBLE);
    }

    public void setSummary(String summarytext) {
        TextView summary = (TextView) mainActivity.findViewById(R.id.weatherSummary);
        summary.setText(summarytext);
    }

    public void setPrecipitation(String precipitation) {
        TextView rain = (TextView) mainActivity.findViewById(R.id.precipitation);
        rain.setText(precipitation);
        ImageView umbrella = (ImageView) mainActivity.findViewById(R.id.umbrella);
        umbrella.setVisibility(View.VISIBLE);
    }

    public void setBike(boolean shouldBike) {
        TextView bike = (TextView) mainActivity.findViewById(R.id.bike);
        if(shouldBike){
            bike.setText("Looks Nice Out Today");
        } else {
            bike.setText("Try Taking the T");
        }
        ImageView umbrella = (ImageView) mainActivity.findViewById(R.id.bikeIcon);
        umbrella.setVisibility(View.VISIBLE);
    }

    public void clearforcast() {
        setTemperature("");
        setPrecipitation("");
        setSummary("");
        TextView bike = (TextView) mainActivity.findViewById(R.id.bike);
        bike.setText("");
        ImageView weather = (ImageView) mainActivity.findViewById(R.id.weatherIcon);
        weather.setVisibility(View.GONE);
        ImageView umbrella = (ImageView) mainActivity.findViewById(R.id.umbrella);
        umbrella.setVisibility(View.GONE);
        ImageView bikeIcon = (ImageView) mainActivity.findViewById(R.id.bikeIcon);
        bikeIcon.setVisibility(View.GONE);
    }
}
