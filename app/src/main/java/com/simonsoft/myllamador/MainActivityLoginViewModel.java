package com.simonsoft.myllamador;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityLoginViewModel extends AndroidViewModel {

    Context context;
    private MutableLiveData<String> mres;


    public LiveData<String> getMuStringLiveData(){
        if(mres == null){
            mres = new MutableLiveData<>();
        }
        return mres;
    }
    public MainActivityLoginViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public void login(String password, String email){

        if (password.equals("123")&& email.equals("correo@mail.com")){
            Intent intent = new Intent(context,MainActivityMenu.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            mres.setValue("Contraseña invalidad");
        }
    }
}
