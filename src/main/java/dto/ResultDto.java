package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
@Data

public class ResultDto {

    private long artistId;
    private long collectionId;
    private String wrapperType;
    private long resultCount;
    private String country;
}


