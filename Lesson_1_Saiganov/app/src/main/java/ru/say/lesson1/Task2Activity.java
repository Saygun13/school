package ru.say.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

//TODO Обработка нажатия кнопки на клавиатуре и перенесение сохранения объекта студента
//TODO Проверка года рождения на "не цифры". Красивый вывод в текствью. Понятная подсказка инпута

public class Task2Activity extends AppCompatActivity {


    public class Student {
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
        //Пока реализованно в одной кнопке. С событием клавиатуры пока не разобрался
        showStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Создание и сохранения объекта студент
                Student student = new Student();

                student.id = Math.toIntExact(System.currentTimeMillis() % Integer.MAX_VALUE);
                String string = newStudent.getText().toString().trim();
                String[] parts = string.split(" ");

                if (parts.length != 4) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Введены некорректные данные", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    student.name = parts[0];
                    student.surname = parts[1];
                    student.grade = parts[2];
                    student.birthdayYear = Integer.parseInt(parts[3]);
                    students.put(student.id, student);
                    newStudent.setText("");

                    studentsList.setText("");
                    for (Student value : students.values())
                        studentsList.append(value.name + " " + value.surname + " " + value.grade + " " + value.birthdayYear + "\n");

                }
            }
        });
    }
}
