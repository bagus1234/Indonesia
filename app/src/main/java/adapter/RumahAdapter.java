package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Rumah;


/**
 * Created by Broom on 19/11/2016.
 */

public class RumahAdapter extends RecyclerView.Adapter<RumahAdapter.ViewHolder> {
    ArrayList<Rumah> rumahList;

    public RumahAdapter(ArrayList<Rumah> rumahList) {
        this.rumahList = rumahList;
    }

    @Override
    public RumahAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listrumah, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RumahAdapter.ViewHolder holder, int position) {
        Rumah rumah = rumahList.get(position);
        holder.tvJudul.setText(rumah.judul);
        holder.tvDeskripsi.setText(rumah.deskripsi);
        holder.ivFoto.setImageDrawable(rumah.foto);
    }

    @Override
    public int getItemCount() {
        if (rumahList != null)
            return rumahList.size();
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
