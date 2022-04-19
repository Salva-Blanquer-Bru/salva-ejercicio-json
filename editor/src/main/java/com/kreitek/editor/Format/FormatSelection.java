package com.kreitek.editor.Format;

import com.kreitek.editor.BadFormatException;

public class FormatSelection {
    public Object getFormat(String type) throws BadFormatException{

        switch (type){

            case "DOC":

                return new FormatText();

            case "JSON":

                return new FormatJson();

            default:

                throw new BadFormatException();
        }
    }
}
