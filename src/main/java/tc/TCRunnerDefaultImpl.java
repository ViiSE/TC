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

package tc;

import org.springframework.stereotype.Component;
import tc.file.TestFile;
import tc.format.TestFormatter;
import tc.service.TCRunnerProducerService;

import java.util.List;

@Component("tcRunnerDefault")
public class TCRunnerDefaultImpl implements TCRunner<String> {

    private final TestClasses testClasses;
    private final TestFormatter<String, String, String> testFormatter;
    private final TCRunnerProducerService service;

    public TCRunnerDefaultImpl(
            TestClasses testClasses,
            TestFormatter<String, String, String> testFormatter,
            TCRunnerProducerService service) {
        this.testClasses = testClasses;
        this.testFormatter = testFormatter;
        this.service = service;
    }

    @Override
    public void run(String fullFilename, TestFile<List<String>> testFile) {
        List<String> content = testFile.content();
        String testClassName = "";
        for(String line: content) {
            if(line.contains("\t")) {
                String methodName = testFormatter.formatMethod(line);
                String testTime = testFormatter.formatTime(line);
                TestMethod testMethod = service.testMethodCreatorProducer()
                        .getTestMethodCreatorDefaultInstance()
                        .create(new String[] {methodName, testTime});
                testClasses.addTestMethod(testClassName, testMethod);
            } else {
                testClassName = testFormatter.formatClass(line);
                TestClass testClass = service.testClassCreatorProducer()
                        .getTestClassCreatorDefaultInstance()
                        .create(testClassName);
                testClasses.addClass(testClass);
            }
        }

        service.tcProducer()
                .getTCDefaultInstance()
                .create(fullFilename, testClasses.calculateAvgTime(), testFile.numberOfTests());
    }
}
