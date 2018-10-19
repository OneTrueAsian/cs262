package edu.calvin.cs262.jjf25.Homework02;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {

    // Variable that stores the search string.
    private String mQueryString;

    // Constructor providing a reference to the search term.
    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }


    @Override
    protected void onStartLoading() {
        forceLoad(); // Starts the loadInBackground method
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}