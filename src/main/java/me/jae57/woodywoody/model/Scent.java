package me.jae57.woodywoody.model;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude="scentId")
public class Scent {
    private Long scentId;
    private String scentName;
    private String scentKorName;
    private String brand;
    private String fragrance;
}
