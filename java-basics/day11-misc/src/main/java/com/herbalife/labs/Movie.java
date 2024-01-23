package com.herbalife.labs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movie(@JsonProperty("Title") String title,
                    @JsonProperty("Year") String year,
                    @JsonProperty("Genre") String genre,
                    @JsonProperty("Response") String response,
                    @JsonProperty("Error") String error) {
}
