package com.kreitek.editor;

import com.kreitek.editor.Format.Format;
import com.kreitek.editor.Format.FormatFactory;
import com.kreitek.editor.Format.FormatSelection;
import com.kreitek.editor.commands.CommandFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";

    private final CommandFactory commandFactory = new CommandFactory();
    private ArrayList<String> documentLines = new ArrayList<String>();

    @Override
    public void run(String[] args) {

        boolean exit = false;

        while (!exit) {

            String commandLine = waitForNewCommand();

            try {

                Command command = commandFactory.getCommand(commandLine);

                command.execute(documentLines);

            } catch (BadCommandException e) {

                printErrorToConsole("THERE IS A ERROR IN THE COMMAND");

            } catch (ExitException e) {

                exit = true;
            }
            try{

                FormatSelection formatSelection = new FormatSelection();

                FormatFactory factory = (FormatFactory) formatSelection.getFormat(args[0]);

                Format format = factory.showDocumentLines(documentLines);

            }catch (BadFormatException e){

                printErrorToConsole("PLEASE CHECK THE COMMAND");
            }

            showHelp();
        }
    }

    private String waitForNewCommand() {
        printToConsole("PLEASE ENTER A COMMAND : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("  ADD LINE -> a \"your text\"");
        printLnToConsole("  UPDATE LINE  -> u [line number] \"your text\"");
        printLnToConsole("  DELETE LINE  -> d [line number]");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }

    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }

    private void printToConsole(String message) {
        System.out.print(message);
    }

}
