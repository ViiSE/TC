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
