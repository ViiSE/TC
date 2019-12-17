package test.conclusion.file;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component("testFileListString")
@Scope("prototype")
public class TestFileListStringImpl implements TestFile<List<String>> {

    private final String fullFilename;

    public TestFileListStringImpl(String fullFilename) {
        this.fullFilename = fullFilename;
    }

    @Override
    public List<String> content() {
        File file = new File(fullFilename);
        List<String> lines;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            lines = br.lines()
                    .filter(l -> !l.contains("TEST BEGIN") && !l.contains("TEST END"))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return lines;
    }

    @Override
    public long numberOfTests() {
        File file = new File(fullFilename);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().filter(l -> l.contains("TEST BEGIN")).count();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
