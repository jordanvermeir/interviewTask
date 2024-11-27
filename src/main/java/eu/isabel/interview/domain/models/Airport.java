package eu.isabel.interview.domain.models;

import java.time.ZoneId;

public record Airport(String code, ZoneId timeZone) {

    public static final Airport londonHeathrow = new Airport("LHR", ZoneId.of("Europe/London"));
    public static final Airport londonGatwick = new Airport("LGW", ZoneId.of("Europe/London"));
    public static final Airport melbourne = new Airport("MEL", ZoneId.of("Australia/Melbourne"));
    public static final Airport parisOrly = new Airport("ORY", ZoneId.of("Europe/Paris"));
    public static final Airport parisCharlesDeGaulle = new Airport("CDG", ZoneId.of("Europe/Paris"));
    public static final Airport tokyoAneda = new Airport("TYO", ZoneId.of("Asia/Tokyo"));


}
