package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Vanya", "Ivanov", (byte) 18);
        userService.saveUser("Kirill", "Petrov", (byte) 19);
        userService.saveUser("Leo", "Baranov", (byte) 20);
        userService.saveUser("Timur", "Bond", (byte) 21);

        List<User> userList = userService.getAllUsers();
        if (userList != null) {
            userList.forEach(System.out::println);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
