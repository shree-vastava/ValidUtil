package thebat.lib.validutil;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;


public class ValidUtils {
    static String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    static String emailpattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";
    public static  String terminal_id;
    public static KProgressHUD progress;

    public static boolean validateEditTexts(EditText... testObj) {
        for (int i = 0; i < testObj.length; i++) {
            if (testObj[i].getText().toString().trim().equals(""))
                return false;
        }
        return true;
    }

    public static boolean validateMobileNumber(EditText... testObj) {
        for (int i = 0; i < testObj.length; i++) {
            if (testObj[i].getText().toString().length() != 10)
                return false;
        }
        return true;
    }


    public static boolean validateEmail(EditText... testObj) {
        for (int i = 0; i < testObj.length; i++) {
            if (!testObj[i].getText().toString().trim().matches(emailpattern) && !testObj[i].getText().toString().trim().matches(emailpattern2))
                return false;
        }
        return true;
    }

    public static boolean validateForDigits(EditText testObj, int noOfDigits) {

            if (testObj.getText().toString().length()!=noOfDigits)
                return false;
        return true;
    }

    public static void showToast(Context c, String s) {
        Toast.makeText(c, s, Toast.LENGTH_LONG).show();
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected())
            return true;
        else
            return false;
    }

    public static void showProgressDialog(Context c, Activity a){

        View v = a.getLayoutInflater().inflate(R.layout.custom_progress, null);
        progress= KProgressHUD.create(a)
                .setCustomView(v)
                .setCancellable(true)
                .show();
    }

    public static void hideProgressDialog(){
        progress.dismiss();
    }
}
