/*
 *     Copyright (C) 2020 ViiSE
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package tc.file;

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
