package com.simonsoft.myllamador.ui.home;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.Enumeration;

public class HomeViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> mText;


    public HomeViewModel(@NonNull Application application) {
        super( application);
        mText = new MutableLiveData<>();
        mText.setValue("");
        context = application.getApplicationContext();
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void llamar(String num) {
        mText.setValue("");
        if (num.equals("")){
            mText.setValue("Debe ingresar un número");
        }else {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:"+num));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           try {
               context.startActivity(i);
           }catch(Exception ex){
               mText.setValue("de aceptar los permisos");
           }
           }
        }
    }



