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
     * Convert some predefined color string to color objects.
     * @param obj The given string of a color.
     * @return  The color object of the given string represent.
     */
    public static Color strToColor(Object obj) {
        String str = (String) obj;
        switch (str) {
            case "Color.WHITE":
                return Color.WHITE;
            case "Color.BLACK":
                return Color.black;
            case "Color.BLUE":
                return Color.BLUE;
            case "Color.RED":
                return Color.RED;
            case "Color.YELLOW":
                return Color.YELLOW;
            case "Color.GREEN":
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
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
