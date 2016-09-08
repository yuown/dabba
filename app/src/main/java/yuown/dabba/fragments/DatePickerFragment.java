package yuown.dabba.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import yuown.dabba.activities.DabbaAppCompatActivity;

/**
 * Created by kiran.nk on 9/8/2016.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DabbaAppCompatActivity dabbaAppCompatActivity;

    private Date date;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        dabbaAppCompatActivity = (DabbaAppCompatActivity) getActivity();
        return new DatePickerDialog(dabbaAppCompatActivity, this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c  = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        dabbaAppCompatActivity.dateChanged(c.getTime());
    }

    public void setCallback(DabbaAppCompatActivity dabbaAppCompatActivity, Date date) {
        this.date = date;
        this.dabbaAppCompatActivity = dabbaAppCompatActivity;
    }
}
