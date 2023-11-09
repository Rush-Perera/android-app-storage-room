package lk.rush.internaldatabaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

//                List<User> all = userDao.getAll();
//
//                all.forEach(u->{
//                    Log.i(TAG,u.toString());
//                });

                //This will crash THreads intercepting (UI AND WORKING THREADS)
                User user = userDao.getById(0);
//
//                TextView view = findViewById(R.id.text);
//                view.setText(user.getFirstName());

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        TextView view = findViewById(R.id.text);
//                        view.setText(user.getFirstName());
//                    }
//                });


                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TextView view = findViewById(R.id.text);
                        view.setText(user.getFirstName());
                    }
                }, 5000);
            }

        }).start();




    }
}