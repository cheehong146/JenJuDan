package com.itparadise.jenjudan.user.base.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

//import com.itparadise.jenjudan.user.utils.Constants;
//import com.itparadise.jenjudan.user.utils.DateTimeParser;

import java.security.MessageDigest;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * All operation related function declare here
 * Created by Gimon on 3/17/2018.
 */

public class FunctionHelper {
    Activity activity;

    public FunctionHelper(Activity activity) {
        this.activity = activity;
    }

    /**
     * Start Activity quick shortcut
     *
     * @param c
     */
    public void startActivityQuick(Class c) {
        Intent next = new Intent(activity, c);
        activity.startActivity(next);
        activity.finish();
    }

    /**
     * Start Activity without close current
     *
     * @param c
     */
    public void startActivityWithoutCloseCurrent(Class c) {

        Intent nextIntent = new Intent(activity, c);
        activity.startActivity(nextIntent);
    }

    /**
     * Hide Keyboard function using view
     *
     * @param view
     */
    public void hideKeyboard(View view) {
        try {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Shortcut to get edit text text
     *
     * @param t
     * @return
     */
    /*
    public String getEditText(EditText t) {
        if (t.getText() != null && t.getText().toString().trim().length() > 0 && !t.getText().toString().trim().equalsIgnoreCase(Constants.EMPTY_TEXT)) {
            return t.getText().toString().trim();
        } else
            return null;
    }
*/
    /**
     * Check email validation
     *
     * @param email
     * @return
     */
    public boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        return matcher.matches();
    }

    /**
     * Get device id function
     *
     * @return
     */
    public String getDeviceID() {
        String deviceId = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceId;
    }


    /**
     * Check is it connected to network
     *
     * @param context
     * @return
     */
    public boolean isOnline(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * get width based on screen size
     *
     * @param context
     * @return
     */
    public int getWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;
    }

    /**
     * get height based on screen size
     *
     * @param context
     * @return
     */
    public int getHeight(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;

        return height;
    }

    /**
     * set width based
     *
     * @param layout
     * @param width
     */
    public void setWidth(View layout, double width) {
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.width = (int) width;
    }

    /**
     * Show dialog function
     *
     * @param fragmentManager
     * @param dialogName
     * @param fragment
     */
    public void showDialogFragment(FragmentManager fragmentManager, String dialogName, DialogFragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(fragment, dialogName);
        ft.commit();
    }

    /**
     * convert the value to dp for set the  value to margin or padding
     *
     * @ size to convert and context
     */
    public float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    /**
     * convert the value to pixles from dp
     *
     * @param dp
     * @return
     */
    public float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    /**
     * load facebook key hash
     */
    public void logKeyHashFB() {
        try {
            PackageInfo info = activity.getPackageManager().getPackageInfo(
                    activity.getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());

                Log.e("FB KEY", "MyActivity onCreate : " + Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * load a url by opening the default browser on the device (this will bring the user out of the app and to the browser)
     *
     * @param url     the url to be loaded in the browser
     * @param context cur context
     */
    public void goToUrl(String url, Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    /**
     * generate OrderId for Order API, from concat userId + cur datetime(yyyyMMddHHmmss)
     * (userId)(yyyyMMddHHmmss)
     *
     * @param userId
     * @return
     */
    /*
    public String generateOrderId(String userId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(userId);

        Date curDate = new Date();
        stringBuilder.append(DateTimeParser.parse_eGHL_dateTime(curDate));
        return stringBuilder.toString();
    }
*/
}
