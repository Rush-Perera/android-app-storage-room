package lk.rush.internaldatabaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import lk.rush.internaldatabaseroom.dao.UserDao;
import lk.rush.internaldatabaseroom.entity.User;
import lk.rush.internaldatabaseroom.util.AppDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase appDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_db").build();

                UserDao userDao = appDb.userDao();
//
//                User user = new User();
//                user.setFirstName("Achintha");
//                user.setLastName("Silva");
//                user.setEmail("achintha@silva.com");
//                user.setContact("0712345678");
//
//                userDao.insert(user);
//                Log.i(TAG,"User Added");

                List<User> all = userDao.getAll();

                all.forEach(u->{
                    Log.i(TAG,u.toString());
                });
            }
        }).start();

        Log.i(TAG,"New Tag");


    }
}