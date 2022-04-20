package edu.aku.hassannaqvi.naunehalendlinelisting.ui.lists;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.naunehalendlinelisting.R;
import edu.aku.hassannaqvi.naunehalendlinelisting.adapters.ListingsAdapter;
import edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp;
import edu.aku.hassannaqvi.naunehalendlinelisting.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehalendlinelisting.databinding.ActivityListingsReporterBinding;
import edu.aku.hassannaqvi.naunehalendlinelisting.models.Listings;

public class ListingsReporter extends AppCompatActivity {
    DatabaseHelper db;
    Collection<Listings> fc;
    String sysdateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    ActivityListingsReporterBinding bi;
    private RecyclerView.Adapter formsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_listings_reporter);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //bi.fcRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        bi.fcRecyclerView.setLayoutManager(layoutManager);
        // bi.filter.setVisibility(View.GONE);
        db = MainApp.appInfo.dbHelper;
        try {
            fc = db.getListingsByCluster("");
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(Listings): " + e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        // specify an adapter (see also next example)
        formsAdapter = new ListingsAdapter((List<Listings>) fc, this);
        bi.fcRecyclerView.setAdapter(formsAdapter);
    }


    public void filterForms(View view) {
        try {
            fc = db.getListingsByCluster(bi.clusterFilter.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(Listings): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        formsAdapter = new ListingsAdapter((List<Listings>) fc, this);
        formsAdapter.notifyDataSetChanged();
        bi.fcRecyclerView.setAdapter(formsAdapter);

    }
}