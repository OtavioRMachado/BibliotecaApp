package com.thoughtworks.university.Biblioteca.command;

import java.util.Map;
import java.util.Set;

/*
 * Responsibility: Defines what command has been written by the user.
 */
public class CommandParser {
    private Map<String, ParserCommand> rulesMapping;

    public CommandParser(Map<String, ParserCommand> rulesMapping) {
        this.rulesMapping = rulesMapping;
    }

    public Command parse(String line) {
        Set<Map.Entry<String, ParserCommand>> rules = rulesMapping.entrySet();

        for (Map.Entry<String, ParserCommand> rule : rules) {
            String commandName = rule.getKey();

            if (line.toLowerCase().contains(commandName)) {
                ParserCommand parserCommand = rule.getValue();
                return parserCommand.execute(line);
            }
        }

        return new InvalidCommand();
    }
}
