package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.util.*;
public class Functions {
    /**
     * Show a info message panel.
     * @param str The information string needs to show.
     */
    public static void showInfoMsg(String str) {
        JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Convert a string of integer to a int type.
     * @param str The str need rto be converted.
     * @return  The integer value the string represents.
     */
    public static int convertToInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
        return Integer.parseInt(str);
    }
}
