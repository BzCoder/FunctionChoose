package me.bzcoder.cityservice.mainpage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.bzcoder.app.R;
import me.bzcoder.cityservice.cityselect.RouterHub;
import me.bzcoder.cityservice.data.CityData;
import me.bzcoder.cityservice.data.CityNameData;
import me.bzcoder.cityservice.data.CityServiceDateFactory;

/**
 * 城市服务
 *
 * @author : BaoZhou
 * @date : 2018/12/20 16:18
 */

@Route(path = RouterHub.CITY_SERVICE_ACTIVITY)
public class CityServiceActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.fl_wrapper)
    FrameLayout flWrapper;
    @BindView(R.id.tv_city_select)
    TextView tvCitySelect;

    private List<FunctionItem> data = new ArrayList<>();
    private List<String> titleData = new ArrayList<>();
    private Map<Integer, Integer> itemPosToTabPos = new HashMap<>(), tabPosToItemPos = new HashMap<>();
    private GridLayoutManager gridManager;
    private TopSmoothScroller mScroller;
    private FunctionAdapter functionAdapter;
    private boolean isClick = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_service);
        ButterKnife.bind(this);
        loadData();
    }

    public void loadData() {
        tabLayout.clearOnTabSelectedListeners();
        recyclerView.clearOnScrollListeners();
        tabLayout.removeAllTabs();
        titleData.clear();
        itemPosToTabPos.clear();
        tabPosToItemPos.clear();

        if (mScroller == null) {
            mScroller = new TopSmoothScroller(this);
        }
        if (gridManager == null) {
            gridManager = new GridLayoutManager(this, 4);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (data.get(position).getServiceEnum().equals(ServiceEnum.TITLE) || data.get(position).getServiceEnum().equals(ServiceEnum.BLANK)) {
                        return 4;
                    } else if (data.get(position).getServiceEnum().equals(ServiceEnum.TWO_ONE_LINE)) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            });
        }

        tvCitySelect.setText("城市服务·" + CityNameData.cityMap.get("HangZhou"));


        try {
            CityData cityData = CityServiceDateFactory.CityServiceDateFactory("HangZhou");
            data = cityData.getData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //设置RecycleView
        if (functionAdapter == null) {
            functionAdapter = new FunctionAdapter(this, data);
//            functionAdapter.setOnItemAddListener(item -> DispatchActivity.launchToWebActivity(item.getUrl()));
            recyclerView.setLayoutManager(gridManager);
            recyclerView.setAdapter(functionAdapter);
        } else {
            functionAdapter.setData(data);
            functionAdapter.notifyDataSetChanged();
        }

        //设置TabLayout
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getServiceEnum().equals(ServiceEnum.TITLE)) {
                titleData.add(data.get(i).getName());
                tabLayout.addTab(tabLayout.newTab().setText(data.get(i).getName()));
                tabPosToItemPos.put(tabPosToItemPos.size(), i);
            }
            itemPosToTabPos.put(i, titleData.size() - 1);
        }

        //设置TabView
        for (int i = 0; i < titleData.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
            }
            if (i == 0) {
                updateTabTextView(tab, true);
            }
        }


        //滑动关联
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                             @Override
                                             public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                                 super.onScrollStateChanged(recyclerView, newState);
                                                 if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                                                     isClick = false;
                                                 }
                                             }

                                             @Override
                                             public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                                 super.onScrolled(recyclerView, dx, dy);
                                                 //让tab来处理滑动
                                                 if (isClick) {
                                                     return;
                                                 }
                                                 Integer select = gridManager.findFirstVisibleItemPosition();
                                                 tabLayout.getTabAt(itemPosToTabPos.get(select)).select();
                                             }
                                         }
        );

        flWrapper.setOnTouchListener((v, event) -> {
            isClick = true;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    flWrapper.performClick();
                    break;
            }
            return false;
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()

        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    updateTabTextView(tab, true);
                    if (!isClick) {
                        return;
                    }
                    moveToPosition(tabPosToItemPos.get(tab.getPosition()));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabTextView(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        moveToPosition(0);

    }


    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {

        if (isSelect) {
            //选中加粗
            TextView tabSelect = tab.getCustomView().findViewById(R.id.tab_item_textview);
            tabSelect.setTextColor(Color.parseColor("#FFFFFF"));
            tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tabSelect.setText(tab.getText());
        } else {
            TextView tabUnSelect = tab.getCustomView().findViewById(R.id.tab_item_textview);
            tabUnSelect.setTextColor(Color.parseColor("#BDD4FB"));
            tabUnSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            tabUnSelect.setText(tab.getText());
        }
    }

    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(this).inflate(R.layout.city_service_tab_item, null);
        TextView textView = view.findViewById(R.id.tab_item_textview);
        textView.setText(titleData.get(currentPosition));

        return view;
    }

    private void moveToPosition(int n) {
        mScroller.setTargetPosition(n);
        gridManager.startSmoothScroll(mScroller);
        ARouter.getInstance().destroy();
    }

    @OnClick({R.id.tv_city_select, R.id.back_arrow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_city_select:
//                ARouter.getInstance().build(RoutePath.CITY_SERVICE_CITY_SELECT_ACTIVITY)
//                        .navigation(CityServiceActivity.this, 101);
                break;
            case R.id.back_arrow:
                finish();
                break;
        }
    }


    public class TopSmoothScroller extends LinearSmoothScroller {
        TopSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected int getHorizontalSnapPreference() {
            return SNAP_TO_START;//具体见源码注释
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;//具体见源码注释
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loadData();
    }


}


