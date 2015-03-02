package com.thoughtworks.university.Biblioteca.domain;

/*
 * Responsibility: Objeto criado para mostrar que o usuário utilizando o sistema não está logado.
 */
public class AnonymousUser extends User {
    public AnonymousUser() {
        super("", "", "", "");
    }
}
