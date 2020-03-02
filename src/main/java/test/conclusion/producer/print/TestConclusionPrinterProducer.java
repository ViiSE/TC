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

package test.conclusion.producer.print;

import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

public interface TestConclusionPrinterProducer {
    TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data,
            DateFormatter dateFormatter,
            long numberOfTests);
    TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(
            TestConclusionPrinter<String> testConclusionPrinter);
    TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter,
            String fullFilename);
}
