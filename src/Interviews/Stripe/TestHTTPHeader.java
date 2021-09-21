package Interviews.Stripe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestHTTPHeader {
    HTTPHeader parser = new HTTPHeader();

    @Test
    public void testEmptyHeader() {
        List<String> result = parser.parseAcceptLanguage1("", Arrays.asList("en-US", "fr-CA"));
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testEmptySupportedLanguage() {
        List<String> result = parser.parseAcceptLanguage1("en-US, fr-CA", Arrays.asList());
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testValidInput() {
        List<String> result = parser.parseAcceptLanguage1("en-US, fr-CA", Arrays.asList("en-US", "fr-CA"));
        assertEquals(Arrays.asList("en-US", "fr-CA"), result);
    }
}
