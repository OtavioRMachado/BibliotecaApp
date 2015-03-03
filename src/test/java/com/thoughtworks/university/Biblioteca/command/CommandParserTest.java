package com.thoughtworks.university.Biblioteca.command;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CommandParserTest {
    private CommandParser commandParser;

    @Before
    public void setup() {
        Map<String, ParserCommand> rulesMapping = new HashMap<String, ParserCommand>();
        rulesMapping.put("quit", new QuitParser());
        rulesMapping.put("options", new OptionsParser());
        rulesMapping.put("return", new ReturnParser());
        rulesMapping.put("checkout", new CheckoutParser());
        rulesMapping.put("list books", new ListBooksParser());
        rulesMapping.put("login", new LoginParser());
        rulesMapping.put("list movies", new ListMoviesParser());
        rulesMapping.put("profile", new ProfileParser());
        commandParser = new CommandParser(rulesMapping);

    }

    @Test
    public void shouldReturnInvalidCommand() {
        assertTrue(commandParser.parse("ugabuga") instanceof InvalidCommand);
    }

    @Test
    public void shouldReturnOptionsCommand() {
        assertTrue(commandParser.parse("options") instanceof OptionsCommand);
        assertTrue(commandParser.parse("OPTIONS") instanceof OptionsCommand);
    }

    @Test
    public void shouldReturnQuitCommand() {
        assertTrue(commandParser.parse("quit") instanceof QuitCommand);
        assertTrue(commandParser.parse("QUIT") instanceof QuitCommand);
    }

    @Test
    public void shouldReturnReturnBookCommand() {
        assertTrue(commandParser.parse("return 1") instanceof ReturnItemCommand);
    }

    @Test
    public void shouldReturnCheckoutCommand() {
        assertTrue(commandParser.parse("CheckOut 1") instanceof CheckoutCommand);
    }

    @Test
    public void shouldReturnListBooksCommand() {
        assertTrue(commandParser.parse("list books") instanceof ListBooksCommand);
    }

    @Test
    public void shouldReturnLoginCommand() {
        assertTrue(commandParser.parse("login 123-4567 12345") instanceof LoginCommand);
    }

    @Test
    public void shouldReturnListMoviesCommand() {
        assertTrue(commandParser.parse("list movies") instanceof ListMoviesCommand);
    }

    @Test
    public void shouldReturnUserProfileCommand() {
        assertTrue(commandParser.parse("profile") instanceof UserProfileCommand);
    }
}
