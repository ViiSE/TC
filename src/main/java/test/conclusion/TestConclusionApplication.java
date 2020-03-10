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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.conclusion.configuration.TestConclusionConfiguration;
import test.conclusion.file.TestFile;
import test.conclusion.file.TestFileListStringImpl;

import java.util.List;

public class TestConclusionApplication {

	public static void main(String[] args) {
		String shKeyApi = "";

		args = new String[]{
//				"/home/viise/fd-api/api-bot/API-Bot/target/lightsearch_result",
				"/home/viise/fd-api/fd-api-service/FD-API-Service/elapse_time_test_50",
				"/home/viise/fd-api/api-bot/API-Bot/target/new_res_test_NO_API"
		};
//				"--api"};

		if(args.length == 0)
			throw new RuntimeException("Enter the filename from which the test results are read!");
		if(args.length == 1)
			throw new RuntimeException("Enter the filename in which the result of the program execution is written!");
		if(args.length == 3)
			if(!args[2].equals("--api"))
				throw new RuntimeException("Unknown command!");
			else
				shKeyApi = "--api";

		ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConclusionConfiguration.class);

		String fullFilenameOld = args[0];
		String fullFilenameNew = args[1];

		TestFile<List<String>> testFile = (TestFileListStringImpl) ctx.getBean("testFileListString", fullFilenameOld);
		ctx.getBean(TestConclusionGreetingsDefaultImpl.class).greeting();

		TestConclusionRunner<String> runner;
		if(!shKeyApi.isEmpty())
			runner = ctx.getBean("testConclusionRunnerForAPI", TestConclusionRunnerForAPIImpl.class);
		else
			runner = ctx.getBean("testConclusionRunnerDefault", TestConclusionRunnerDefaultImpl.class);
		runner.run(fullFilenameNew, testFile);
	}

}
