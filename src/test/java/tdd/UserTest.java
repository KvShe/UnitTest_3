package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User userTrue;
    User userFalse;
    UserRepository userRepository;
    @BeforeEach
    void SetUp() {
        userTrue = new User("login", "password");
        userFalse = new User("l", "p");
        userRepository = new UserRepository();
    }
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    @Test
    void userCreationSuccess() {
        assertTrue(userTrue.verification("login", "password"));
    }

    @Test
    void userCreationUnSuccess() {
        assertFalse(userFalse.verification("login", "password"));
    }

    /**
     * Доделать задание 7 с семинара
     * <p>
     * Нужно добавить класс UserRepository
     * <p>
     * В метод addUser передаёзся user если он зарегестрирован, то он попадает в список пользователей системы
     */
    @Test
    void testAddUserTrue() {
        assertTrue(userRepository.addUser(userTrue));
    }

    @Test
    void testAddUserFalse() {
        assertFalse(userRepository.addUser(userFalse));
    }

    /**
     * Добавить возможность наделять админскими правами пользователя (User),
     * добавить функцию в UserRepository (TDD), которая будет разлогинивать всех пользователей, кроме админов
     */
    @Test
    void testNonAdminDecomposition() {
        UserRepository userRepository = new UserRepository();

        userTrue.setStatus(Status.ADMIN);
        userRepository.addUser(userTrue);
        userRepository.addUser(userFalse);
        userRepository.nonAdminDecomposition();

        for (User user : userRepository.getUsers()) {
            assertEquals(user.getStatus(), Status.ADMIN);
        }
    }
}
