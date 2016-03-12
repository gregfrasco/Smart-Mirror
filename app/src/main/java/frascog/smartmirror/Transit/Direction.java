
package frascog.smartmirror.Transit;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Direction {

    @SerializedName("direction_id")
    @Expose
    private String directionId;
    @SerializedName("direction_name")
    @Expose
    private String directionName;
    @SerializedName("trip")
    @Expose
    private List<Trip> trip = new ArrayList<Trip>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Direction() {
    }

    /**
     * 
     * @param directionId
     * @param trip
     * @param directionName
     */
    public Direction(String directionId, String directionName, List<Trip> trip) {
        this.directionId = directionId;
        this.directionName = directionName;
        this.trip = trip;
    }

    /**
     * 
     * @return
     *     The directionId
     */
    public String getDirectionId() {
        return directionId;
    }

    /**
     * 
     * @param directionId
     *     The direction_id
     */
    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    /**
     * 
     * @return
     *     The directionName
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * 
     * @param directionName
     *     The direction_name
     */
    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    /**
     * 
     * @return
     *     The trip
     */
    public List<Trip> getTrip() {
        return trip;
    }

    /**
     * 
     * @param trip
     *     The trip
     */
    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

}
