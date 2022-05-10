package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
        user user1 = new user();
        user1.name = "MAD";
        user1.followed = false;
        TextView name = findViewById(R.id.textView2);
        int ran = randomOTP();
        name.setText(user1.name + " " + ran);

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
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(10000);
        return value;
    }
}