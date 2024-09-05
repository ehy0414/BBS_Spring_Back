package react.spring.react_spring_pjt.openapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastItemDTO {

    @JsonProperty("beachNum")
    private String beachNum;
    
    @JsonProperty("baseDate")
    private String baseDate;

    @JsonProperty("baseTime")
    private String baseTime;
    
    @JsonProperty("category")
    private String category;

    @JsonProperty("fcstDate")
    private String fcstDate;

    @JsonProperty("fcstTime")
    private String fcstTime;

    @JsonProperty("fcstValue")
    private String fcstValue;
    
    @JsonProperty("nx")
    private Integer nx;

    @JsonProperty("ny")
    private Integer ny;


    private String categoryName;
}

