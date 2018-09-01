package com.udacity.gradle.builditbigger;

import java.util.Random;

public class JokeGenerator {
    private String[] jokesList = new String[]{
            "Q. Why did the banker lose his job?\n"
                    + "A. He lost interest!",

            "Q. What did the baby corn say to the mama corn?\n"
                    + "A. Where is popcorn?",

            "Q. Why did the picture go to jail?\n"
                    + "A. Because it was framed.",

            "Q. What did the hamburger name his daughter?\n"
                    + "A. Patty!",

            "Q. How did the hipster burn his mouth?\n"
                    + "A. He ate the pizza before it was cool.",

            "I waited and stayed up all night to try and figure out where the sun was.\n"
                    + "Then it dawned on me!",

            "Sometimes I tuck my knees into my chest and lean forward.\n"
                    + "That's just how I roll.",

            "Q. Which baseball players holds water?\n"
                    + "A. The pitcher."
    };

    public String getJoke() {
        Random random = new Random();
        return jokesList[random.nextInt(jokesList.length)];
    }
}