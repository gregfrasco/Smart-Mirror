
package frascog.smartmirror.Transit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trip {

    @SerializedName("trip_id")
    @Expose
    private String tripId;
    @SerializedName("trip_name")
    @Expose
    private String tripName;
    @SerializedName("trip_headsign")
    @Expose
    private String tripHeadsign;
    @SerializedName("pre_dt")
    @Expose
    private String preDt;
    @SerializedName("pre_away")
    @Expose
    private String preAway;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trip() {
    }

    /**
     * 
     * @param preAway
     * @param tripName
     * @param tripId
     * @param vehicle
     * @param tripHeadsign
     * @param preDt
     */
    public Trip(String tripId, String tripName, String tripHeadsign, String preDt, String preAway, Vehicle vehicle) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.tripHeadsign = tripHeadsign;
        this.preDt = preDt;
        this.preAway = preAway;
        this.vehicle = vehicle;
    }

    /**
     * 
     * @return
     *     The tripId
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * 
     * @param tripId
     *     The trip_id
     */
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    /**
     * 
     * @return
     *     The tripName
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * 
     * @param tripName
     *     The trip_name
     */
    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    /**
     * 
     * @return
     *     The tripHeadsign
     */
    public String getTripHeadsign() {
        return tripHeadsign;
    }

    /**
     * 
     * @param tripHeadsign
     *     The trip_headsign
     */
    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    /**
     * 
     * @return
     *     The preDt
     */
    public String getPreDt() {
        return preDt;
    }

    /**
     * 
     * @param preDt
     *     The pre_dt
     */
    public void setPreDt(String preDt) {
        this.preDt = preDt;
    }

    /**
     * 
     * @return
     *     The preAway
     */
    public String getPreAway() {
        return preAway;
    }

    /**
     * 
     * @param preAway
     *     The pre_away
     */
    public void setPreAway(String preAway) {
        this.preAway = preAway;
    }

    /**
     * 
     * @return
     *     The vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * 
     * @param vehicle
     *     The vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
