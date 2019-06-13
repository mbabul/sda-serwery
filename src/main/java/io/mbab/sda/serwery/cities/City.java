package io.mbab.sda.serwery.cities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class City {

    private long id;
    private String name;
}
