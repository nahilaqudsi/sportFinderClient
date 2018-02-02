package nahilaqudsi.example.com.sportfinder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import nahilaqudsi.example.com.sportfinder.DetailIndor;
//import nahilaqudsi.example.com.sportfinder.DetailIndor2;
import nahilaqudsi.example.com.sportfinder.DetailKolam;
import nahilaqudsi.example.com.sportfinder.Model.LapOutdor;
import nahilaqudsi.example.com.sportfinder.R;

/**
 * Created by Nahila Khunafa on 1/25/2018.
 */

public class KolamAdapter extends RecyclerView.Adapter<KolamAdapter.ViewHolder> {
    Context context;
    List<LapOutdor> lapOutdorList;

    public KolamAdapter(Context context, List<LapOutdor> lapOutdorList) {
        this.context = context;
        this.lapOutdorList = lapOutdorList;
    }

    @Override
    public KolamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kolam_item, parent, false);
        KolamAdapter.ViewHolder viewHolder = new KolamAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KolamAdapter.ViewHolder holder, int position) {
        final LapOutdor lapOutdor = lapOutdorList.get(position);

        holder.txtName.setText(lapOutdor.getNama());
        //Loading image from Glide library.
        Glide.with(context).load(lapOutdor.getImageURL()).into(holder.imageView);
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openDetailActivity(lapOutdor.getNama(),lapOutdor.getAlamat(), lapOutdor.getTelp(), lapOutdor.getKeterangan() );
            }
        });
    }

    @Override
    public int getItemCount() {
        return lapOutdorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView, imageView2;
        public TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.imageView2);
            txtName = (TextView) itemView.findViewById(R.id.txtNama);
        }
    }

    public void openDetailActivity(String...details){
        Intent i = new Intent(context, DetailKolam.class);
        i.putExtra("nama",details[0]);
        i.putExtra("alamat", details[1]);
        i.putExtra("telp", details[2]);
        i.putExtra("keterangan", details[3]);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
