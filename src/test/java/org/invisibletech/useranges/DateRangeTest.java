package org.invisibletech.useranges;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.Range;
import java.time.LocalDateTime;

import java.time.format.DateTimeParseException;

public class DateRangeTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void should_beEmpty() {
    DateRange dateRange = new DateRange();

    Range<LocalDateTime> range = dateRange
      .makeDateRange("2007-12-03T10:00:00",
        "2007-12-03T10:00:00");

    assertEquals(true, range.isEmpty());
  }

  @Test
  public void should_notBeEmpty() {
    DateRange dateRange = new DateRange();

    Range<LocalDateTime> range = dateRange
      .makeDateRange("2007-12-03T10:00:00",
                     "2007-12-03T10:00:01");

    assertEquals(true, !range.isEmpty());
  }

  @Test
  public void should_raiseException() {
    DateRange dateRange = new DateRange();

    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(startsWith("Invalid range: "));

    Range<LocalDateTime> range = dateRange
      .makeDateRange("2007-12-07T10:00:00",
                     "2007-12-03T10:00:01");
  }

  @Test
  public void should_raiseExceptionWithGarbageStrings(){
    DateRange dateRange = new DateRange();

    thrown.expect(DateTimeParseException.class);

    dateRange.makeDateRange("wowee","doggos");
  }
}
