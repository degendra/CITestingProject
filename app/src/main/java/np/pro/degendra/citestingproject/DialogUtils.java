package np.pro.degendra.citestingproject;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bajra on 1/13/15.
 */
public class DialogUtils {

    public static void showAlertDialog(Context context, String title, String message) {
        styleDialog(new AlertDialog.Builder(context).setTitle(title).setMessage(message).setPositiveButton("OK", null).show());
    }

    public static void showAlertDialogOk(Context context, String title, String message, final OnDialogClick onDialogClick) {
        AlertDialog dialog = new AlertDialog
                .Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();

        dialog.show();
        styleDialog(dialog);
    }

    public static void showAlertDialog(Context context, String title, String message, final OnDialogClick onDialogClick) {
        AlertDialog dialog = new AlertDialog
                .Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogClick.onDialogOkClick();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogClick.onDialogCancelClick();
                    }
                }).create();

        dialog.show();
        styleDialog(dialog);
    }

    public static ProgressDialog showProgressDialog(Activity context, String title, String message) {
        ProgressDialog progressDialog = showProgressDialog(context, title, message, true);
//        styleDialog(progressDialog);
        return progressDialog;
    }

    public static ProgressDialog showProgressDialog(Activity context, String title, String message, boolean cancellable) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setTitle(title);
        progressDialog.setCancelable(cancellable);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        styleDialog(progressDialog);
        return progressDialog;
    }

    public static void styleDialog(Dialog dialog){
        try {
//            Resources resources = dialog.getContext().getResources();
//            int color = resources.getColor(R.color.colorPrimary); // your color here
//
//            int alertTitleId = resources.getIdentifier("alertTitle", "id", "android");
//            TextView alertTitle = (TextView) dialog.getWindow().getDecorView().findViewById(alertTitleId);
//            alertTitle.setTextColor(color); // change title text color
//
//            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
//            View titleDivider = dialog.getWindow().getDecorView().findViewById(titleDividerId);
//            titleDivider.setBackgroundColor(color); // change divider color
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void styleDialogFragment(Dialog dialog){
        try {
//            Resources resources = dialog.getContext().getResources();
//            int color = resources.getColor(R.color.colorPrimary); // your color here
//
//            int alertTitleId = resources.getIdentifier("title", "id", "android");
//            TextView alertTitle = (TextView) dialog.getWindow().getDecorView().findViewById(alertTitleId);
//            alertTitle.setTextColor(color); // change title text color
//
//            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
//            View titleDivider = dialog.getWindow().getDecorView().findViewById(titleDividerId);
//            titleDivider.setBackgroundColor(color); // change divider color
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
