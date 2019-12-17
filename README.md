# TestConclusion
Tool to summarize test results 

# Usage
<pre>
After build:
java -jar Test_Conclusion.jar &lt;filename from which the test results are read&gt; &lt;filename in which the result summarize is written&gt;
</pre>

# Structure of input file
<pre>
Before each methodName <b>\t</b> required!
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

# Structure of output file
Average times of tests results:
Number of tests: 3
testClassB:
  methodB2(): 01m 40s 686ms
  methodB1(): 00m 00s 225ms
testClassA:
  methodA1(): 00m 00s 114ms
  methodA2(): 00m 00s 063ms
</pre>
