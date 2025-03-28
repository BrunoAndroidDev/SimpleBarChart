package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        int nombreElements = 10; // Définir la taille de la liste
        List<Integer> chartData = genererListeAleatoire(nombreElements, 1, 12);
        List<Integer> intervalData = new ArrayList<>();
        for (int i = 12; i >= 1; i--) {
            intervalData.add(i);
        }
        binding.simpleBarChart.setChartData(chartData, intervalData);
        binding.simpleBarChart.setMaxValue(20);
        binding.simpleBarChart.setMinValue(0);
    }

    public static List<Integer> genererListeAleatoire(int nombreElements, int min, int max) {
        List<Integer> listeAleatoire = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nombreElements; i++) {
            int nombreAleatoire = random.nextInt(max - min + 1) + min;
            listeAleatoire.add(nombreAleatoire);
        }

        return listeAleatoire;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}