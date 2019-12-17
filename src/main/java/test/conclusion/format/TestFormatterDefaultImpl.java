package test.conclusion.format;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testFormatterDefault")
@Scope("prototype")
public class TestFormatterDefaultImpl implements TestFormatter<String, String, String> {

    private final ClassFormatter<String> classFormatter;
    private final MethodFormatter<String> methodFormatter;
    private final TimeFormatter<String> timeFormatter;

    public TestFormatterDefaultImpl(
            ClassFormatter<String> classFormatter,
            MethodFormatter<String> methodFormatter,
            TimeFormatter<String> timeFormatter) {
        this.classFormatter = classFormatter;
        this.methodFormatter = methodFormatter;
        this.timeFormatter = timeFormatter;
    }

    @Override
    public String formatMethod(String data) {
        return methodFormatter.format(data);
    }

    @Override
    public String formatClass(String data) {
        return classFormatter.format(data);
    }

    @Override
    public String formatTime(String data) {
        return timeFormatter.format(data);
    }
}
