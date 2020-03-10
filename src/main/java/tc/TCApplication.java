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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tc.configuration.TCConfiguration;
import tc.file.TestFile;
import tc.file.TestFileListStringImpl;

import java.util.List;

public class TCApplication {

	public static void main(String[] args) {
		String shKeyApi = "";

		if(args.length == 0)
			throw new RuntimeException("Enter the filename from which the test results are read!");
		if(args.length == 1)
			throw new RuntimeException("Enter the filename in which the result of the program execution is written!");
		if(args.length == 3)
			if(!args[2].equals("--api"))
				throw new RuntimeException("Unknown command!");
			else
				shKeyApi = "--api";

		ApplicationContext ctx = new AnnotationConfigApplicationContext(TCConfiguration.class);

		String fullFilenameOld = args[0];
		String fullFilenameNew = args[1];

		TestFile<List<String>> testFile = (TestFileListStringImpl) ctx.getBean("testFileListString", fullFilenameOld);
		ctx.getBean(TCGreetingsDefaultImpl.class).greeting();

		TCRunner<String> runner;
		if(!shKeyApi.isEmpty())
			runner = ctx.getBean("tcRunnerForAPI", TCRunnerForAPIImpl.class);
		else
			runner = ctx.getBean("tcRunnerDefault", TCRunnerDefaultImpl.class);
		runner.run(fullFilenameNew, testFile);
	}

}
