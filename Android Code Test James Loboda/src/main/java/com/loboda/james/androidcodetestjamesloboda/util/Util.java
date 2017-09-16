package com.loboda.james.androidcodetestjamesloboda.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.AddContactClicks;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.AddContactViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Util {

    private static Activity context = MainActivity.mainContext;

    //toast
    public static Toast toast;
    public static View toast_view;
    public static TextView toast_textview;

    public static void setToast() {

        /** regular toast **/

        LayoutInflater inflater = context.getLayoutInflater();
        toast_view = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) context.findViewById(R.id.layout_toast_holder));

        toast_textview = (TextView) toast_view.findViewById(R.id.textview_toast);

        toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setView(toast_view);
        toast.setDuration(Toast.LENGTH_SHORT);

    }

    /**
     * Show a toast message anywhere
     * @param message
     */
    public static void showToastMessage(String message) {

        toast_textview.setText(message);
        toast.show();

    }

    /**
     * Only convert number if number length == 10
     * @param number
     * @return
     */
    public static String convertPhoneNumberToString(long number){

        String output = "";
        String numberString = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder();
        char[] digits = numberString.toCharArray();

        if (numberString.length() == 10) {

            stringBuilder.append("(");

            for (int i = 0; i < 10; i++) {

                if (i == 3) {
                    stringBuilder.append(") ");
                } else if (i == 6) {
                    stringBuilder.append("-");
                }
                stringBuilder.append(digits[i]);

            }

            output = stringBuilder.toString().trim();

        } else {
            output = numberString;
        }

        return output;

    }

    /**
     * Only convert number if number length == 10
     * @param stringNumber
     * @return
     */
    public static long convertPhoneStringToNumber(String stringNumber){

        long output = 0;

        if (stringNumber.length() == 10) {

            String regex = "[^\\d.]";
            String parsedNumber = stringNumber.replaceAll(regex, "").trim();
            output = Long.parseLong(parsedNumber);

        } else {

            output = Long.parseLong(stringNumber);

        }

        return output;
    }

    public static boolean checkIfNumeric(String stringNumber){

        boolean isNumeric = false;

        try {
            int number = Integer.parseInt(stringNumber);
            isNumeric = true;
        } catch (NumberFormatException ex) {
            isNumeric = true;
        }

        return isNumeric;

    }

    public static void setAppFullScreenStatusBar() {

        //Full screen with status bar showing
        context.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    public static void hideKeyboardEditContact(){

        hideKeyboard(EditContactViews.inputFirstName);
        hideKeyboard(EditContactViews.inputLastName);
        hideKeyboard(EditContactViews.inputBirthdayMonth);
        hideKeyboard(EditContactViews.inputBirthdayDay);
        hideKeyboard(EditContactViews.inputBirthdayYear);

    }

    public static void hideKeyboardAddContact(){

        hideKeyboard(AddContactViews.inputFirstName);
        hideKeyboard(AddContactViews.inputLastName);
        hideKeyboard(AddContactViews.inputBirthdayMonth);
        hideKeyboard(AddContactViews.inputBirthdayDay);
        hideKeyboard(AddContactViews.inputBirthdayYear);

    }

    public static void hideKeyboard(EditText view) {

        context.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //hide
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context
                .INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

        setAppFullScreenStatusBar();

    }

    public static void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    public static void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Change status bar
     *
     * @param color
     */
    public static void changeColorsStatusBar(int color) {

        //status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(context, color));
        }

    }

    /**
     * Check if a string is empty
     * @param text
     * @return
     */
    public static boolean isStringEmpty(String text) {

        boolean isEmpty = false;

        if (text != null || !text.isEmpty() || !text.equals("") || !text.equals(null)) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }

        return isEmpty;

    }

}
