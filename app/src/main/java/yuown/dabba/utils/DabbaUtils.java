package yuown.dabba.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import yuown.dabba.activities.DabbaAppCompatActivity;
import yuown.dabba.data.model.ItemDM;
import yuown.dabba.data.realm.ItemRM;

/**
 * Created by kiran.nk on 9/8/2016.
 */
public class DabbaUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public static void hideKeyboard(DabbaAppCompatActivity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static Realm getRealm(DabbaAppCompatActivity activity) {
        Realm realm = null;
        RealmConfiguration config = new RealmConfiguration.Builder(activity.getApplicationContext()).build();
        Realm.setDefaultConfiguration(config);

        try {
            realm = Realm.getDefaultInstance();
        } catch(Exception e) {
            try {
                Realm.deleteRealm(config);
                realm = Realm.getDefaultInstance();
            } catch (Exception e1) {
                throw e1;
            }
        }
        return realm;
    }

    public static void showMessage(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static String dateToString(Date date) {
        return simpleDateFormat.format(date);
    }

    public static <E extends RealmObject> int getNextId(Realm realm, Class<E> type) {
        int id = 1;
        try {
            id = realm.where(type).max("id").intValue() + 1;
        } catch (Exception e) {

        }
        return id;
    }

    public static ItemDM rm2dm(ItemRM rm) {
        ItemDM dm = new ItemDM();
        try {
            dm.setId(rm.getId());
            dm.setName(rm.getName());
            dm.setPrice(rm.getPrice());
            dm.setWeight(rm.getWeight());
            dm.setPurity(rm.getPurity());
            dm.setCost(rm.getCost());
        } catch (Exception e) { }
        return dm;
    }

    public static ItemRM rm2dm(ItemDM dm) {
        ItemRM rm = new ItemRM();
        try {
            rm.setId(dm.getId());
            rm.setName(dm.getName());
            rm.setPrice(dm.getPrice());
            rm.setWeight(dm.getWeight());
            rm.setPurity(dm.getPurity());
            rm.setCost(dm.getCost());
        } catch (Exception e) { }
        return rm;
    }
}
