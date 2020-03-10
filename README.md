<p align="center"> 
<img src="https://user-images.githubusercontent.com/43209824/76285395-6801b380-62eb-11ea-8d5e-5f5177cfdad2.png"
     width="300" height="300">
</p>
# TC - TestConclusion
Tool to summarize test results 

# Usage
<pre>
After build:
java -jar TC.jar &lt;filename_from_which_the_test_results_are_read&gt; &lt;filename_in_which_the_result_summarize_is_written&gt; <i>Optional Third Parameter</i> --api
</pre>

# Structure of input file
<pre>
<b>WARNING!</b> Before each method name <b>\t</b> required!
13.12.2019 10:00:00 - TEST BEGIN
ClassNameA:
  methodA1() - 00m 00s 096ms
  methodA2() - 00m 00s 063ms
ClassNameB:
  methodB1() - 00m 00s 219ms
  methodB2() - 01m 25s 589ms
13.12.2019 10:02:00 - TEST END
13.12.2019 10:02:10 - TEST BEGIN
ClassNameA:
  methodA1() - 00m 00s 081ms
  methodA2() - 00m 00s 051ms
ClassNameB:
  methodB1() - 00m 00s 224ms
  methodB1() - 01m 20s 530ms
13.12.2019 10:04:00 - TEST END
13.12.2019 10:04:10 - TEST BEGIN
ClassNameA:
  methodA1() - 00m 00s 165ms
  methodA2() - 00m 00s 074ms
ClassNameB:
  methodB1() - 00m 00s 231ms
  methodB1() - 02m 15s 938ms
13.12.2019 10:06:00 - TEST END
</pre>

# Structure of output file
<pre>
Average times of tests results:
Number of tests: 3
testClassB:
  methodB2(): 01m 40s 686ms
  methodB1(): 00m 00s 225ms
testClassA:
  methodA1(): 00m 00s 114ms
  methodA2(): 00m 00s 063ms
</pre>

# Support API tests
If after the output file specify the key <b>--api</b>, then the option is turned on API test.

# Structure of input file (for API)
<pre>
<b>WARNING!</b> Before each method name <b>\t</b> required!
TEST BEGIN
GET:
  http:myapi.com/get/point/1 - 00m 00s 096ms
TEST END
TEST BEGIN
GET:
  http:myapi.com/get/point/2 - 00m 00s 219ms
TEST END
TEST BEGIN
POST:
  http:myapi.com/post/point/1 - 00m 00s 081ms
TEST END
</pre>

# Structure of output file (for API)
<pre>
Average times of tests results:
Number of tests: 3
GET:
  http:myapi.com/get/point/1 - 00m 00s 096ms
  http:myapi.com/get/point/2 - 00m 00s 219ms
POST:
  http:myapi.com/post/point/1 - 00m 00s 081ms
</pre>

