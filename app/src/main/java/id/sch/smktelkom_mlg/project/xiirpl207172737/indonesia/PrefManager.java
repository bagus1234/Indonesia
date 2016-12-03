package id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 02/12/2016.
 */

public class PrefManager{

        // Shared preferences file name
        private static final String PREF_NAME = "androidhive-welcome";
        private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
        private final  _context;

        {SharedPreferences pref;
        SharedPreferences.Editor editor;
        Context _context;
        // shared pref mode
        int PRIVATE_MODE=0;

public Object context;
        PrefManager(Context context)
        this._context=context;
        pref=_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();


public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);
        }

public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,isFirstTime);
        editor.commit();
        }

        }
