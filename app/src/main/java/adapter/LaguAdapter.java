package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Lagu;

/**
 * Created by Shafira Pramatana on 11/20/2016.
 */
public class LaguAdapter extends RecyclerView.Adapter<LaguAdapter.ViewHolder> {
    ArrayList<Lagu> laguList;

    public LaguAdapter(ArrayList<Lagu> laguList) {
        this.laguList = laguList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listlagu, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lagu lagu = laguList.get(position);
        holder.tvJudul.setText(lagu.judul);
        holder.tvDeskripsi.setText(lagu.deskripsi);
        holder.ivFoto.setImageDrawable(lagu.foto);
    }

    @Override
    public int getItemCount() {
        if (laguList != null)
            return laguList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
