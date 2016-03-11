package frascog.smartmirror.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("precipIntensity")
    @Expose
    private int precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    private int precipProbability;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param time
     * @param precipProbability
     * @param precipIntensity
     */
    public Datum(int time, int precipIntensity, int precipProbability) {
        this.time = time;
        this.precipIntensity = precipIntensity;
        this.precipProbability = precipProbability;
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

    public Datum withTime(int time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The precipIntensity
     */
    public int getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * 
     * @param precipIntensity
     *     The precipIntensity
     */
    public void setPrecipIntensity(int precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Datum withPrecipIntensity(int precipIntensity) {
        this.precipIntensity = precipIntensity;
        return this;
    }

    /**
     * 
     * @return
     *     The precipProbability
     */
    public int getPrecipProbability() {
        return precipProbability;
    }

    /**
     * 
     * @param precipProbability
     *     The precipProbability
     */
    public void setPrecipProbability(int precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Datum withPrecipProbability(int precipProbability) {
        this.precipProbability = precipProbability;
        return this;
    }

}
