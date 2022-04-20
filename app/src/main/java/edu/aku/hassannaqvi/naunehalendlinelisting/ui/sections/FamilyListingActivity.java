package edu.aku.hassannaqvi.naunehalendlinelisting.ui.sections;

import static edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp.listings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.naunehalendlinelisting.R;
import edu.aku.hassannaqvi.naunehalendlinelisting.contracts.TableContracts;
import edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp;
import edu.aku.hassannaqvi.naunehalendlinelisting.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehalendlinelisting.databinding.ActivityFamilyListingBinding;

public class FamilyListingActivity extends AppCompatActivity {
    private static final String TAG = "FamilyListingActivity";
    ActivityFamilyListingBinding bi;
    String st = "";
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_listing);
        bi.setCallback(this);
        bi.setListings(listings);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        MainApp.hhid++;
        MainApp.mwraCount = 0;
        listings.setHh05(String.valueOf(MainApp.hhid));
        listings.setHh11("");
        listings.setHh12("");
        listings.setHh13("");
        listings.setHh13a("");
        listings.setHh14("");
        listings.setHh14a("");
        listings.setHh15("");
        bi.btnEnd.setVisibility(MainApp.hhid == 1 ? View.GONE : View.VISIBLE);

        if (MainApp.hhid >= Integer.parseInt(MainApp.listings.getHh10())) {
            bi.fldGrpCVhh15.setVisibility(View.VISIBLE);
        }


/*        if (!listings.getHh02e().isEmpty()){
            if (listings.getHh02e().equals("1"))
                appendingChar = "A";
            else if ((listings.getHh02e().equals("2")))
                appendingChar = "B";
        }*/

        bi.hhid.setText("TPV-" + MainApp.listings.getHh01() + "\n" + MainApp.selectedTab + "-" + String.format("%04d", MainApp.maxStructure) + "-" + String.format("%03d", MainApp.hhid));
        Toast.makeText(this, "Staring Household", Toast.LENGTH_SHORT).show();

        bi.hh1301.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                try {
                    bi.hh13a.setMaxvalue(Float.parseFloat(bi.hh12.getText().toString()) - 1f);
                } catch (NumberFormatException e) {
                    bi.hh13a.setMaxvalue(0f);
                }

            }
        });

        bi.hh1401.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                try {
                    bi.hh14a.setMaxvalue(Float.parseFloat(bi.hh13a.getText().toString()));
                } catch (NumberFormatException e) {
                    bi.hh14a.setMaxvalue(0f);
                }
            }
        });


    }

 /*   @Override
    protected void onResume() {
        super.onResume();

        Animation bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_out_animation);
        bi.hhid.setText("TPV-" + MainApp.listings.getHh01() + "\n" + MainApp.selectedTab + "-" + String.format("%04d", MainApp.maxStructure) + "-");
        bi.hhid.startAnimation(bounceAnimation);
        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);

        bi.hhid.setText("TPV-" + MainApp.listings.getHh01() + "\n" + MainApp.selectedTab + "-" + String.format("%04d", MainApp.maxStructure) + "-" + String.format("%03d", MainApp.hhid));
        bi.hhid.startAnimation(bounceAnimation);
    }*/

    /*   private void setupSkips() {

        bi.hh13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.hh1301.isChecked()) {
                    bi.addFamily.setText("Add MWRA");
                } else {
                    bi.addFamily.setText("Continue to Next");
                    Clear.clearAllFields(bi.fldGrpCVhh13a);
                }
            }
        });
    }*/

    private boolean updateDB() {
        long updcount = 0;
        try {
            updcount = db.updateFormColumn(TableContracts.ListingsTable.COLUMN_SC, listings.sCtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db_form + e.getMessage());
            Toast.makeText(this, R.string.upd_db_form + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean insertRecord() {
        long rowId = 0;

        try {
            rowId = db.addListings(listings);

            if (rowId > 0) {
                long updCount = 0;

                listings.setId(String.valueOf(rowId));
                listings.setUid(listings.getDeviceId() + listings.getId());

                updCount = db.updateFormColumn(TableContracts.ListingsTable.COLUMN_UID, listings.getUid());

                if (updCount > 0) {
                    return updateDB();
                }

            } else {
                Toast.makeText(this, "Updating Database… ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(CR):" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return false;

    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        //saveDraft();
        if (MainApp.hhid == 1 ? updateDB() : insertRecord()) {
            finish();
            if (MainApp.hhid < Integer.parseInt(MainApp.listings.getHh10()) || listings.getHh15().equals("1")) {
                //   Toast.makeText(this, "Staring Family", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, FamilyListingActivity.class));

            } else {
                //     Toast.makeText(this, "Staring Household", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SectionBActivity.class));

            }
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }

    private void saveDraft() {
        // listings = new Listings();
//        listings.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
//        //  listings.setUserName(MainApp.user.getUserName());
//        // listings.setDeviceId(MainApp.appInfo.getDeviceID());
//        // listings.setDeviceTag(MainApp.appInfo.getTagName());
//        // listings.setAppver(MainApp.appInfo.getAppVersion());
//        // listings.setStartTime(st);
//        // listings.setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
//
//        listings.setHh11(bi.hh11.getText().toString());
//
//        //listings.setHh14(bi.hh14.getText().toString());
//
//        listings.setHh14a(bi.hh14a.getText().toString());
//        listings.sethh12(bi.hh12.getText().toString());
//
//        listings.setHh13(bi.hh1301.isChecked() ? "1"
//                : bi.hh1302.isChecked() ? "2"
//                : "-1");
//
//        listings.setHh13a(bi.hh13a.getText().toString());
//
///*        listings.setHh16(bi.hh16.getText().toString());
//
//        listings.setHh17(bi.hh17.getText().toString());
//
//        listings.setHh18(bi.hh18.getText().toString());
//
//        listings.setHh19(bi.hh19.getText().toString());*/
//        listings.setHh21(String.valueOf(MainApp.hhid));
//
//        try {
//            listings.setsC(listings.lCtoString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "JSONException(listings): " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }

    }


    public void btnEnd(View view) {
        bi.hh11.setText("Deleted");
        //bi.hh14.setText("Deleted");
        bi.hh14a.setText("Deleted");
        bi.hh13.clearCheck();
        bi.hh13a.setText("00");

        //saveDraft();
        if (insertRecord()) {
            finish();

            //     Toast.makeText(this, "Staring Household", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SectionBActivity.class));

        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);


/*        if (!bi.hh13a.getText().toString().equals("") && !bi.hh12.getText().toString().equals("")) {
            if (Integer.parseInt(bi.hh13a.getText().toString()) > Integer.parseInt(bi.hh12.getText().toString())) {
                Validator.emptyCustomTextBox(this, bi.hh13a, "Number of children younger than 5 year old cannot be more than Total Members");
                return false;
            }
        }

        if (!bi.hh14a.getText().toString().equals("") && !bi.hh13a.getText().toString().equals("")) {
            if (Integer.parseInt(bi.hh14a.getText().toString()) >= Integer.parseInt(bi.hh13a.getText().toString())) {
                Validator.emptyCustomTextBox(this, bi.hh14a, "Number of 12 to 23 months old children cannot be more or equal to Number of children younger than 5 year old");
                return false;
            }
        }
        return true;*/
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
      /*  finish();
        startActivity(new Intent(this, MainActivity.class));*/
    }
}
