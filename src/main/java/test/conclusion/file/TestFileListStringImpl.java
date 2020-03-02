/*
 *   Copyright 2020 ViiSE
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
