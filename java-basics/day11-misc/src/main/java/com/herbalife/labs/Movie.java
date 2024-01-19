package com.herbalife.labs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movie(@JsonProperty("Title") String title,
                    @JsonProperty("Year") int year,
                    @JsonProperty("Genre") String genre) {
}
