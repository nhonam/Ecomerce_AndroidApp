package com.example.ecomerceshoppe.service;

import com.example.ecomerceshoppe.R;

import java.util.Arrays;
import java.util.List;

public class CategoryService {

    public static List<String> loadLogoName() {
        String[] nameLogo = new String[]{
                "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam", "Nho Nam"
        };

        return Arrays.asList(nameLogo);


    }

    public static int[] loadLogo() {
        int[] logo  = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.bn1,
                R.drawable.bn2,
                R.drawable.bn3

        };

        return logo;


    }




}
