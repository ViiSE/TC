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

package tc.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tc.time.DateFormatter;

import java.util.Date;
import java.util.Map;

@Component("tcPrinterDefault")
@Scope("prototype")
public class TCPrinterDefaultImpl implements TCPrinter<String> {

    private final Map<String, Map<String, Date>> data;
    private final DateFormatter dateFormatter;
    private final long numberOfTests;

    public TCPrinterDefaultImpl(Map<String, Map<String, Date>> data, DateFormatter dateFormatter, long numberOfTests) {
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
