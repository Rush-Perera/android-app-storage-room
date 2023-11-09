package lk.rush.internaldatabaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import lk.rush.internaldatabaseroom.dao.UserDao;
import lk.rush.internaldatabaseroom.entity.User;
import lk.rush.internaldatabaseroom.util.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase appDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_db").build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDao userDao = appDb.userDao();

                User user = new User();
                user.setFirstName("Achintha");
                user.setLastName("Silva");
                user.setEmail("achintha@silva.com");
                user.setContact("0712345678");

                userDao.insert(user);
            }
        });

    }
}