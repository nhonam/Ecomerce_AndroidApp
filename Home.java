package com.example.ecomerceshoppe;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.ecomerceshoppe.adapter.CategoryAdapter;
import com.example.ecomerceshoppe.adapter.ProductLatestAdapter;
import com.example.ecomerceshoppe.retrofix.ApiProduct;
import com.example.ecomerceshoppe.retrofix.RetroClient;
import com.example.ecomerceshoppe.service.CategoryService;
import com.example.ecomerceshoppe.service.ProductService;
import com.example.ecomerceshoppe.slider.PhotoAdapter;
import com.example.ecomerceshoppe.slider.setDataSlider;
import com.example.ecomerceshoppe.ultils.InternetConnect;
import com.example.ecomerceshoppe.ultils.Utils;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class Home extends AppCompatActivity {
    //slider
    private ViewPager viewPager;
    //hiển thị slider
    private PhotoAdapter photoAdapter;
    ApiProduct apiProduct;
    //call API
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    //gridview Category Product
    GridView productCategory, gr_productList;

    //Name Category Product
    String[] nameLogo;
    //logo Category Product
    int[] imgLogo;

    //testdata
    List<String> nameProductList;

    List<Double> priceProductList;

    List<String> urlProductList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setData
        nameLogo = CategoryService.loadLogoName().toArray(new String[0]);
        imgLogo = CategoryService.loadLogo();
        nameProductList = ProductService.getAllNameProduct();
        priceProductList = ProductService.getAllPriceProduct();
        urlProductList = ProductService.getAllUrlProduct();

        Mapping();
        if (InternetConnect.isConnected(this)) {
//            Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
            //   getAllProduct();
        } else {
            Toast.makeText(getApplicationContext(), "khong có internet", Toast.LENGTH_LONG).show();
        }

        //init adapter
        setAdapter();

    }

    private void setAdapter() {
        //setCategoryProduct
        CategoryAdapter categoryAdapter = new CategoryAdapter(
                Home.this,
                nameLogo,
                imgLogo
        );
        productCategory.setAdapter(categoryAdapter);
        //setCategoryProduct
        ProductLatestAdapter latestProduct_test = new ProductLatestAdapter(
                Home.this,
                nameProductList,
                priceProductList,
                urlProductList

        );
        gr_productList.setAdapter(latestProduct_test);
        //setAdapterSlider
        photoAdapter = new PhotoAdapter(this, setDataSlider.getListPhoto());
        viewPager.setAdapter(photoAdapter);
    }
    private void Mapping() {
        productCategory = findViewById(R.id.productCategory);
        gr_productList = findViewById(R.id.latestProduct);
        viewPager = findViewById(R.id.viewpager);
        apiProduct = RetroClient.getInstance(Utils.BASE_URL).create(ApiProduct.class);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }


}