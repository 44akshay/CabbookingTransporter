package com.example.user.cabbookingtransporter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22/07/2018.
 */

public class adapter extends ArrayAdapter {
    public adapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<cardetails> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
