package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button follow = findViewById(R.id.follow);
        user user1 = new user();
        user1.followed = false;

        follow.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
                if (!user1.followed){
                    follow.setText("unfollow");
                    user1.followed = true;
                    Toast.makeText(getApplicationContext(),
                            "followed",
                            Toast.LENGTH_LONG)
                            .show();
                }
                else {
                    follow.setText("follow");
                    user1.followed = false;
                }
            }

        });
    }
}