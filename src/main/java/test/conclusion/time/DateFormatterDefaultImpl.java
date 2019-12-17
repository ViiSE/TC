package test.conclusion.time;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateFormatterDefault")
public class DateFormatterDefaultImpl implements DateFormatter {

    @Override
    public String format(Date time) {
        return new SimpleDateFormat("mm'm' ss's' SSS'ms'").format(time);
    }
}
