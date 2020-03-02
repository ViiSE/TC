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

package test.producer;

import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.print.TestConclusionPrinterDefaultImpl;
import test.conclusion.print.TestConclusionPrinterToFileImpl;
import test.conclusion.print.TestConclusionPrinterToWindowImpl;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class TestConclusionPrinterProducerTestImpl implements TestConclusionPrinterProducer {

    @Override
    public TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data, DateFormatter dateFormatter, long numberOfTests) {
        return new TestConclusionPrinterDefaultImpl(data, dateFormatter, numberOfTests);
    }

    @Override
    public TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(
            TestConclusionPrinter<String> testConclusionPrinter) {
        return new TestConclusionPrinterToWindowImpl(testConclusionPrinter);
    }

    @Override
    public TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter, String fullFilename) {
        return new TestConclusionPrinterToFileImpl(testConclusionPrinter, fullFilename);
    }
}
