package ru.say.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Task2Activity extends AppCompatActivity {


    public class Student{
        Integer id;
        String name;
        String surname;
        String grade;
        Integer birthdayYear;
    }

    public HashMap<Integer, Student> students = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        Button showStudent = findViewById(R.id.showStudent);
        final TextView studentsList = findViewById(R.id.studentsList);
        final EditText newStudent = findViewById(R.id.newStudent);
        showStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
