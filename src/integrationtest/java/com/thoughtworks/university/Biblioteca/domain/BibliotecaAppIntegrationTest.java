package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppIntegrationTest {
    private ByteArrayOutputStream myOut;
    private ByteArrayOutputStream myErr;
    private InputStream newIn;
    private String simulatedUserInput;
    private String quitCommand;
    private String validLoginCommand;
    private String invalidLoginCommand;
    private String invalidCommand;
    private final String EOL = System.getProperty("line.separator");

    @Before
    public void setUp() {
        myOut = new ByteArrayOutputStream();
        myErr = new ByteArrayOutputStream();
        quitCommand = "quit";
        validLoginCommand = "login 123-4567 12345";
        invalidLoginCommand = "login 123 123";
        invalidCommand = "ugabuga";
    }
    @Test
    public void shouldShowMeMyWelcomeMessageAndQuit() throws UserNotLoggedInException, LibraryItemNotAvailableException, IOException {
        newIn = new ByteArrayInputStream(quitCommand.getBytes());

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);

        assertEquals("Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS\n" +
                "Goodbye!\n", myOut.toString());
    }

    @Test
    public void shouldShowMeAListOfBooks() throws UserNotLoggedInException, LibraryItemNotAvailableException, IOException {
        simulatedUserInput = "list books" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("available books"));
    }

    @Test
    public void shouldShowMeTheMainMenu() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = "options" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("Menu commands"));
    }

    @Test
    public void shouldShowMeInvalidOption() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = invalidCommand + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("Invalid command"));
    }

    @Test
    public void shouldShowMeSuccessfulCheckoutMessage() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = validLoginCommand + EOL + "checkout " + LibraryItem.idCounter + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("Enjoy the Book"));
    }

    @Test
    public void shouldShowMeFailingCheckoutMessage() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = validLoginCommand + EOL + "checkout 1" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("not available"));
    }

    @Test
    public void shouldShowMeSuccessfulReturnMessage() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = validLoginCommand + EOL + "checkout " + LibraryItem.idCounter + EOL +
                "return " + LibraryItem.idCounter + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("for returning"));
    }

    @Test
    public void shouldShowMeFailingReturnMessage() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = validLoginCommand + EOL + "return 0" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(newIn);
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        BibliotecaApp.main(null);

        assertTrue(myOut.toString().contains("not available"));
    }

    @Test
    public void shouldShowMeAListOfMovies() throws UserNotLoggedInException, LibraryItemNotAvailableException, IOException {
        simulatedUserInput = "list movies" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("available Movies"));
    }

    @Test
    public void shouldShowMeMyProfileWhenImLoggedIn() throws UserNotLoggedInException, LibraryItemNotAvailableException, IOException {
        simulatedUserInput = validLoginCommand + EOL + "profile" + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("Name:"));
    }

    @Test
    public void shouldLoginProperly() throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        simulatedUserInput = validLoginCommand + EOL + quitCommand + EOL;
        newIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);
        assertTrue(myOut.toString().contains("Logged In"));
    }
}
