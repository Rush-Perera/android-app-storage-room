package lk.rush.internaldatabaseroom.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import lk.rush.internaldatabaseroom.dao.UserDao;
import lk.rush.internaldatabaseroom.entity.User;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
