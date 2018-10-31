package org.webtree.social.stackexchange.converter;

import com.fasterxml.jackson.core.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Udjin Skobelev on 07.10.2018.
 */

@ExtendWith(MockitoExtension.class)
public class UnixTimestampToLocalDateTimeTest {
    //Thursday, 31 July 2008, 0:00:00
    private final static String UNIX_TIME_IN_SECONDS = "1217462400";

    @Mock
    private JsonParser parser;
    private UnixTimestampToLocalDateTime converter;

    @Test
    public void name() throws IOException {
        LocalDateTime localDateTime = LocalDateTime.of(2008, 7, 31, 0, 0, 0);
        converter = new UnixTimestampToLocalDateTime();
        when(parser.getText()).thenReturn(UNIX_TIME_IN_SECONDS);
        assertThat(converter.deserialize(parser, null)).isEqualTo(localDateTime);
    }
}