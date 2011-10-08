// report suite
println "##teamcity[testSuiteStarted name='suite.name']"
println "##teamcity[testSuiteFinished name='suite.name']"

// report test w/ captured output
println "##teamcity[testStarted name='testname' captureStandardOutput='true']"
println "test output"
println "##teamcity[testFinished name='testname']"

// report test
println "##teamcity[testStarted name='testname2']"
println "test output"
println "##teamcity[testFinished name='testname2']"

// ignored test
println "##teamcity[testIgnored name='testname' message='who needs tests anyway?!']"

// different test output
println "##teamcity[testStarted name='testname']"
println "##teamcity[testStdOut name='testname' out='std.out']"
println "##teamcity[testStdErr name='testname' out='std.err']"
println "##teamcity[testFinished name='testname' duration='50']"

// test failed
println "##teamcity[testStarted name='failed.test']"
println "##teamcity[testFailed name='failed.test' message='failure message' details='messages and stacktrace']"
println "##teamcity[testFinished name='failed.test']"

// test failed w/ details...unfortunately TC escapes HTML
println "##teamcity[testStarted name='failed.test2']"
println "##teamcity[testFailed name='failed.test2' message='failed html test' details='<html></html>']"
println "##teamcity[testFinished name='failed.test2']"

// publish an artifact while the build is running
def file = File.createTempFile("sweet", "file.txt")
file.write("published")
println "##teamcity[publishArtifacts '${file.absolutePath}']"

// publish artifacts with a directory on TC and using a pattern on files
def file2 = File.createTempFile("another", "file.txt")
file2.write("sweet")
println "##teamcity[publishArtifacts '${file2.parentFile.absolutePath}/*.txt => textFiles']"

