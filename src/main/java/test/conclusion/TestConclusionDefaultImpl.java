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

package test.conclusion;

import org.springframework.stereotype.Component;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.time.DateFormatter;

import java.util.Date;
import java.util.Map;

@Component("testConclusionDefault")
public class TestConclusionDefaultImpl implements TestConclusion<Map<String, Map<String, Date>>> {

    private final DateFormatter dateFormatter;
    private final TestConclusionPrinterProducer printerProducer;

    public TestConclusionDefaultImpl(DateFormatter dateFormatter, TestConclusionPrinterProducer printerProducer) {
        this.dateFormatter = dateFormatter;
        this.printerProducer = printerProducer;
    }

    @Override
    public void create(String fullFilename, Map<String, Map<String, Date>> result, long numberOfTests) {
        TestConclusionPrinter<String> tcp =
                printerProducer.getTestConclusionPrinterDefaultInstance(
                                result,
                                dateFormatter,
                                numberOfTests);
        printerProducer.getTestConclusionPrinterToWindowInstance(tcp)
                .print();
        printerProducer.getFileTestConclusionPrinterToFileInstance(tcp, fullFilename)
                .print();
    }
}
