package org.webtree.social.stackexchange.converter;

import com.fasterxml.jackson.core.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Udjin Skobelev on 07.10.2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnixTimestampToDateTest {
    //Thursday, 31 July 2008, 0:00:00
    private final static String UNIX_TIME_IN_SECONDS = "1217462400";

    @Mock
    private JsonParser parser;
    private UnixTimestampToDate converter;

    @Test
    public void name() throws IOException {

        Calendar calendar = new GregorianCalendar(2008, 6, 31);
        Instant instant = Instant.ofEpochSecond(1217462400);
        Instant.
        System.out.println(instant.toString());
        Date dateAfterConverting = calendar.getTime();



        System.out.println(dateAfterConverting.toString());
        converter = new UnixTimestampToDate();
        when(parser.getText()).thenReturn(UNIX_TIME_IN_SECONDS);
        assertThat(converter.deserialize(parser, null)).isEqualTo(dateAfterConverting);
    }
}