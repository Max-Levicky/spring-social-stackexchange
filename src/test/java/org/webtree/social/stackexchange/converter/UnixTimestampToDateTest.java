package org.webtree.social.stackexchange.converter;

import com.fasterxml.jackson.core.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Udjin Skobelev on 07.10.2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnixTimestampToDateTest {
    private final static String UNIX_TIME_IN_SECONDS = "1217462400";

    @Mock
    private JsonParser parser;
    private UnixTimestampToDate converter;

    @Test
    public void name() throws IOException {
        Date dateAfterConverting = new Date(TimeUnit.SECONDS.toMillis(Long.valueOf(UNIX_TIME_IN_SECONDS)));
        converter = new UnixTimestampToDate();
        when(parser.getText()).thenReturn(UNIX_TIME_IN_SECONDS);
        assertThat(converter.deserialize(parser, null)).isEqualTo(dateAfterConverting);
    }
}