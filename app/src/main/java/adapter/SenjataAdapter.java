package adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import activity.SenjataFragment;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Senjata;

/**
 * Created by Shafira Pramatana on 11/20/2016.
 */
public class SenjataAdapter extends RecyclerView.Adapter<SenjataAdapter.ViewHolder> {
    ArrayList<Senjata> senjataList;
    ISenjataAdapter mISenjataAdapter;

    public SenjataAdapter(ArrayList<Senjata> senjataList) {
        this.senjataList = senjataList;
    }

    public SenjataAdapter(SenjataFragment context, ArrayList<Senjata> senjataList) {
        this.senjataList = senjataList;
        mISenjataAdapter = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listsenjata, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Senjata senjata = senjataList.get(position);
        holder.tvJudul.setText(senjata.judul);
        holder.tvDeskripsi.setText(senjata.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(senjata.foto));
    }

    @Override
    public int getItemCount() {
        if (senjataList != null)
            return senjataList.size();
        return 0;
    }

    public interface ISenjataAdapter {
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
                    mISenjataAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
