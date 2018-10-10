package org.webtree.social.stackexchange.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Udjin Skobelev on 07.10.2018.
 */

public class UnixTimestampToDate extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String unixTimestamp = p.getText().trim();
        return new Date(TimeUnit.SECONDS.toMillis(Long.valueOf(unixTimestamp)));
    }
}
