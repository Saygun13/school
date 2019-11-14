package ru.say.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Edits;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.TreeSet;

//TODO скрывать клавиатуру при выводе списка, возможно стоит добавить кнопку очистки текствью, доработать верстку, добавить скролл на экран, сделать нормальную валидацию и ошибки и ещё многое, многое другое

public class Task1Activity extends AppCompatActivity {

    public TreeSet studentList = new TreeSet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        Button addStudent = findViewById(R.id.addStudent);
        Button showStudent = findViewById(R.id.showStudent);
        final TextView students = findViewById(R.id.studentsList);
        final EditText newStudent = findViewById(R.id.newStudent);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!newStudent.getText().toString().isEmpty())
                    studentList.add(newStudent.getText().toString().trim());
                newStudent.setText("");
            }

        });

        showStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String std = new String();
                final Iterator<String> itr = studentList.iterator();


                while (itr.hasNext()) {
                    std += itr.next() + "\n";
                }
                if (std.isEmpty())
                    students.setText("Здесь ничего нет...");
                else
                    students.setText(std);
            }
        });

    }
}



