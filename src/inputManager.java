import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.BufferedReader;

public abstract class inputManager {

    private static FileReader readingFile(String filename) {
        FileReader inputStream = null;
//        FileWriter outputStream = null;
        try {
            inputStream = new FileReader(filename);
            return inputStream;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int countLines(FileReader filereader) {
        try {
            // FileReader filereader = new FileReader(filename);
            LineNumberReader lineNumber = new LineNumberReader(filereader);
            lineNumber.skip(Long.MAX_VALUE);
            // System.out.println("Number of Lines: " + lineNumber.getLineNumber());
            return ((lineNumber.getLineNumber()) + 1);

        } catch (IOException e) {
            e.printStackTrace();
            return 99;
        }
    }

    // Dependencies :
    // 1. readingFile(string filname)
    // 2. countLines(FileReader filereader)
    public static operationsQueue instructionExtractor(String filename) {
        // Comment out next line - not needed
//        System.out.println("number of lines: " + countLines(readingFile(filename)));
        int numberOfLines = countLines(readingFile(filename));
        operationsQueue operationsQueueObj = new operationsQueue(numberOfLines);
        try {
            // inputStream = new FileReader(filename); === readingFile(filename)
//            BufferedReader buffReader = new BufferedReader(Objects.requireNonNull(readingFile(filename)));
            BufferedReader buffReader = new BufferedReader((readingFile(filename)));

            int inputChar = 0;
            int breakNow = 0;
            boolean instructionCharRead = false;
            instructions instructionsObj = new instructions();
            StringBuilder strBuilder = new StringBuilder();
            String keyStr = null;

            while (breakNow != numberOfLines) {
                inputChar = buffReader.read();
                if (inputChar == 65 || inputChar == 97 || inputChar == 102 ||
                        inputChar == 70 || inputChar == 114 || inputChar == 82) {
                    instructionsObj.setOperator((char) inputChar);
                    instructionCharRead = true;
                } else if (instructionCharRead && inputChar != 13 && inputChar != 10 && inputChar != -1) {
                    strBuilder.append((char) inputChar);
                    keyStr = strBuilder.toString();
                } else if ((instructionCharRead && (inputChar == 13 || inputChar == 10)) || inputChar == -1) {
                    // enqueue
                    instructionsObj.setKey(Integer.parseInt((keyStr)));
                    operationsQueueObj.enqueue(new instructions(instructionsObj));
                    // reset variables
                    strBuilder.delete(0, strBuilder.length());
                    instructionCharRead = false;
                    instructionsObj.setOperator('n');
                    breakNow++;
                }
                // see end -- for test codes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operationsQueueObj;
    }


    // following are test methods not included in the design:

    public static void testPrintAllChar(String filename) {
        operationsQueue operationsQueueObj = new operationsQueue(countLines(readingFile(filename)));
        try {
            // inputStream = new FileReader(filename); === readingFile(filename)
            BufferedReader buffReader = new BufferedReader(readingFile(filename));
            int inputASCIIChar = 0;
            while ((inputASCIIChar = buffReader.read()) != -1) {
                System.out.println((char) inputASCIIChar + " - " + inputASCIIChar);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
