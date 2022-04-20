package edu.aku.hassannaqvi.naunehalendlinelisting.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.naunehalendlinelisting.BR;
import edu.aku.hassannaqvi.naunehalendlinelisting.contracts.TableContracts.MwraTable;
import edu.aku.hassannaqvi.naunehalendlinelisting.core.MainApp;

public class Mwra extends BaseObservable {

    private final String TAG = "MWRA";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    private String uuid = StringUtils.EMPTY;
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
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
    private String sMwra = StringUtils.EMPTY;
    //private String sH1 = StringUtils.EMPTY;
    // FIELD VARIABLES
    private String sno = StringUtils.EMPTY;
    private String hh01 = StringUtils.EMPTY;
    private String hh02 = StringUtils.EMPTY;
    private String hh03 = StringUtils.EMPTY;
    private String hh04 = StringUtils.EMPTY;
    private String hh05 = StringUtils.EMPTY;
    private String hh06 = StringUtils.EMPTY;


    private String hh16 = StringUtils.EMPTY;
    private String hh17 = StringUtils.EMPTY;
    private String hh18 = StringUtils.EMPTY;
    private String hh19 = StringUtils.EMPTY;
    private String hh20 = StringUtils.EMPTY;
    private String hh21 = StringUtils.EMPTY;


    public Mwra() {

//        setSysDate(MainApp.listings.getSysDate());
//        setSysDate(MainApp.listings.getSysDate());
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());


    }

    public void setIdentification() {
        this.uuid = MainApp.listings.getUid();
        this.hh01 = MainApp.listings.getHh01();
        this.hh02 = MainApp.listings.getHh02();
        this.hh03 = MainApp.listings.getHh03();
        this.hh04 = MainApp.listings.getHh04();
        this.hh05 = MainApp.listings.getHh05();
        this.hh06 = MainApp.listings.getHh06();
    }

    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
        notifyPropertyChanged(BR.sno);
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

    /*   @Bindable
       public String getHh07() {
           return hh07;
       }
   
       public void setHh07(String hh07) {
           this.hh07 = hh07;
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
           notifyPropertyChanged(BR.hh08);
       }
   
       @Bindable
       public String getHh09() {
           return hh09;
       }
   
       public void setHh09(String hh09) {
           this.hh09 = hh09;
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
           notifyPropertyChanged(BR.hh14);
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
       public String getHh13() {
           return hh13;
       }
   
       public void setHh13(String hh13) {
           this.hh13 = hh13;
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
   */
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


    @Bindable
    public String getHh20() {
        return hh20;
    }

    public void setHh20(String hh20) {
        this.hh20 = hh20;
        notifyPropertyChanged(BR.hh20);
    }

    @Bindable
    public String getHh21() {
        return hh21;
    }

    public void setHh21(String hh21) {
        this.hh21 = hh21;
        notifyPropertyChanged(BR.hh21);
    }


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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
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

    /* public String getsH1() {
         return sH1;
     }

     public void setsH1(String sH1) {
         this.sH1 = sH1;
     }
 */
    public String getsMwra() {
        return sMwra;
    }

    public void setsMwra(String sMwra) {
        this.sMwra = sMwra;
    }


    public Mwra Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_UUID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_SYNCED_DATE));
        this.endTime = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_END_TIME));
        this.startTime = cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_START_TIME));
        sMwraHydrate(cursor.getString(cursor.getColumnIndexOrThrow(MwraTable.COLUMN_SMWRA)));


        return this;
    }

    public void sMwraHydrate(String string) throws JSONException {
        Log.d(TAG, "sBHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh01 = json.getString("hh01");
            this.sno = json.has("sno") ? json.getString("sno") : ""; // Similar to ALTER Table
            this.hh02 = json.getString("hh02");
            this.hh03 = json.getString("hh03");
            this.hh04 = json.getString("hh04");
            this.hh05 = json.getString("hh05");
            this.hh06 = json.getString("hh06");

            this.hh16 = json.getString("hh16");
            this.hh17 = json.getString("hh17");
            this.hh18 = json.getString("hh18");
            this.hh19 = json.getString("hh19");
            this.hh20 = json.getString("hh20");
            this.hh21 = json.getString("hh21");


        }
    }

    public String sMwratoString() throws JSONException {
        Log.d(TAG, "sBtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh01", hh01)
                .put("sno", sno)
                .put("hh02", hh02)
                .put("hh03", hh03)
                .put("hh04", hh04)
                .put("hh05", hh05)
                .put("hh06", hh06)

                .put("hh16", hh16)
                .put("hh17", hh17)
                .put("hh18", hh18)
                .put("hh19", hh19)
                .put("hh21", hh21)
                .put("hh20", hh20);
        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(MwraTable.COLUMN_ID, this.id);
        json.put(MwraTable.COLUMN_UID, this.uid);
        json.put(MwraTable.COLUMN_UUID, this.uuid);
        json.put(MwraTable.COLUMN_USERNAME, this.userName);
        json.put(MwraTable.COLUMN_APPVERSION, this.appver);
        json.put(MwraTable.COLUMN_SYSDATE, this.sysDate);
        json.put(MwraTable.COLUMN_DEVICEID, this.deviceId);
        json.put(MwraTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(MwraTable.COLUMN_ISTATUS, this.iStatus);
        json.put(MwraTable.COLUMN_SYNCED, this.synced);
        json.put(MwraTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(MwraTable.COLUMN_SMWRA, new JSONObject(sMwratoString()));
        json.put(MwraTable.COLUMN_END_TIME, this.endTime);
        json.put(MwraTable.COLUMN_START_TIME, this.startTime);
        

/*        if (this.sA != null && !this.sA.equals("")) {
            json.put(MwraTable.COLUMN_SA, new JSONObject(this.sA));
        }
        if (this.sMwra != null && !this.sMwra.equals("")) {
            json.put(MwraTable.COLUMN_SB, new JSONObject(this.sMwra));
        }
        if (this.lC != null && !this.lC.equals("")) {
            json.put(MwraTable.COLUMN_SC, new JSONObject(this.lC));
        }*/

        return json;

    }
}
