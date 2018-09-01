package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.builditbigger.JokeGenerator;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private JokeGenerator jokeGenerator;

    MyBean() {
        jokeGenerator = new JokeGenerator();
    }

    public String getJoke() {
        return jokeGenerator.getJoke();
    }
}