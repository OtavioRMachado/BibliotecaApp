package com.thoughtworks.university.Biblioteca;

import org.omg.CORBA.DynAnyPackage.Invalid;

public abstract class Command {
    public abstract void execute() throws BookNotAvailableException;

}
