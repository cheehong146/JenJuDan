package com.itparadise.jenjudan.user.base.helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by IT Paradise on 4/4/2019
 **/
public class DialogHelper {
    /**
     * show a dialog displaying a msg with a dismissible button,
     * @param context
     * @param title
     * @param msg
     */
    public static void showDismissDialog(Context context, String title, String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title);
        builder.setMessage(msg);

        builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        final Dialog dialog = builder.create();
        dialog.show();
    }
}
