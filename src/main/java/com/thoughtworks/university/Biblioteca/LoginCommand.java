package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class LoginCommand extends Command {
    protected static final String commandName = "login";
    private final String libraryNo;
    private final String password;
    private User loggedUser;
    private final static String LOGIN_SUCCESS = "You are now Logged In!";
    private final static String LOGIN_FAIL = "There was an error logging in.";
    public LoginCommand(String libraryNo, String password) {
        this.libraryNo = libraryNo;
        this.password = password;
    }

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        loggedUser = UsersHandler.log(libraryNo, password);
<<<<<<< HEAD
        return loggedUser.getLibraryNo() == ""? LOGIN_FAIL : LOGIN_SUCCESS;
=======
        return loggedUser == null? LOGIN_FAIL : LOGIN_SUCCESS;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        String result = execute();
<<<<<<< HEAD
        if(result == LOGIN_SUCCESS) {
            loggedUser.setName(this.loggedUser.getName());
            loggedUser.setPhone(this.loggedUser.getPhone());
            loggedUser.setLibraryNo(this.loggedUser.getLibraryNo());
            loggedUser.setEmail(this.loggedUser.getEmail());
            activateProfileOption(menuItems);
        }
        return result;
    }

    private void activateProfileOption(List<String> menuItems) {
        if(!menuItems.contains(UserProfileCommand.getCommandName())) {
            menuItems.add(UserProfileCommand.getCommandName());
        }
        return;
    }

=======
        loggedUser.setName(this.loggedUser.getName());
        loggedUser.setPhone(this.loggedUser.getPhone());
        loggedUser.setLibraryNo(this.loggedUser.getLibraryNo());
        loggedUser.setEmail(this.loggedUser.getEmail());
        return result;
    }

>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    public static String getCommandName() {
        return commandName;
    }
}
