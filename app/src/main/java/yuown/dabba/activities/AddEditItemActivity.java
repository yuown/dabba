package yuown.dabba.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import io.realm.Realm;
import yuown.dabba.R;
import yuown.dabba.data.model.ItemDM;
import yuown.dabba.data.realm.ItemRM;
import yuown.dabba.databinding.ActivityAddEditItemBinding;
import yuown.dabba.fragments.DatePickerFragment;
import yuown.dabba.utils.DabbaUtils;

public class AddEditItemActivity extends DabbaAppCompatActivity {

    private TextView itemDateLbl;

    private ItemDM item;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_item);

        itemDateLbl = (TextView)  findViewById(R.id.itemDate);

        realm = DabbaUtils.getRealm(this);

        ActivityAddEditItemBinding activityAddItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_item);

        Intent intent = getIntent();
        int id = -1;
        try {
            id = intent.getIntExtra("id", -1);
        } catch (Exception e) { }

        if(id == -1) {
            id = DabbaUtils.getNextId(realm, ItemRM.class);
            item = new ItemDM();
            item.setId(id);
        } else {
            item = DabbaUtils.rm2dm(realm.where(ItemRM.class).equalTo("id", id).findFirst());
        }

        activityAddItemBinding.setItem(item);
    }

    public void showDate(View v) {
        DabbaUtils.hideKeyboard(this);
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setCallback(this, item.getDate());
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void dateChanged(Date date) {
        item.setDate(date);
        itemDateLbl.setText(DabbaUtils.dateToString(item.getDate()));
    }

    public void saveItem(View view) {
        if(StringUtils.isEmpty(item.getName())) {
            DabbaUtils.showMessage(getApplicationContext(), "Item Name cannot be empty!");
        } else if(Float.parseFloat(item.getWeight()) <= 0.0) {
            DabbaUtils.showMessage(getApplicationContext(), "Item Weight cannot be 0.0!");
        } else if(Float.parseFloat(item.getPrice()) <= 0.0) {
            DabbaUtils.showMessage(getApplicationContext(), "Item Price cannot be 0.0!");
        } else {
            realm.beginTransaction();
            realm.insertOrUpdate(DabbaUtils.rm2dm(item));
            realm.commitTransaction();

            onBackPressed();
            DabbaUtils.showMessage(getApplicationContext(), "Item Saved");
        }
        DabbaUtils.hideKeyboard(this);
    }
}
