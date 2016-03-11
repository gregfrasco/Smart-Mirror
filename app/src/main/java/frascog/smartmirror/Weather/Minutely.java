package frascog.smartmirror.Weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Minutely {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Minutely() {
    }

    /**
     * 
     * @param summary
     * @param icon
     * @param data
     */
    public Minutely(String summary, String icon, List<Datum> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
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

    public Minutely withSummary(String summary) {
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

    public Minutely withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Minutely withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}
