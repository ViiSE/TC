package test.conclusion.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("testConclusionPrinterToFile")
@Scope("prototype")
public class TestConclusionPrinterToFileImpl implements TestConclusionPrinter<File> {

    private final TestConclusionPrinter<String> testConclusionPrinter;
    private final String fullFilename;

    public TestConclusionPrinterToFileImpl(TestConclusionPrinter<String> testConclusionPrinter, String fullFilename) {
        this.testConclusionPrinter = testConclusionPrinter;
        this.fullFilename = fullFilename;
    }

    @Override
    public File print() {
        try {
            String result = testConclusionPrinter.print();

            File file = new File(fullFilename);
            if(file.createNewFile())
                System.out.println("File " + fullFilename + " is created!");
            else
                System.out.println("File " + fullFilename + " is exist!");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Result in the " + fullFilename);

            return file;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
