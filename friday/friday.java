
/*
ID: richard72
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int N = Integer.parseInt(in.readLine());       // Number of years to check
        List<Integer> thirteenths = Arrays.asList(0, 0, 0, 0, 0, 0, 0);  // Histogram of weekdays
        final int THIRTEENTH_SHIFT = 12 % 7;    // I know it's just 5, but I like it this way
        int old = 0;                            // Holds old value of thirteenths index

        int day_index = 2;      // Start off on Monday, January 1, 1900
        String[] days_of_week = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                                // List of days of week (not really used, just here for reference)
        List<Integer> days_in_months = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
                                // List of number of days in each month

        /* Iterate through years */
        for (int i = 1900; i < (1900 + N); i++) {
            /* Figure out length of February */
            if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) {
                days_in_months.set(1, 29);
            } else {
                days_in_months.set(1, 28);
            }

            /* Iterate through months */
            for (int j = 0; j < 12; j++) {
                /* Check 13th of current month: shift day index by 12 */
                day_index += THIRTEENTH_SHIFT;
                if (day_index > 6) {
                    day_index -= 7;
                }
                old = thirteenths.get(day_index);
                thirteenths.set(day_index, old + 1);
                /* Shift to first day of next month */
                day_index += (days_in_months.get(j) - THIRTEENTH_SHIFT) % 7;
                if (day_index > 6) {
                    day_index -= 7;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            out.print(thirteenths.get(i));
            if (i < 6) {
                out.print(' ');
            } else {
                out.print('\n');
            }
        }
        
        in.close();
        out.close();
        System.exit(0);
    }
}