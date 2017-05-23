package com.thedeveloperworldisyours.letters;

import java.util.Random;

/**
 * Created by javierg on 23/05/2017.
 */

public class Utils {
    public static int getRandom(int length) {
        // Get init position with random
        Random rn = new Random();
        int range = (length - 6) + 1;
        return rn.nextInt(range);

    }

    public static String getStringWith6Character(String response) {
        while (response.length() < 6) {
            StringBuilder stringBuilderLess = new StringBuilder();
            stringBuilderLess.append(response);
            stringBuilderLess.append(" ");
            response = stringBuilderLess.toString();
        }
        return response;
    }

    public static boolean hasAccent(String response) {
        char c;
        int cint;
        for (int i = 0; i < response.length() - 1; i++) {

            c = response.charAt(i + 1);
            cint = (int) c;
            if (cint > 128) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAccentFirstPosition(String response) {
        char c;
        int cint;


        c = response.charAt(0);
        cint = (int) c;
        if (cint > 128) {
            return true;
        }
        return false;
    }

    public static int getPositionAccentFirstTime(String response, int init) {
        char c;
        int cint;
        for (int i = 0; i < response.length() - 1; i++) {

            c = response.charAt(i + 1);
            cint = (int) c;
            if (cint > 128 && init - 1 == i) {
                return i;
            }
        }
        return -1;
    }
}
