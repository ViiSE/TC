package test.conclusion.format;

import org.springframework.stereotype.Component;

@Component("timeFormatterStringDefault")
public class TimeFormatterStringDefaultImpl implements TimeFormatter<String> {

    @Override
    public String format(String data) {
        return data.substring(data.indexOf("- ") + 1).trim();
    }
}
