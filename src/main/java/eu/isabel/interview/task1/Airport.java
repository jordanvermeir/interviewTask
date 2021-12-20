package eu.isabel.interview.task1;

import java.time.ZoneId;

public final class Airport {

    public static final Airport londonHeathrow       = new Airport("LHR", ZoneId.of("Europe/London"));
    public static final Airport londonGatwick        = new Airport("LGW", ZoneId.of("Europe/London"));
    public static final Airport melbourne            = new Airport("MEL", ZoneId.of("Australia/Melbourne"));
    public static final Airport parisOrly            = new Airport("ORY", ZoneId.of("Europe/Paris"));
    public static final Airport parisCharlesDeGaulle = new Airport("CDG", ZoneId.of("Europe/Paris"));
    public static final Airport tokyoAneda           = new Airport("TYO", ZoneId.of("Asia/Tokyo"));

    private final String code;
    private final ZoneId timeZone;

    public Airport(String code, ZoneId timeZone) {
        this.code = code;
        this.timeZone = timeZone;
    }

    public String getCode() {
        return code;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }



}
