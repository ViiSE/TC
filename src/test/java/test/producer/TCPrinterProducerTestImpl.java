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

package test.producer;

import tc.print.TCPrinter;
import tc.print.TCPrinterDefaultImpl;
import tc.print.TCPrinterToFileImpl;
import tc.print.TCPrinterToWindowImpl;
import tc.producer.print.TCPrinterProducer;
import tc.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class TCPrinterProducerTestImpl implements TCPrinterProducer {

    @Override
    public TCPrinter<String> getTCPrinterDefaultInstance(
            Map<String, Map<String, Date>> data, DateFormatter dateFormatter, long numberOfTests) {
        return new TCPrinterDefaultImpl(data, dateFormatter, numberOfTests);
    }

    @Override
    public TCPrinter<Void> getTCPrinterToWindowInstance(
            TCPrinter<String> tcPrinter) {
        return new TCPrinterToWindowImpl(tcPrinter);
    }

    @Override
    public TCPrinter<File> getFileTCPrinterToFileInstance(
            TCPrinter<String> tcPrinter, String fullFilename) {
        return new TCPrinterToFileImpl(tcPrinter, fullFilename);
    }
}
