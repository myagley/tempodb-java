package com.tempodb.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.Period;
import org.junit.*;
import static org.junit.Assert.*;

import com.tempodb.Fold;
import com.tempodb.Rollup;


public class RollupTest {

  @Test
  public void testDeserialize() throws IOException {
    ObjectMapper mapper = Json.newObjectMapper();
    Rollup rollup = mapper.readValue("{\"period\":\"PT1M\",\"fold\":\"sum\"}", Rollup.class);
    Rollup expected = new Rollup(Period.minutes(1), Fold.SUM);
    assertEquals(expected, rollup);
  }

  @Test
  public void testSerialize() throws IOException {
    ObjectMapper mapper = Json.newObjectMapper();
    Rollup rollup = new Rollup(Period.minutes(1), Fold.SUM);
    String expected = "{\"period\":\"PT1M\",\"fold\":\"sum\"}";
    assertEquals(expected, mapper.writeValueAsString(rollup));
  }
}