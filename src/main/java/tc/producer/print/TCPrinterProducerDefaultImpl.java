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

package tc.producer.print;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import tc.print.TCPrinter;
import tc.print.TCPrinterDefaultImpl;
import tc.print.TCPrinterToFileImpl;
import tc.print.TCPrinterToWindowImpl;
import tc.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

@Service("tcPrinterProducerDefault")
public class TCPrinterProducerDefaultImpl implements TCPrinterProducer {

    private final ApplicationContext ctx;

    public TCPrinterProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public TCPrinter<String> getTCPrinterDefaultInstance(
            Map<String, Map<String, Date>> data,
            DateFormatter dateFormatter,
            long numberOfTests) {
        return (TCPrinterDefaultImpl) ctx.getBean("tcPrinterDefault", data, dateFormatter, numberOfTests);
    }

    @Override
    public TCPrinter<Void> getTCPrinterToWindowInstance(TCPrinter<String> tcPrinter) {
        return (TCPrinterToWindowImpl) ctx.getBean("tcPrinterToWindow", tcPrinter);
    }

    @Override
    public TCPrinter<File> getFileTCPrinterToFileInstance(
            TCPrinter<String> tcPrinter,
            String fullFilename) {
        return (TCPrinterToFileImpl) ctx.getBean(
                "tcPrinterToFile",
                tcPrinter,
                fullFilename);
    }
}
