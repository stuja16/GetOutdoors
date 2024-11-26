package edu.lawrence.getoutdoors.interfaces.dtos;

import java.time.Instant;

import edu.lawrence.getoutdoors.entities.Trail_Data;

public class TrailDTO {
    private Integer trail_number;
    private Instant source_date;
    private String trail_name;
    private String source;
    private String hiking;
    private String bicycle;
    private String snowshoe;
    private String crosscountryski;
    private Double distance;

    public TrailDTO() {}

    public TrailDTO(Trail_Data core) {
        trail_number = core.getTrail_number();
        source_date = core.getSource_date();
        trail_name = core.getTrail_name();
        source = core.getSource();
        hiking = core.getHiking();
        bicycle = core.getBicycle();
        snowshoe = core.getSnowshoe();
        crosscountryski = core.getCrosscountryski();
        distance = core.getDistance();
    }
    
    public Integer getTrail_number() {
        return this.trail_number;
    }

    public void setTrail_number(Integer trail_number) {
        this.trail_number = trail_number;
    }

    public Instant getSource_date() {
        return this.source_date;
    }

    public void setSource_date(Instant source_date) {
        this.source_date = source_date;
    }

    public String getTrail_name() {
        return this.trail_name;
    }

    public void setTrail_name(String trail_name) {
        this.trail_name = trail_name;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getHiking() {
        return this.hiking;
    }

    public void setHiking(String hiking) {
        this.hiking = hiking;
    }

    public String getBicycle() {
        return this.bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getSnowshoe() {
        return this.snowshoe;
    }

    public void setSnowshoe(String snowshoe) {
        this.snowshoe = snowshoe;
    }

    public String getCrosscountryski() {
        return this.crosscountryski;
    }

    public void setCrosscountryski(String crosscountryski) {
        this.crosscountryski = crosscountryski;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

}
