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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("tcPrinterToFile")
@Scope("prototype")
public class TCPrinterToFileImpl implements TCPrinter<File> {

    private final TCPrinter<String> tcPrinter;
    private final String fullFilename;

    public TCPrinterToFileImpl(TCPrinter<String> tcPrinter, String fullFilename) {
        this.tcPrinter = tcPrinter;
        this.fullFilename = fullFilename;
    }

    @Override
    public File print() {
        try {
            String result = tcPrinter.print();

            File file = new File(fullFilename);
            if(file.createNewFile())
                System.out.println("File " + fullFilename + " is created!");
            else
                System.out.println("File " + fullFilename + " is exist!");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Result in the " + fullFilename);

            return file;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
