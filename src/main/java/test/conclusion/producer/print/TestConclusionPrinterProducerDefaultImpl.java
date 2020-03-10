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

package test.conclusion.producer.print;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.print.TestConclusionPrinterDefaultImpl;
import test.conclusion.print.TestConclusionPrinterToFileImpl;
import test.conclusion.print.TestConclusionPrinterToWindowImpl;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

@Service("testConclusionPrinterProducerDefault")
public class TestConclusionPrinterProducerDefaultImpl implements TestConclusionPrinterProducer {

    private final ApplicationContext ctx;

    public TestConclusionPrinterProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data,
            DateFormatter dateFormatter,
            long numberOfTests) {
        return (TestConclusionPrinterDefaultImpl) ctx.getBean("testConclusionPrinterDefault", data, dateFormatter, numberOfTests);
    }

    @Override
    public TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(TestConclusionPrinter<String> testConclusionPrinter) {
        return (TestConclusionPrinterToWindowImpl) ctx.getBean("testConclusionPrinterToWindow", testConclusionPrinter);
    }

    @Override
    public TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter,
            String fullFilename) {
        return (TestConclusionPrinterToFileImpl) ctx.getBean(
                "testConclusionPrinterToFile",
                testConclusionPrinter,
                fullFilename);
    }
}
