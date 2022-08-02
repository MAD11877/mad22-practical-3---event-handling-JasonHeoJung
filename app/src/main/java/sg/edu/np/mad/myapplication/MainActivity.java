package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button follow = findViewById(R.id.follow);
        Button message = findViewById(R.id.message);

        user user1 = new user();
        int ran = randomOTP();
        user1.name = "MAD " + ran;
        user1.followed = false;
        TextView name = findViewById(R.id.textView2);

        name.setText(user1.name);

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
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageIntent);
            }
        });

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
}