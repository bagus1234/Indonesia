package adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import activity.PakaianFragment;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Pakaian;

/**
 * Created by User on 19/11/2016.
 */
public class PakaianAdapter extends RecyclerView.Adapter<PakaianAdapter.ViewHolder> {
    ArrayList<Pakaian> pakaianList;
    IPakaianAdapter mIPakaianAdapter;

    public PakaianAdapter(ArrayList<Pakaian> pakaianList) {
        this.pakaianList = pakaianList;
    }

    public PakaianAdapter(PakaianFragment context, ArrayList<Pakaian> pakaianList) {
        this.pakaianList = pakaianList;
        mIPakaianAdapter = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listpakaian, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pakaian pakaian = pakaianList.get(position);
        holder.tvJudul.setText(pakaian.judul);
        holder.tvDeskripsi.setText(pakaian.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(pakaian.foto));
    }

    @Override
    public int getItemCount() {
        if (pakaianList != null)
            return pakaianList.size();
        return 0;
    }

    public interface IPakaianAdapter {
        void doClick(int pos);
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

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mIPakaianAdapter.doClick(getAdapterPosition());
                }
            });
        }

    }
}
