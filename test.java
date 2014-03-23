/*
ID: richard72
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
    public static void main (String[] args) throws IOException {
        // Use BufferedReader, it's faster than RandomAccessFile
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        // Use StringTokenizer rather than readline/split -- much faster
        StringTokenizer st = new StringTokenizer(f.readLine()); // Get line, break into tokens
        int i1 = Integer.parseInt(st.nextToken());  // first integer
        int i2 = Integer.parseInt(st.nextToken());  // second integer
        out.println(i1 + i2);                       // output sum
        out.close();                                // close output file
        f.close();                                  // close bufferedreader
        System.exit(0);                             // remember to exit 0!
    }
}