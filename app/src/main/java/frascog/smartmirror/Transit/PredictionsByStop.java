
package frascog.smartmirror.Transit;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredictionsByStop {

    @SerializedName("stop_id")
    @Expose
    private String stopId;
    @SerializedName("stop_name")
    @Expose
    private String stopName;
    @SerializedName("mode")
    @Expose
    private List<Mode> mode = new ArrayList<Mode>();
    @SerializedName("alert_headers")
    @Expose
    private List<AlertHeader> alertHeaders = new ArrayList<AlertHeader>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PredictionsByStop() {
    }

    /**
     * 
     * @param alertHeaders
     * @param stopName
     * @param stopId
     * @param mode
     */
    public PredictionsByStop(String stopId, String stopName, List<Mode> mode, List<AlertHeader> alertHeaders) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.mode = mode;
        this.alertHeaders = alertHeaders;
    }

    /**
     * 
     * @return
     *     The stopId
     */
    public String getStopId() {
        return stopId;
    }

    /**
     * 
     * @param stopId
     *     The stop_id
     */
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    /**
     * 
     * @return
     *     The stopName
     */
    public String getStopName() {
        return stopName;
    }

    /**
     * 
     * @param stopName
     *     The stop_name
     */
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    /**
     * 
     * @return
     *     The mode
     */
    public List<Mode> getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    public void setMode(List<Mode> mode) {
        this.mode = mode;
    }

    /**
     * 
     * @return
     *     The alertHeaders
     */
    public List<AlertHeader> getAlertHeaders() {
        return alertHeaders;
    }

    /**
     * 
     * @param alertHeaders
     *     The alert_headers
     */
    public void setAlertHeaders(List<AlertHeader> alertHeaders) {
        this.alertHeaders = alertHeaders;
    }

}
