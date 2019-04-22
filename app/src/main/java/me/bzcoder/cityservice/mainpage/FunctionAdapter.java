package me.bzcoder.cityservice.mainpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.bzcoder.app.R;


public class FunctionAdapter extends RecyclerView.Adapter {


    private List<FunctionItem> data = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;

    public FunctionAdapter(Context context, @NonNull List<FunctionItem> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (ServiceEnum.TITLE.getType() == viewType) {
            holder = new TitleViewHolder(inflater.inflate(R.layout.layout_city_service_function_text, parent, false));
        } else if (ServiceEnum.FOUR_ONE_LINE.getType() == viewType || ServiceEnum.TWO_ONE_LINE.getType() == viewType) {
            holder = new FunctionViewHolder(inflater.inflate(R.layout.layout_city_service_grid_item, parent, false));
        } else {
            holder = new BlankViewHolder(inflater.inflate(R.layout.layout_city_service_blank_item, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (ServiceEnum.TITLE.getType() == getItemViewType(position)) {
            TitleViewHolder holder = (TitleViewHolder) viewHolder;
            holder.text.setText("| " + data.get(position).getName());
        } else if (ServiceEnum.FOUR_ONE_LINE.getType() == getItemViewType(position) ||
                ServiceEnum.TWO_ONE_LINE.getType() == getItemViewType(position)) {
            FunctionViewHolder holder = (FunctionViewHolder) viewHolder;
            if (ServiceEnum.FOUR_ONE_LINE.getType() == getItemViewType(position)) {
                holder.rl.setBackgroundResource(R.mipmap.service_square);
            } else {
                holder.rl.setBackgroundResource(R.mipmap.city_service_long_square);
            }
            holder.iv.setImageResource(data.get(position).getRes());
            holder.iv.setOnClickListener(v -> {
                if(listener!=null){
                    listener.startActivity(data.get(position));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getServiceEnum().getType();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public TitleViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }

    private class FunctionViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private RelativeLayout rl;

        public FunctionViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_service);
            rl = itemView.findViewById(R.id.rl_bg);
        }
    }

    private class BlankViewHolder extends RecyclerView.ViewHolder {


        public BlankViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemAddListener {
        void startActivity(FunctionItem item);
    }

    private OnItemAddListener listener;

    public void setOnItemAddListener(OnItemAddListener listener) {
        this.listener = listener;
    }


    public void setData(List<FunctionItem> data) {
        this.data = data;
    }

}
