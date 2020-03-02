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

package test.conclusion.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.conclusion.time.DateFormatter;

import java.util.Date;
import java.util.Map;

@Component("testConclusionPrinterDefault")
@Scope("prototype")
public class TestConclusionPrinterDefaultImpl implements TestConclusionPrinter<String> {

    private final Map<String, Map<String, Date>> data;
    private final DateFormatter dateFormatter;
    private final long numberOfTests;

    public TestConclusionPrinterDefaultImpl(Map<String, Map<String, Date>> data, DateFormatter dateFormatter, long numberOfTests) {
        this.data = data;
        this.dateFormatter = dateFormatter;
        this.numberOfTests = numberOfTests;
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("Average times of tests results:\n");
        result.append("Number of tests: ").append(numberOfTests).append("\n");
        data.forEach((testClassName, testMethods) -> {
            result.append(testClassName).append(":");
            testMethods.forEach((testMethodName, avgTestTime) -> {
                String avgTime = dateFormatter.format(avgTestTime);
                result.append("\n\t").append(testMethodName).append(": ").append(avgTime);
            });
            result.append("\n");
        });

        return result.toString();
    }
}
