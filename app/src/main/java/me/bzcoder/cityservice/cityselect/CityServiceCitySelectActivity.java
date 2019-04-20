package me.bzcoder.cityservice.cityselect;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.bzcoder.app.R;
import me.bzcoder.cityservice.data.CityNameData;


/**
 * 城市选择
 *
 * @author : BaoZhou
 * @date : 2019/1/7 11:27
 */
@Route(path = RouterHub.CITY_SERVICE_CITY_SELECT_ACTIVITY)
public class CityServiceCitySelectActivity extends AppCompatActivity {
    @BindView(R.id.tv_city_select)
    TextView tvCitySelect;
    @BindView(R.id.back_arrow)
    ImageView backArrow;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<CityItem> data;
    private CitySelectAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_service_city_select);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        data = new CityNameData(CityNameData.cityMap.get("HangZhou")).getData();

        //设置RecycleView
        adapter = new CitySelectAdapter(this, data);
        adapter.setOnItemAddListener((name) -> {
            chooseCity(name);
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.setData(CityNameData.getSearchData("HangZhou", s.toString()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @OnClick({R.id.tv_city_select, R.id.back_arrow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_city_select:
                break;
            case R.id.back_arrow:
                finish();
                break;

        }
    }

    private void chooseCity(String cityName) {
        finish();
    }
}
