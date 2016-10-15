package com.mdb.sirjan.easqlite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mdb.easqlitelib.*;
import com.mdb.easqlitelib.exceptions.InvalidTypeException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textViewColumn;
    private TextView textViewRow;
    private EditText editTextColumn;
    private EditText editTextRow;
    private Button addColumn;
    private Button addRow;
    private List<String> columnList;
    private List<String> rowList;
    private String TABLE_NAME = "Test Table";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EaSQLite.createTable(TABLE_NAME);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewColumn = (TextView) findViewById(R.id.textViewColumn);
        textViewRow = (TextView) findViewById(R.id.textViewRow);
        editTextColumn = (EditText) findViewById(R.id.editTextColumn);
        editTextRow = (EditText) findViewById(R.id.editTextRow);
        addColumn = (Button) findViewById(R.id.buttonColumn);
        addColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                columnList.add(editTextColumn.getText().toString());
                textViewColumn.setText(textViewColumn.getText().toString() + " " + editTextColumn.getText().toString());
                try{
                EaSQLite.addColumn(TABLE_NAME, editTextColumn.getText().toString(), "String");}
                catch (InvalidTypeException e){
                    System.out.println(e);
                }
            }
        });
        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowList.add(editTextRow.getText().toString());
                textViewRow.setText(textViewRow.getText().toString() + " " + editTextRow.getText().toString());

            }
        });


    }
    private void refreshStuff(){
    }
}
