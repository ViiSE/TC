package test.conclusion.format;

import org.springframework.stereotype.Component;

@Component("classFormatterStringDefault")
public class ClassFormatterStringDefaultImpl implements ClassFormatter<String> {

    @Override
    public String format(String data) {
        return data.trim();
    }
}
