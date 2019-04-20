package me.bzcoder.cityservice.cityselect;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.bzcoder.app.R;


/**
 *
 * @author : BaoZhou
 * @date : 2019/2/15 10:25
 */
public class CitySelectAdapter extends RecyclerView.Adapter {
    private List<CityItem> data = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public CitySelectAdapter(Context context, @NonNull List<CityItem> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (CityEnum.ITEM.getType() == viewType) {
            holder = new CityItemHolder(inflater.inflate(R.layout.layout_city_service_select_content_item, parent, false));
        } else if (CityEnum.TITLE.getType() == viewType) {
            holder = new CityTitleHolder(inflater.inflate(R.layout.layout_city_service_select_content_title, parent, false));
        } else {
            holder = new CityChooseHolder(inflater.inflate(R.layout.layout_city_service_select_content_choose, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (CityEnum.ITEM.getType() == getItemViewType(position)) {
            CityItemHolder holder = (CityItemHolder) viewHolder;
            holder.text.setText(data.get(position).getCityNameCN());
            holder.itemView.setOnClickListener(v -> listener.chooseItem(data.get(position).cityName));
        } else if (CityEnum.TITLE.getType() == getItemViewType(position)) {
            CityTitleHolder holder = (CityTitleHolder) viewHolder;
            holder.text.setText(data.get(position).getCityNameCN());
        }
        if (CityEnum.CHOOSE.getType() == getItemViewType(position)) {
            CityChooseHolder holder = (CityChooseHolder) viewHolder;
            holder.text.setText(data.get(position).getCityNameCN());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getCityEnum().getType();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class CityTitleHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public CityTitleHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_city_name);
        }
    }


    private class CityItemHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public CityItemHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_city_name);
        }
    }


    private class CityChooseHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public CityChooseHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_city_name);
        }
    }


    public interface OnItemAddListener {
        void chooseItem(String name);
    }

    private OnItemAddListener listener;

    public void setOnItemAddListener(OnItemAddListener listener) {
        this.listener = listener;
    }

    public void setData(List<CityItem> data) {
        this.data = data;
    }

}
