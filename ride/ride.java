/*
ID: richard72
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String cometName = f.readLine();  // comet name
        String groupName = f.readLine();  // group name
        int cometNumber = 1;                // number value for comet
        int groupNumber = 1;                // number value for group

        // Convert comet name to number
        for (char c : cometName.toCharArray()) {
            cometNumber = cometNumber * (c - 'A' + 1);
        }
        
        // Convert group name to number
        for (char c : groupName.toCharArray()) {
            groupNumber = groupNumber * (c - 'A' + 1);
        }

        // Tell whether the group is being picked up!
        if (cometNumber % 47 == groupNumber % 47) {
            out.print("GO\n");
        } else {
            out.print("STAY\n");
        }

        out.close();                        // close output file
        f.close();                          // close bufferedreader
        System.exit(0);                     // remember to exit 0!
    }
}