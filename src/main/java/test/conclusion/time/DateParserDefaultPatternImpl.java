package test.conclusion.time;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateParserDefaultPattern")
public class DateParserDefaultPatternImpl implements DateParser {

    @Override
    public Date parse(String time) {
        try {
            return new SimpleDateFormat("mm'm' ss's' SSS'ms'").parse(time);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
