package com.udacity.gradle.builditbigger;

import android.os.Handler;
import android.os.Looper;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndPointTest {

    @Test
    public void nonNullAsyncTask() {

        String response;
        EndPointAsyncTask asyncTask = new EndPointAsyncTask();
        asyncTask.execute();

        try {
            response = asyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            response = null;
        }

        final String finalResponse = response;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        assertNotNull(finalResponse);
                    }
                }, 1000);
            }
        }).run();
    }
}
