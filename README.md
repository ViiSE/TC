# TestConclusion
Tool to summarize test results 

# Usage
<pre>
After build:
java -jar Test_Conclusion.jar 'filename from which the test results are read' 'filename in which the result summarize is written'
</pre>

# Structure of input file
<pre>
Before each methodName <b>\t</b> required!
13.12.2019 10:00:00 - TEST BEGIN<br/>
ClassNameA:<br/>
  methodA1() - 00m 00s 096ms<br/>
  methodA2() - 00m 00s 063ms<br/>
ClassNameB:<br/>
  methodB1() - 00m 00s 219ms<br/>
  methodB2() - 01m 25s 589ms<br/>
13.12.2019 10:02:00 - TEST END<br/>
13.12.2019 10:02:10 - TEST BEGIN<br/>
ClassNameA:<br/>
  methodA1() - 00m 00s 081ms<br/>
  methodA2() - 00m 00s 051ms<br/>
ClassNameB:<br/>
  methodB1() - 00m 00s 224ms<br/>
  methodB1() - 01m 20s 530ms<br/>
13.12.2019 10:04:00 - TEST END<br/>
13.12.2019 10:04:10 - TEST BEGIN<br/>
ClassNameA:<br/>
  methodA1() - 00m 00s 165ms<br/>
  methodA2() - 00m 00s 074ms<br/>
ClassNameB:<br/>
  methodB1() - 00m 00s 231ms<br/>
  methodB1() - 02m 15s 938ms<br/>
13.12.2019 10:06:00 - TEST END<br/>

# Structure of output file
Average times of tests results:<br/>
Number of tests: 3<br/>
testClassB:<br/>
  methodB2(): 01m 40s 686ms<br/>
  methodB1(): 00m 00s 225ms<br/>
testClassA:<br/>
  methodA1(): 00m 00s 114ms<br/>
  methodA2(): 00m 00s 063ms<br/>
</pre>
