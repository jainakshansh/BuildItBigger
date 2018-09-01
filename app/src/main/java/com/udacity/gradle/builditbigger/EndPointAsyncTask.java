package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myJokesApi.MyJokesApi;
import com.udacity.gradle.builditbigger.backend.myJokesApi.model.MyBean;
import com.udacity.gradle.joketeller.JokeActivity;

import java.io.IOException;

public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyJokesApi myJokesApi = null;
    private Context context;
    private static final String JOKE_KEY = "JOKE";

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if (myJokesApi == null) {
            MyJokesApi.Builder builder = new MyJokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myJokesApi = builder.build();
        }

        context = pairs[0].first;

        try {
            MyBean myBean = myJokesApi.putJoke().execute();
            return myBean.getJoke();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_KEY, response);
        context.startActivity(intent);
    }
}
