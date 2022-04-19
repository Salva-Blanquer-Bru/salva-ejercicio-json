package com.kreitek.editor.Format;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FormatJson implements FormatFactory {

    @Override
    public Format showDocumentLines(@NotNull ArrayList<String> lines) {

        if (lines.size() > 0){

            printLnToConsole("{");

            printLnToConsole(" \"DOC\":[");

            for (int index = 0; index < lines.size(); index++) {

                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append("  {\"LINE\":\"");

                stringBuilder.append(index);

                stringBuilder.append("\",\"TEXT\":\"");

                stringBuilder.append(lines.get(index));

                stringBuilder.append("\"}");

                if(index < lines.size()-1){

                    stringBuilder.append(",");
                }
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole(" ]");

            printLnToConsole("}");
        }
        return null;
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }
}
