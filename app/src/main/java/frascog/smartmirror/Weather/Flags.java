package frascog.smartmirror.Weather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags implements Serializable {

    @SerializedName("sources")
    @Expose
    private List<String> sources = new ArrayList<String>();
    @SerializedName("darksky-stations")
    @Expose
    private List<String> darkskyStations = new ArrayList<String>();
    @SerializedName("lamp-stations")
    @Expose
    private List<String> lampStations = new ArrayList<String>();
    @SerializedName("isd-stations")
    @Expose
    private List<String> isdStations = new ArrayList<String>();
    @SerializedName("madis-stations")
    @Expose
    private List<String> madisStations = new ArrayList<String>();
    @SerializedName("units")
    @Expose
    private String units;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Flags() {
    }

    /**
     * 
     * @param isdStations
     * @param lampStations
     * @param darkskyStations
     * @param units
     * @param sources
     * @param madisStations
     */
    public Flags(List<String> sources, List<String> darkskyStations, List<String> lampStations, List<String> isdStations, List<String> madisStations, String units) {
        this.sources = sources;
        this.darkskyStations = darkskyStations;
        this.lampStations = lampStations;
        this.isdStations = isdStations;
        this.madisStations = madisStations;
        this.units = units;
    }

    /**
     * 
     * @return
     *     The sources
     */
    public List<String> getSources() {
        return sources;
    }

    /**
     * 
     * @param sources
     *     The sources
     */
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public Flags withSources(List<String> sources) {
        this.sources = sources;
        return this;
    }

    /**
     * 
     * @return
     *     The darkskyStations
     */
    public List<String> getDarkskyStations() {
        return darkskyStations;
    }

    /**
     * 
     * @param darkskyStations
     *     The darksky-stations
     */
    public void setDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
    }

    public Flags withDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
        return this;
    }

    /**
     * 
     * @return
     *     The lampStations
     */
    public List<String> getLampStations() {
        return lampStations;
    }

    /**
     * 
     * @param lampStations
     *     The lamp-stations
     */
    public void setLampStations(List<String> lampStations) {
        this.lampStations = lampStations;
    }

    public Flags withLampStations(List<String> lampStations) {
        this.lampStations = lampStations;
        return this;
    }

    /**
     * 
     * @return
     *     The isdStations
     */
    public List<String> getIsdStations() {
        return isdStations;
    }

    /**
     * 
     * @param isdStations
     *     The isd-stations
     */
    public void setIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
    }

    public Flags withIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
        return this;
    }

    /**
     * 
     * @return
     *     The madisStations
     */
    public List<String> getMadisStations() {
        return madisStations;
    }

    /**
     * 
     * @param madisStations
     *     The madis-stations
     */
    public void setMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
    }

    public Flags withMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
        return this;
    }

    /**
     * 
     * @return
     *     The units
     */
    public String getUnits() {
        return units;
    }

    /**
     * 
     * @param units
     *     The units
     */
    public void setUnits(String units) {
        this.units = units;
    }

    public Flags withUnits(String units) {
        this.units = units;
        return this;
    }

}
