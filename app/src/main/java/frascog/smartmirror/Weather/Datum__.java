package frascog.smartmirror.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum__ {

    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("sunriseTime")
    @Expose
    private int sunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    private int sunsetTime;
    @SerializedName("moonPhase")
    @Expose
    private double moonPhase;
    @SerializedName("precipIntensity")
    @Expose
    private double precipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    private double precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private int precipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    private double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperatureMin")
    @Expose
    private double temperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    private int temperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    private double temperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    private int temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    private double apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private int apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    private double apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private int apparentTemperatureMaxTime;
    @SerializedName("dewPoint")
    @Expose
    private double dewPoint;
    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("windSpeed")
    @Expose
    private double windSpeed;
    @SerializedName("windBearing")
    @Expose
    private int windBearing;
    @SerializedName("visibility")
    @Expose
    private int visibility;
    @SerializedName("cloudCover")
    @Expose
    private double cloudCover;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("ozone")
    @Expose
    private double ozone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum__() {
    }

    /**
     * 
     * @param sunsetTime
     * @param summary
     * @param temperatureMinTime
     * @param precipIntensityMaxTime
     * @param visibility
     * @param precipIntensity
     * @param precipIntensityMax
     * @param ozone
     * @param time
     * @param apparentTemperatureMaxTime
     * @param icon
     * @param temperatureMaxTime
     * @param pressure
     * @param cloudCover
     * @param apparentTemperatureMinTime
     * @param temperatureMin
     * @param precipType
     * @param dewPoint
     * @param sunriseTime
     * @param windSpeed
     * @param humidity
     * @param moonPhase
     * @param apparentTemperatureMax
     * @param windBearing
     * @param precipProbability
     * @param apparentTemperatureMin
     * @param temperatureMax
     */
    public Datum__(int time, String summary, String icon, int sunriseTime, int sunsetTime, double moonPhase, double precipIntensity, double precipIntensityMax, int precipIntensityMaxTime, double precipProbability, String precipType, double temperatureMin, int temperatureMinTime, double temperatureMax, int temperatureMaxTime, double apparentTemperatureMin, int apparentTemperatureMinTime, double apparentTemperatureMax, int apparentTemperatureMaxTime, double dewPoint, double humidity, double windSpeed, int windBearing, int visibility, double cloudCover, double pressure, double ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensity = precipIntensity;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windBearing = windBearing;
        this.visibility = visibility;
        this.cloudCover = cloudCover;
        this.pressure = pressure;
        this.ozone = ozone;
    }

    /**
     * 
     * @return
     *     The time
     */
    public int getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(int time) {
        this.time = time;
    }

    public Datum__ withTime(int time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Datum__ withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Datum__ withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 
     * @return
     *     The sunriseTime
     */
    public int getSunriseTime() {
        return sunriseTime;
    }

    /**
     * 
     * @param sunriseTime
     *     The sunriseTime
     */
    public void setSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public Datum__ withSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
        return this;
    }

    /**
     * 
     * @return
     *     The sunsetTime
     */
    public int getSunsetTime() {
        return sunsetTime;
    }

    /**
     * 
     * @param sunsetTime
     *     The sunsetTime
     */
    public void setSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public Datum__ withSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
        return this;
    }

    /**
     * 
     * @return
     *     The moonPhase
     */
    public double getMoonPhase() {
        return moonPhase;
    }

    /**
     * 
     * @param moonPhase
     *     The moonPhase
     */
    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Datum__ withMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
        return this;
    }

    /**
     * 
     * @return
     *     The precipIntensity
     */
    public double getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * 
     * @param precipIntensity
     *     The precipIntensity
     */
    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Datum__ withPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
        return this;
    }

    /**
     * 
     * @return
     *     The precipIntensityMax
     */
    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    /**
     * 
     * @param precipIntensityMax
     *     The precipIntensityMax
     */
    public void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public Datum__ withPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
        return this;
    }

    /**
     * 
     * @return
     *     The precipIntensityMaxTime
     */
    public int getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    /**
     * 
     * @param precipIntensityMaxTime
     *     The precipIntensityMaxTime
     */
    public void setPrecipIntensityMaxTime(int precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public Datum__ withPrecipIntensityMaxTime(int precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        return this;
    }

    /**
     * 
     * @return
     *     The precipProbability
     */
    public double getPrecipProbability() {
        return precipProbability;
    }

    /**
     * 
     * @param precipProbability
     *     The precipProbability
     */
    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Datum__ withPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
        return this;
    }

    /**
     * 
     * @return
     *     The precipType
     */
    public String getPrecipType() {
        return precipType;
    }

    /**
     * 
     * @param precipType
     *     The precipType
     */
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Datum__ withPrecipType(String precipType) {
        this.precipType = precipType;
        return this;
    }

    /**
     * 
     * @return
     *     The temperatureMin
     */
    public double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * 
     * @param temperatureMin
     *     The temperatureMin
     */
    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Datum__ withTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
        return this;
    }

    /**
     * 
     * @return
     *     The temperatureMinTime
     */
    public int getTemperatureMinTime() {
        return temperatureMinTime;
    }

    /**
     * 
     * @param temperatureMinTime
     *     The temperatureMinTime
     */
    public void setTemperatureMinTime(int temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public Datum__ withTemperatureMinTime(int temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
        return this;
    }

    /**
     * 
     * @return
     *     The temperatureMax
     */
    public double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * 
     * @param temperatureMax
     *     The temperatureMax
     */
    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Datum__ withTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
        return this;
    }

    /**
     * 
     * @return
     *     The temperatureMaxTime
     */
    public int getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    /**
     * 
     * @param temperatureMaxTime
     *     The temperatureMaxTime
     */
    public void setTemperatureMaxTime(int temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public Datum__ withTemperatureMaxTime(int temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
        return this;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMin
     */
    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    /**
     * 
     * @param apparentTemperatureMin
     *     The apparentTemperatureMin
     */
    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public Datum__ withApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
        return this;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMinTime
     */
    public int getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    /**
     * 
     * @param apparentTemperatureMinTime
     *     The apparentTemperatureMinTime
     */
    public void setApparentTemperatureMinTime(int apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public Datum__ withApparentTemperatureMinTime(int apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        return this;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMax
     */
    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    /**
     * 
     * @param apparentTemperatureMax
     *     The apparentTemperatureMax
     */
    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public Datum__ withApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
        return this;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMaxTime
     */
    public int getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    /**
     * 
     * @param apparentTemperatureMaxTime
     *     The apparentTemperatureMaxTime
     */
    public void setApparentTemperatureMaxTime(int apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public Datum__ withApparentTemperatureMaxTime(int apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
        return this;
    }

    /**
     * 
     * @return
     *     The dewPoint
     */
    public double getDewPoint() {
        return dewPoint;
    }

    /**
     * 
     * @param dewPoint
     *     The dewPoint
     */
    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Datum__ withDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Datum__ withHumidity(double humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * 
     * @return
     *     The windSpeed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed
     *     The windSpeed
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Datum__ withWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    /**
     * 
     * @return
     *     The windBearing
     */
    public int getWindBearing() {
        return windBearing;
    }

    /**
     * 
     * @param windBearing
     *     The windBearing
     */
    public void setWindBearing(int windBearing) {
        this.windBearing = windBearing;
    }

    public Datum__ withWindBearing(int windBearing) {
        this.windBearing = windBearing;
        return this;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Datum__ withVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * 
     * @return
     *     The cloudCover
     */
    public double getCloudCover() {
        return cloudCover;
    }

    /**
     * 
     * @param cloudCover
     *     The cloudCover
     */
    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Datum__ withCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
        return this;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Datum__ withPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     * 
     * @return
     *     The ozone
     */
    public double getOzone() {
        return ozone;
    }

    /**
     * 
     * @param ozone
     *     The ozone
     */
    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public Datum__ withOzone(double ozone) {
        this.ozone = ozone;
        return this;
    }

}
