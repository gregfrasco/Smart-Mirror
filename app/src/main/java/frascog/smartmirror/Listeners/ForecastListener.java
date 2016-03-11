package frascog.smartmirror.Listeners;

/**
 * Created by frascog on 3/11/16.
 */
public interface ForecastListener {
    public void onWeatherToday(String weatherToday);
    public void onShouldBike(boolean showToday, boolean shouldBike);
}
