
package frascog.smartmirror.Transit;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mode {

    @SerializedName("route_type")
    @Expose
    private String routeType;
    @SerializedName("mode_name")
    @Expose
    private String modeName;
    @SerializedName("route")
    @Expose
    private List<Route> route = new ArrayList<Route>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Mode() {
    }

    /**
     * 
     * @param routeType
     * @param route
     * @param modeName
     */
    public Mode(String routeType, String modeName, List<Route> route) {
        this.routeType = routeType;
        this.modeName = modeName;
        this.route = route;
    }

    /**
     * 
     * @return
     *     The routeType
     */
    public String getRouteType() {
        return routeType;
    }

    /**
     * 
     * @param routeType
     *     The route_type
     */
    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    /**
     * 
     * @return
     *     The modeName
     */
    public String getModeName() {
        return modeName;
    }

    /**
     * 
     * @param modeName
     *     The mode_name
     */
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    /**
     * 
     * @return
     *     The route
     */
    public List<Route> getRoute() {
        return route;
    }

    /**
     * 
     * @param route
     *     The route
     */
    public void setRoute(List<Route> route) {
        this.route = route;
    }

}
