package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    private static final User user1 = new User("Ivan", "Petrov", (byte) 30);
    private static final User user2 = new User("Petr", "Ivanov", (byte) 18);
    private static final User user3 = new User("John", "Smith", (byte) 46);
    private static final User user4 = new User("Harry", "Potter", (byte) 52);
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }

    public static void daoJDBCImplTest() {
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
