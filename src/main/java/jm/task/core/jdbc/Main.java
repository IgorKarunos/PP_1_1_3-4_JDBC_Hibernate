package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

        //Создание таблицы
        userDao.createUsersTable();

        //Добавление 4 пользователей
        userDao.saveUser("Ivan", "Ivanov", (byte) 30);
        userDao.saveUser("Petr", "Petrov", (byte) 25);
        userDao.saveUser("Sidor", "Sidorov", (byte) 40);
        userDao.saveUser("Anna", "Smirnova", (byte) 20);

        //Получение всех пользователей
        System.out.println("Список пользователей:");
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        //Удаление пользователя по ID (например, удалим Petr с id = 2)
        userDao.removeUserById(2);

        //Повторный вывод списка (должно быть 3 пользователя)
        System.out.println("После удаления пользователя с id = 2:");
        users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        //Очистка таблицы
        userDao.cleanUsersTable();

        //Удаление таблицы
        userDao.dropUsersTable();
    }
}
