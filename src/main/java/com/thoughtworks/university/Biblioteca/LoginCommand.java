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
        return loggedUser.getLibraryNo() == ""? LOGIN_FAIL : LOGIN_SUCCESS;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        String result = execute();
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

    public static String getCommandName() {
        return commandName;
    }
}
