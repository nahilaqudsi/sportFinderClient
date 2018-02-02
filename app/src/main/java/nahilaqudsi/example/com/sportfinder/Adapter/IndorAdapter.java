package nahilaqudsi.example.com.sportfinder.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import nahilaqudsi.example.com.sportfinder.Coba;
import nahilaqudsi.example.com.sportfinder.DataIndor;
import nahilaqudsi.example.com.sportfinder.DetailIndor;
//import nahilaqudsi.example.com.sportfinder.DetailIndor2;
import nahilaqudsi.example.com.sportfinder.Model.LapIndor;
import nahilaqudsi.example.com.sportfinder.R;
import nahilaqudsi.example.com.sportfinder.SharedPreference;
//import nahilaqudsi.example.com.sportfinder.SharedPreference;

/**
 * Created by Nahila Khunafa on 1/23/2018.
 */

public class IndorAdapter extends RecyclerView.Adapter<IndorAdapter.ViewHolder>{

    Context context;
    List<LapIndor> lapIndorList;
    SharedPreference sharedPreference;

    public IndorAdapter(Context context, List<LapIndor> lapIndorList) {
        this.context = context;
        this.lapIndorList = lapIndorList;
        sharedPreference = new SharedPreference();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indor_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LapIndor lapIndor = lapIndorList.get(position);

        holder.txtName.setText(lapIndor.getNama());

//        LapIndor product = (LapIndor) getItem(position);
//        if (checkFavoriteItem(product)) {
//            holder.favoriteImg.setImageResource(R.drawable.heart_red);
//            holder.favoriteImg.setTag("red");
//        } else {
//            holder.favoriteImg.setImageResource(R.drawable.heart_grey);
//            holder.favoriteImg.setTag("grey");
//        }
        //Loading image from Glide library.
        Glide.with(context).load(lapIndor.getImageURL()).into(holder.imageView);
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openDetailActivity(lapIndor.getNama(),lapIndor.getAlamat(), lapIndor.getTelp(), lapIndor.getKeterangan() );
            }




        });
    }

//    @Override
//    public LapIndor getItem(int position) {
//        return lapIndorList.get(position);
//    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return lapIndorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView, imageView2;
        public TextView txtName;
        Button favoriteImg;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.imageView2);
            txtName = (TextView) itemView.findViewById(R.id.txtNama);
            favoriteImg = itemView.findViewById(R.id.btnDetailFav);
        }
    }

    public boolean checkFavoriteItem(LapIndor checkProduct) {
        boolean check = false;
        List<LapIndor> favorites = sharedPreference.getFavorites(context);
        if (favorites != null) {
            for (LapIndor product : favorites) {
                if (product.equals(checkProduct)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

//    @Override
//    public void add(LapIndor product) {
//        super.add(product);
//        lapIndorList.add(product);
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public void remove(LapIndor product) {
//        super.remove(product);
//        lapIndorList.remove(product);
//        notifyDataSetChanged();
//    }

    public void openDetailActivity(String...details){
        Intent i = new Intent(context, DetailIndor.class);
        i.putExtra("nama",details[0]);
        i.putExtra("alamat", details[1]);
        i.putExtra("telp", details[2]);
        i.putExtra("keterangan", details[3]);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }

}
