package com.metro.metromilan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.geojson.LngLatAlt;

public class firstTimeEntity {
    @JsonProperty("coordinates")
    private LngLatAlt lngLatAlt;
    //Not in Use as of now...
}
