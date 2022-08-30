package com.thinhlh.project1.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public abstract class DateTimeHelper {


    public static String DD_MM_YYYY = "dd-MM-yyyy";

    public static Date fromString(String source, String format) {
        try {
            return new SimpleDateFormat(format).parse(source);
        } catch (ParseException e) {
            return Date.from(Instant.now());
        }
    }

    public static String format(Date source, String format) {
        return new SimpleDateFormat(format).format(source);
    }
}
