rm -rf out
mkdir -p out
CLASS_NAMES=`find ./test -name '*.java' | sed 's/.\/test\///' | sed 's/.java//' | sed 's/\//./g'`
javac -d out -cp lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar $(find . -name '*.java') && 
java -cp out:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore $CLASS_NAMES