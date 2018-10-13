package org.webtree.social.stackexchange.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by Udjin Skobelev on 07.10.2018.
 */

public class UnixTimestampToLocalDateTime extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Long unixTimestamp = Long.parseLong(p.getText().trim());
        return LocalDateTime.ofEpochSecond(unixTimestamp, 0, ZoneOffset.UTC);
    }
}
