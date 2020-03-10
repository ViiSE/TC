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
import tc.print.TCPrinter;
import tc.producer.print.TCPrinterProducer;
import tc.time.DateFormatter;

import java.util.Date;
import java.util.Map;

@Component("tcDefault")
public class TCDefaultImpl implements TC<Map<String, Map<String, Date>>> {

    private final DateFormatter dateFormatter;
    private final TCPrinterProducer printerProducer;

    public TCDefaultImpl(DateFormatter dateFormatter, TCPrinterProducer printerProducer) {
        this.dateFormatter = dateFormatter;
        this.printerProducer = printerProducer;
    }

    @Override
    public void create(String fullFilename, Map<String, Map<String, Date>> result, long numberOfTests) {
        TCPrinter<String> tcp =
                printerProducer.getTCPrinterDefaultInstance(
                                result,
                                dateFormatter,
                                numberOfTests);
        printerProducer.getTCPrinterToWindowInstance(tcp)
                .print();
        printerProducer.getFileTCPrinterToFileInstance(tcp, fullFilename)
                .print();
    }
}
