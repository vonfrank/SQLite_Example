package com.example.vonfrank.sqlite_example;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    String name;
    EditText textField;
    TextView textView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("VonFrank", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Users(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, _name VARCHAR);");

        textField = (EditText) findViewById(R.id.textField);
        textView01 = (TextView) findViewById(R.id.textView01);
    }

    public void postClick(View view) {
        name = textField.getText().toString();
        db.execSQL("INSERT INTO Users (_name) VALUES ('" + name + "');");
    }

    public void readClick(View view) {
        Cursor resultSet = db.rawQuery("SELECT * FROM Users", null);
        resultSet.moveToFirst();
        textView01.setText(resultSet.getString(1));
    }
}
