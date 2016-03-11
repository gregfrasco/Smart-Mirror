package frascog.smartmirror.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import frascog.smartmirror.Weather.*;

public class Weather {

    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("currently")
    @Expose
    private Currently currently;
    @SerializedName("minutely")
    @Expose
    private Minutely minutely;
    @SerializedName("hourly")
    @Expose
    private Hourly hourly;
    @SerializedName("daily")
    @Expose
    private Daily daily;
    @SerializedName("flags")
    @Expose
    private Flags flags;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param timezone
     * @param flags
     * @param currently
     * @param longitude
     * @param latitude
     * @param hourly
     * @param offset
     * @param daily
     * @param minutely
     */
    public Weather(double latitude, double longitude, String timezone, int offset, Currently currently, Minutely minutely, Hourly hourly, Daily daily, Flags flags) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.offset = offset;
        this.currently = currently;
        this.minutely = minutely;
        this.hourly = hourly;
        this.daily = daily;
        this.flags = flags;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Weather withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Weather withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Weather withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Weather withOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * 
     * @return
     *     The currently
     */
    public Currently getCurrently() {
        return currently;
    }

    /**
     * 
     * @param currently
     *     The currently
     */
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Weather withCurrently(Currently currently) {
        this.currently = currently;
        return this;
    }

    /**
     * 
     * @return
     *     The minutely
     */
    public Minutely getMinutely() {
        return minutely;
    }

    /**
     * 
     * @param minutely
     *     The minutely
     */
    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public Weather withMinutely(Minutely minutely) {
        this.minutely = minutely;
        return this;
    }

    /**
     * 
     * @return
     *     The hourly
     */
    public Hourly getHourly() {
        return hourly;
    }

    /**
     * 
     * @param hourly
     *     The hourly
     */
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Weather withHourly(Hourly hourly) {
        this.hourly = hourly;
        return this;
    }

    /**
     * 
     * @return
     *     The daily
     */
    public Daily getDaily() {
        return daily;
    }

    /**
     * 
     * @param daily
     *     The daily
     */
    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Weather withDaily(Daily daily) {
        this.daily = daily;
        return this;
    }

    /**
     * 
     * @return
     *     The flags
     */
    public Flags getFlags() {
        return flags;
    }

    /**
     * 
     * @param flags
     *     The flags
     */
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Weather withFlags(Flags flags) {
        this.flags = flags;
        return this;
    }

}
