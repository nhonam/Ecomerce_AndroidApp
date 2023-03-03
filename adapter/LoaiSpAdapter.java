//package com.example.ecomerceshoppe.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.bumptech.glide.Glide;
//import com.example.ecomerceshoppe.R;
//import com.example.ecomerceshoppe.model.Product;
//
//import java.util.List;
//
//public class LoaiSpAdapter extends BaseAdapter {
//
//    List<Product>  listProduct;
//    Context context;
//
//    public LoaiSpAdapter(Context context, List<Product> listProduct) {
//        this.listProduct = listProduct;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return listProduct.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    public class ViewHolder {
//        TextView textNameProduct;
//        ImageView image;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder =null;
//        if (view ==null) {
//            viewHolder= new ViewHolder();
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = layoutInflater.inflate(R.layout.item_product,null);
//            viewHolder.textNameProduct = view.findViewById(R.id.product_name);
//            view.setTag(viewHolder);
//        }else {
//            viewHolder = (ViewHolder) view.getTag();
//            viewHolder.textNameProduct.setText(listProduct.get(i).getNameProduct());
//            Glide.with(context).load(listProduct.get(i).getImg()).into(viewHolder.image);
//        }
//        return  view;
//    }
//}
