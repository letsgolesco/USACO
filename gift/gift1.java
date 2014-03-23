/*
ID: richard72
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {

    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        // Variables to be reused for each giver
        String name;
        String moneyAndNG;
        String[] parts;
        int money;
        int given;
        int received;
        int gift;
        int remainder;
        int NG;
        String recipient;

        // Data structures to access info for each giver
        int NP = Integer.parseInt(f.readLine());        // Number of givers
        List<String> givers = new ArrayList<String>();  // List of giver names
        Map<String, Integer> giversToGiven = new HashMap<String, Integer>();
                                                        // Map givers to their money
        Map<String, Integer> giversToReceived = new HashMap<String, Integer>();
                                                        // Map givers to money they receive
        Map<String, Integer> giversToNG = new HashMap<String, Integer>();
                                                        // Map givers to their NG
        Map<String, List<String>> giversToRecipients = new HashMap<String, List<String>>();
                                                        // Map giver names to their recipients
        // Get giver names from input file
        for (int i = 0; i < NP; i++) {
            givers.add(f.readLine());
        }
        // Get other giver info
        for (int i = 0; i < NP; i++) {
            List<String> recipients = new ArrayList<String>();
            name = f.readLine();                        // Name of current giver
            moneyAndNG = f.readLine();                  // String with money & NG
            parts = moneyAndNG.split(" ");              // Split money & NG
            money = Integer.parseInt(parts[0]);         // Initial money of current giver
            NG = Integer.parseInt(parts[1]);            // NG of current giver
            // Get recipients of current giver
            for (int j = 0; j < NG; j++) {
                recipient = f.readLine();
                recipients.add(recipient);
            }
            giversToGiven.put(name, money);
            giversToReceived.put(name, 0);
            giversToNG.put(name, NG);
            giversToRecipients.put(name, recipients);
        }
        // Give away the gifts
        for (int i = 0; i < NP; i++) {
            List<String> recipients = new ArrayList<String>();
            name = givers.get(i);
            money = giversToGiven.get(name);
            NG = giversToNG.get(name);
            if (NG > 0) {
                gift = money / NG;
                remainder = money % NG;
                giversToGiven.put(name, money - remainder);
                recipients = giversToRecipients.get(name);
                for (int j = 0; j < NG; j++) {
                    recipient = recipients.get(j);
                    received = giversToReceived.get(recipient);
                    received = received + gift;
                    giversToReceived.put(recipient, received);
                }
            } else {
                giversToGiven.put(name, 0);
            }
        }
        // Tally up net money for each giver
        for (int i = 0; i < NP; i++) {
            name = givers.get(i);
            given = giversToGiven.get(name);
            received = giversToReceived.get(name);
            out.print(name + " " + (received - given) + "\n");
        }

        // Close out and exit
        out.close();                                    // close output file
        f.close();                                      // close bufferedreader
        System.exit(0);                                 // remember to exit 0!
    }
}