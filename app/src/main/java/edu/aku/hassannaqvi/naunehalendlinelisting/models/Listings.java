package edu.aku.hassannaqvi.naunehalendlinelisting.models;

import static edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp.PROJECT_NAME;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.naunehalendlinelisting.BR;
import edu.aku.hassannaqvi.naunehalendlinelisting.contracts.TableContracts;
import edu.aku.hassannaqvi.naunehalendlinelisting.contracts.TableContracts.ListingsTable;
import edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp;

public class Listings extends BaseObservable {

    private final String TAG = "Listings";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String enumCode = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String tabNo = StringUtils.EMPTY;
    private String geoArea = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String startTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String sH1 = StringUtils.EMPTY;
    // FIELD VARIABLES
    private String hh01 = StringUtils.EMPTY;
    private String hh02 = StringUtils.EMPTY;


    private String hh03 = StringUtils.EMPTY;
    private String hh04 = StringUtils.EMPTY;
    private String hh05 = StringUtils.EMPTY;
    private String hh06 = StringUtils.EMPTY;
    private String hh07 = StringUtils.EMPTY;
    private String hh0717x = StringUtils.EMPTY;
    private String hh08 = StringUtils.EMPTY;


    private String hh09 = StringUtils.EMPTY;
    private String hh10 = StringUtils.EMPTY;
    private String hh11 = StringUtils.EMPTY;
    private String hh12 = StringUtils.EMPTY;
    private String hh13 = StringUtils.EMPTY;
    private String hh13a = StringUtils.EMPTY;
    private String hh14 = StringUtils.EMPTY;
    private String hh14a = StringUtils.EMPTY;
    private String hh15 = StringUtils.EMPTY;

    private String sA = StringUtils.EMPTY;
    private String sB = StringUtils.EMPTY;
    private String sC = StringUtils.EMPTY;

    public Listings() {

/*        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());*/

    }

    public void populateMeta() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        //   setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);

