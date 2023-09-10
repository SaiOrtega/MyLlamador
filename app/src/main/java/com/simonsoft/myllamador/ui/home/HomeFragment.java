package com.simonsoft.myllamador.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.simonsoft.myllamador.databinding.FragmentHomeBinding;
import com.simonsoft.myllamador.databinding.FragmentLlamarBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel mv;

//para probar llame a otro fragment.xml y reeplacé el de home.xml
    private FragmentLlamarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       mv = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentLlamarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.txRes.setText(s);
            }
        });

        binding.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.llamar(binding.txTel.getText().toString());
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}