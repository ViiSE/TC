package test.conclusion.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testConclusionPrinterToWindow")
@Scope("prototype")
public class TestConclusionPrinterToWindowImpl implements TestConclusionPrinter<Void> {

    private final TestConclusionPrinter<String> testConclusionPrinter;

    public TestConclusionPrinterToWindowImpl(TestConclusionPrinter<String> testConclusionPrinter) {
        this.testConclusionPrinter = testConclusionPrinter;
    }

    @Override
    public Void print() {
        String result = testConclusionPrinter.print();
        System.out.println(result);

        return null;
    }
}