        setUserName(MainApp.user.getUserName());
        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.versionName + "." + MainApp.versionCode);
        setEnumCode(MainApp.user.getDist_id());

    }


    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        setCluster(hh01);
        setHh02("");
        setHh03("");
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getHh02() {
        return hh02;
    }

    public void setHh02(String hh02) {
        this.hh02 = hh02;

        notifyPropertyChanged(BR.hh02);
    }

    @Bindable
    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
        setTabNo(hh03.equals("1") ? "A" : hh03.equals("2") ? "B" : "0");
        notifyPropertyChanged(BR.hh03);
    }

    @Bindable
    public String getHh04() {
        return hh04;
    }

    public void setHh04(String hh04) {
        this.hh04 = hh04;
        notifyPropertyChanged(BR.hh04);
    }

    @Bindable
    public String getHh05() {
        return hh05;
    }

    public void setHh05(String hh05) {
        this.hh05 = hh05;
        notifyPropertyChanged(BR.hh05);
    }

    @Bindable
    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
        notifyPropertyChanged(BR.hh06);
    }

    @Bindable
    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
        setHh08("");

        notifyPropertyChanged(BR.hh07);
    }

    @Bindable
    public String getHh0717x() {
        return hh0717x;
    }

    public void setHh0717x(String hh0717x) {
        this.hh0717x = hh0717x;
        notifyPropertyChanged(BR.hh0717x);
    }


    @Bindable
    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
        setHh09(hh08.equals("1") ? this.hh09 : "");
        notifyPropertyChanged(BR.hh08);
    }

    @Bindable
    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
        setHh10(hh09.equals("1") ? this.hh10 : hh09.equals("2") ? "1" : "");
        notifyPropertyChanged(BR.hh09);
    }

    @Bindable
    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
        notifyPropertyChanged(BR.hh10);
    }

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
        notifyPropertyChanged(BR.hh11);
    }

    @Bindable
    public String getHh14() {
        return hh14;
    }

    public void setHh14(String hh14) {
        this.hh14 = hh14;
        setHh14a(hh14.equals("1") ? this.hh14a : "");
        notifyPropertyChanged(BR.hh14);
    }

    @Bindable
    public String getHh15() {
        return hh15;
    }

    public void setHh15(String hh15) {
        this.hh15 = hh15;
        notifyPropertyChanged(BR.hh15);
    }

    @Bindable
    public String getHh14a() {
        return hh14a;
    }

    public void setHh14a(String hh14a) {
        this.hh14a = hh14a;
        notifyPropertyChanged(BR.hh14a);
    }

    @Bindable
    public String getHh12() {
        return hh12;
    }

    public void setHh12(String hh12) {
        this.hh12 = hh12;
        notifyPropertyChanged(BR.hh12);
    }

    @Bindable
    public String getHh13() {
        return hh13;
    }

    public void setHh13(String hh13) {
        this.hh13 = hh13;
        setHh13a(hh13.equals("1") ? this.hh13a : "");
/*        setHh14(hh13.equals("1") ? this.hh14 : "");
        setHh14a(hh13.equals("1") ? this.hh14a : "");*/
        notifyPropertyChanged(BR.hh13);
    }

    @Bindable
    public String getHh13a() {
        return hh13a;
    }

    public void setHh13a(String hh13a) {
        this.hh13a = hh13a;
        notifyPropertyChanged(BR.hh13a);
    }

    /*
        @Bindable
        public String getHh16() {
            return hh16;
        }

        public void setHh16(String hh16) {
            this.hh16 = hh16;
            notifyPropertyChanged(BR.hh16);
        }

        @Bindable
        public String getHh17() {
            return hh17;
        }

        public void setHh17(String hh17) {
            this.hh17 = hh17;
            notifyPropertyChanged(BR.hh17);
        }

        @Bindable
        public String getHh18() {
            return hh18;
        }

        public void setHh18(String hh18) {
            this.hh18 = hh18;
            notifyPropertyChanged(BR.hh18);
        }

        @Bindable
        public String getHh19() {
            return hh19;
        }

        public void setHh19(String hh19) {
            this.hh19 = hh19;
            notifyPropertyChanged(BR.hh19);
        }
    */


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getTabNo() {
        return tabNo;
    }

    public void setTabNo(String tabNo) {
        this.tabNo = tabNo;
    }

    public String getGeoArea() {
        return geoArea;
    }

    public void setGeoArea(String geoArea) {
        this.geoArea = geoArea;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public String getEnumCode() {
        return enumCode;
    }

    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode;
    }

    public String getsH1() {
        return sH1;
    }

    public void setsH1(String sH1) {
        this.sH1 = sH1;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public Listings Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_USERNAME));
        this.cluster = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_CLUSTER));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_SYSDATE));
        this.tabNo = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_TAB_NO));
        this.geoArea = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_GEOAREA));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ListingsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ListingsTable.COLUMN_SYNCED_DATE));
        this.endTime = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_END_TIME));
        this.startTime = cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_START_TIME));
        sAHydrate(cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_SA)));
        sBHydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ListingsTable.COLUMN_SB)));
        sCHydrate(cursor.getString(cursor.getColumnIndexOrThrow(ListingsTable.COLUMN_SC)));

        return this;
    }

    public void sAHydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh01 = json.getString("hh01");
            this.hh02 = json.getString("hh02");
            this.hh03 = json.getString("hh03");
            this.enumCode = json.getString("enumCode");

        }
    }

    public void sBHydrate(String string) throws JSONException {
        Log.d(TAG, "sBHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh04 = json.getString("hh04");
            this.hh07 = json.getString("hh07");
            this.hh0717x = json.getString("hh0717x");
            this.hh08 = json.getString("hh08");
            this.hh08 = json.getString("hh08");
            this.hh09 = json.getString("hh09");
            this.hh10 = json.getString("hh10");

        }
    }

    public void sCHydrate(String string) throws JSONException {
        Log.d(TAG, "sCHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh05 = json.getString("hh05");
            this.hh11 = json.getString("hh11");
            this.hh12 = json.getString("hh12");
            this.hh13 = json.getString("hh13");
            this.hh13a = json.getString("hh13a");
            this.hh14 = json.getString("hh14");
            this.hh14a = json.getString("hh14a");
            this.hh15 = json.getString("hh15");


        }
    }

    public String sAtoString() throws JSONException {
        Log.d(TAG, "cRtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh01", hh01)
                .put("hh02", hh02)
                .put("hh03", hh03)
                .put("enumCode", enumCode);

        return json.toString();
    }


    public String sBtoString() throws JSONException {
        Log.d(TAG, "sBtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh04", hh04)
                .put("hh07", hh07)
                .put("hh0717x", hh0717x)
                .put("hh08", hh08)
                .put("hh09", hh09)
                .put("hh10", hh10);

        return json.toString();
    }

    public String sCtoString() throws JSONException {
        Log.d(TAG, "sCtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh05", hh05)
                .put("hh11", hh11)
                .put("hh12", hh12)
                .put("hh13", hh13)
                .put("hh13a", hh13a)
                .put("hh14", hh14)
                .put("hh14a", hh14a)
                .put("hh15", hh15);
        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(ListingsTable.COLUMN_ID, this.id);
        json.put(ListingsTable.COLUMN_UID, this.uid);
        json.put(ListingsTable.COLUMN_USERNAME, this.userName);
        json.put(ListingsTable.COLUMN_CLUSTER, this.cluster);
        json.put(ListingsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(ListingsTable.COLUMN_TAB_NO, this.tabNo);
        json.put(ListingsTable.COLUMN_GEOAREA, this.geoArea);
        json.put(ListingsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(ListingsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(ListingsTable.COLUMN_ISTATUS, this.iStatus);
        json.put(ListingsTable.COLUMN_APPVERSION, this.appver);
        json.put(ListingsTable.COLUMN_SYNCED, this.synced);
        json.put(ListingsTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(ListingsTable.COLUMN_SA, new JSONObject(sAtoString()));
        json.put(ListingsTable.COLUMN_SB, new JSONObject(sBtoString()));
        json.put(ListingsTable.COLUMN_SC, new JSONObject(sCtoString()));
        json.put(ListingsTable.COLUMN_END_TIME, this.endTime);
        json.put(ListingsTable.COLUMN_START_TIME, this.startTime);

      /*  json.put(ListingsTable.COLUMN_SA, this.sA);
        json.put(ListingsTable.COLUMN_SB, this.sB);
        json.put(ListingsTable.COLUMN_SC, this.sC);
*/
/*        if (this.sA != null && !this.sA.equals("")) {
            json.put(ListingsTable.COLUMN_SA, new JSONObject(this.sA));
        }
        if (this.sB != null && !this.sB.equals("")) {
            json.put(ListingsTable.COLUMN_SB, new JSONObject(this.sB));
        }
        if (this.sC != null && !this.sC.equals("")) {
            json.put(ListingsTable.COLUMN_SC, new JSONObject(this.sC));
        }*/

        return json;

    }
}
