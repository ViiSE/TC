package test.conclusion.format;

import org.springframework.stereotype.Component;

@Component("methodFormatterStringDefault")
public class MethodFormatterStringDefaultImpl implements MethodFormatter<String> {

    @Override
    public String format(String data) {
        return data.substring(0, data.indexOf(" -")).replaceAll("\t", "").trim();
    }
}
