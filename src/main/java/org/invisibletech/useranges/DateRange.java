package org.invisibletech.useranges;

import com.google.common.collect.Range;
import java.time.LocalDateTime;

public class DateRange {
  public Range<LocalDateTime> makeDateRange(final String startStr, final String endStr) {
    LocalDateTime start = LocalDateTime.parse(startStr);
    LocalDateTime end = LocalDateTime.parse(endStr);

    return Range.closedOpen(start, end);
  }
}
