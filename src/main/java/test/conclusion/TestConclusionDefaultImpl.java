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
