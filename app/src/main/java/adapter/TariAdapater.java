package adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import activity.TariFragment;
import id.sch.smktelkom_mlg.project.xiirpl207172737.indonesia.R;
import model.Tari;

/**
 * Created by Shafira Pramatana on 11/16/2016.
 */
public class TariAdapater extends RecyclerView.Adapter<TariAdapater.ViewHolder> {
    ArrayList<Tari> tariList;
    ITariAdapter mITariAdapter;

    public TariAdapater(ArrayList<Tari> tariList) {
        this.tariList = tariList;
    }

    public TariAdapater(TariFragment context, ArrayList<Tari> tariList) {
        this.tariList = tariList;
        mITariAdapter = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listtari, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tari tari = tariList.get(position);
        holder.tvJudul.setText(tari.judul);
        holder.tvDeskripsi.setText(tari.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(tari.foto));
    }

    @Override
    public int getItemCount() {
        if (tariList != null)
            return tariList.size();
        return 0;
    }

    public interface ITariAdapter {
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
                    mITariAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
