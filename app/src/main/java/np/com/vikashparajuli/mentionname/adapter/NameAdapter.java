package np.com.vikashparajuli.mentionname.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import np.com.vikashparajuli.mentionname.R;

/**
 * Created by vikash on 6/28/17.
 */

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.MyViewHolder> {

    private Activity mActivity;
    private ArrayList<String> data;
    private ArrayList<String> dataCopy = new ArrayList<>();
    private RecyclerVisibilityListener listener;

    public NameAdapter(Activity mActivity, ArrayList<String> names) {
        this.mActivity = mActivity;
        this.data = names;
        dataCopy.addAll(data);

        listener = (RecyclerVisibilityListener) mActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_row_names, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filter(String text) {
        data.clear();
        if (text.isEmpty()) {
            data.addAll(dataCopy);
        } else {
            text = text.toLowerCase();
            Log.e("text ===", text);
            for (String item : dataCopy) {
                Log.e("item ===", text);
                if (item.toLowerCase().contains(text)) {
                    data.add(item);
                }
            }
        }
        notifyDataSetChanged();

        if (data.size() == dataCopy.size())
            listener.setVisibility(false);
        else if (data.size() > 0)
            listener.setVisibility(true);
        else listener.setVisibility(false);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
        }
    }

    public interface RecyclerVisibilityListener {
        void setVisibility(boolean bool);
    }
}
