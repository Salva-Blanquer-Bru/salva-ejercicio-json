package com.kreitek.editor.Format;

import java.util.ArrayList;

public class FormatText implements FormatFactory {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_CYAN = "\u001B[36m";


    @Override
    public Format showDocumentLines(ArrayList<String> lines) {

        if (lines.size() > 0){

            setTextColor(TEXT_CYAN);

            printLnToConsole("THE DOCUMENT HAS BEEN STARTED ==>");

            for (int index = 0; index < lines.size(); index++) {

                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append("[");

                stringBuilder.append(index);

                stringBuilder.append("] ");

                stringBuilder.append(lines.get(index));

                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole("<== THE DOCUMENT HAS BEEN ENDED");

            setTextColor(TEXT_RESET);
        }
        return null;
    }

    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }

}
