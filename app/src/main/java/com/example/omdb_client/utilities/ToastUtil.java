package com.example.omdb_client.utilities;

import android.content.Context;
import android.widget.Toast;

public final class ToastUtil {

    public static void toastLong(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
