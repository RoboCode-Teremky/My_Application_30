package com.example.myapplication30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private String TAG = "My_log";
    private int score = 0; //поточний рахунок
    private int oldRecord=10; //рекорд

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Verbose message"); //багатослівне повідомлення
        Log.d(TAG, "Debug message"); //повідомлення для дебагінгу
        Log.i(TAG, "Info message"); //інформація
        Log.w(TAG, "Warning message"); //попередження
        Log.e(TAG, "Error message"); //помилка

        //Задаємо об'єкти для керування інтерфейсом
        textView = findViewById(R.id.button); //щось тут не так...
        button = findViewById(R.id.text_view);

        textView.setText(getString(R.string.score_text, score)); //задаємо початковий текст

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=3;
                textView.setText(getString(R.string.score_text, score));
                checkRecord(score); //викликаємо для перевірки рекорду окремий метод
            }
        });
    }

    private void checkRecord(int newRecord){
        if(newRecord==oldRecord) { //обережно з умовою
            Toast.makeText(this, "New Record", Toast.LENGTH_SHORT).show();
        }
    }
}