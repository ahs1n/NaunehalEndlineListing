package edu.aku.hassannaqvi.naunehalendlinelisting.ui.sections;

import static edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp.mwra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.naunehalendlinelisting.MainActivity;
import edu.aku.hassannaqvi.naunehalendlinelisting.R;
import edu.aku.hassannaqvi.naunehalendlinelisting.contracts.TableContracts;
import edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp;
import edu.aku.hassannaqvi.naunehalendlinelisting.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehalendlinelisting.databinding.ActivityMwraListingBinding;
import edu.aku.hassannaqvi.naunehalendlinelisting.models.Mwra;

public class MWRAListingActivity extends AppCompatActivity {
    private static final String TAG = "FamilyListingActivity";
    ActivityMwraListingBinding bi;
    String st = "";
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mwra_listing);
        bi.setCallback(this);
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        MainApp.mwraCount++;
        bi.hhid.setText(MainApp.listings.getHh01() + "\n" + String.format("%03d", MainApp.maxStructure) + "-" + String.format("%02d", MainApp.hhid));
        bi.mwraSno.setText("MWRA#: " + MainApp.mwraCount + " of " + MainApp.listings.getHh13a());

        setupSkips();
        Toast.makeText(this, "Staring MWRA", Toast.LENGTH_SHORT).show();

    }

    private void setupSkips() {

        //   bi.hh13.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpa14a));
        if (MainApp.listings.getHh13a() != null) {
            if (MainApp.mwraCount < Integer.parseInt(MainApp.listings.getHh13a())) {
                bi.addMWRA.setText("Add MWRA");
            } else if (MainApp.hhid < Integer.parseInt(MainApp.listings.getHh10())) {
                bi.addMWRA.setText("Continue to Next");
            } else {
                bi.addMWRA.setText("Continue to Next");

            }
        }
    }

    private boolean insertRecord() {
        long rowId = 0;

        try {
            rowId = db.addMwra(mwra);

            if (rowId > 0) {
                long updCount = 0;

                mwra.setId(String.valueOf(rowId));
                mwra.setUid(mwra.getDeviceId() + mwra.getId());

                updCount = db.updateMwraColumn(TableContracts.MwraTable.COLUMN_UID, mwra.getUid());

                if (updCount > 0) {
                    return true;
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
        saveDraft();
        if (insertRecord()) {
            finish();
            if (MainApp.mwraCount < Integer.parseInt(MainApp.listings.getHh13a())) {
                startActivity(new Intent(this, MWRAListingActivity.class));
                Toast.makeText(this, "" + MainApp.mwraCount, Toast.LENGTH_SHORT).show();
                //     startActivity(new Intent(this, SectionBActivity.class));
            } else if (MainApp.hhid < Integer.parseInt(MainApp.listings.getHh10())) {
                startActivity(new Intent(this, FamilyListingActivity.class));

            } else {
                startActivity(new Intent(this, SectionBActivity.class));

            }
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }

    private void saveDraft() {
        mwra = new Mwra();
        mwra.setUuid(MainApp.listings.getUid());
        mwra.setSysDate(MainApp.listings.getSysDate());
        mwra.setUserName(MainApp.user.getUserName());
        mwra.setDeviceId(MainApp.appInfo.getDeviceID());
        mwra.setDeviceTag(MainApp.appInfo.getTagName());
        mwra.setAppver(MainApp.appInfo.getAppVersion());
        //mwra.setStartTime(st);
        mwra.setIdentification();
        mwra.setSno(String.valueOf(MainApp.mwraCount));

/*        mwra.setHh11(bi.hh11.getText().toString());

        mwra.setHh14(bi.hh14.getText().toString());

        mwra.setHh14a(bi.hh14a.getText().toString());

        mwra.setHh13(bi.hh1301.isChecked() ? "1"
                : bi.hh1302.isChecked() ? "2"
                : "-1");

        mwra.setHh13a(bi.hh13a.getText().toString());*/

        mwra.setHh16(bi.hh16.getText().toString());

        mwra.setHh17(bi.hh17.getText().toString());

        mwra.setHh18(bi.hh18.getText().toString());

        mwra.setHh19(bi.hh19.getText().toString());

        mwra.setHh20(String.valueOf(MainApp.maxStructure));
        mwra.setHh21(String.valueOf(MainApp.hhid));

        try {
            mwra.setsMwra(mwra.sMwratoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(SB): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
/*        finish();
        startActivity(new Intent(this, MainActivity.class));*/
    }
}