package np.com.vikashparajuli.mentionname.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import np.com.vikashparajuli.mentionname.R;

/**
 * Created by vikash on 6/28/17.
 */

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.MyViewHolder>{

    private Activity mActivity;
    private ArrayList<String> names;

    public NameAdapter(Activity mActivity, ArrayList<String> names) {
        this.mActivity = mActivity;
        this.names = names;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_row_names, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
        }
    }
}
