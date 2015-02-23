package com.thoughtworks.university.Biblioteca;

public class LineReader {
    protected String line;
    public LineReader() {

    }
    public String readLine() {
        line = System.console().readLine();
        return line;
    }
}
