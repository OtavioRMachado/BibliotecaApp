package com.thoughtworks.university.Biblioteca.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StreamControl {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;

    public void setUpOut() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void setUpIn(String in) {
        inContent = new ByteArrayInputStream(in.getBytes());
        System.setIn(inContent);
    }

    public String getOutput() {
        return outContent.toString();
    }
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}
