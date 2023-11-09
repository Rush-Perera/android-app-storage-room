package lk.rush.internaldatabaseroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import lk.rush.internaldatabaseroom.entity.User;

@Dao
public interface UserDao {

    @Insert
    long insert(User user);

    @Insert
    long[] insertAll(User... user);

    @Update
    int update(User user);

    @Delete
    int delete(User user);


}
