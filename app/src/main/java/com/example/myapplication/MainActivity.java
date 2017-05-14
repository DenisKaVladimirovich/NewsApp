package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Person> persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(llm);
        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

    }
    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", "http://icons.iconarchive.com/icons/graphicloads/flat-finance/256/person-icon.png"));
        persons.add(new Person("Lavery Maiss", "25 years old", "http://icons.iconarchive.com/icons/graphicloads/flat-finance/256/person-icon.png"));
        persons.add(new Person("Lillie Watts", "35 years old", "http://icons.iconarchive.com/icons/graphicloads/flat-finance/256/person-icon.png"));
    }
    public static Person getPerson(int id)
    {
        return persons.get(id);
    }

}


class Person {
    String name;
    String age;
    String photoId;
    Person(String name, String age, String photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }
}







