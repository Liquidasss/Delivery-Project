package com.spring.liquidasss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class City implements Serializable {

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "distance")
    private Integer distance;

}
