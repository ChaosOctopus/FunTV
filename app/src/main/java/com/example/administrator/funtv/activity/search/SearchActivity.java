package com.example.administrator.funtv.activity.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.PlayActivity;
import com.example.administrator.funtv.adapter.SearchAdapter;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.PostSearchBean;
import com.example.administrator.funtv.entity.SearchBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements AppContracts.ISearchView{

    @BindView(R.id.iv_back_search)
    ImageView ivBackSearch;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.iv_search_activity)
    ImageView ivSearchActivity;
    @BindView(R.id.search_rv)
    RecyclerView searchRv;
    @BindView(R.id.activity_search)
    LinearLayout activitySearch;
    private List<SearchBean.DataBean.ItemsBean> list;
    private Context context=this;
    private SearchAdapter searchAdapter;
    private String searchstr ;
    private SearchView.SearchAutoComplete editText;
    private SearchPresenterImpl searchPresenter;
    private int page =0;
    private ArrayAdapter<String> Arrayadapter;
    private static final String[] city=new String[]
            {"lol","shanghai","乌鲁木齐市", "北京市", "郑州市", "上海市","天津市", "深圳市", "广州市", "南京市","大连市","大同市"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initData();
        initAdapter();

    }

    private void initAdapter() {
        searchAdapter= new SearchAdapter(list,this);
        searchRv.setLayoutManager(new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false));
        searchRv.setAdapter(searchAdapter);
        searchRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(list.get(position).isPlay_status()){
                    int uid = list.get(position).getUid();
                    String format = String.format(UrlConfigs.PlAY_URL, uid+"");
                    String icon = list.get(position).getAvatar();
                    String title = list.get(position).getTitle();
                    String nick = list.get(position).getNick();
                    Intent intent = new Intent(context, PlayActivity.class);
                    intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,format);
                    intent.putExtra(KeyConfig.KEY_ICON,icon);
                    intent.putExtra(KeyConfig.KEY_NICK,nick);
                    intent.putExtra(KeyConfig.KEY_TITLE,title);
                    startActivity(intent);
                }else{
                    ToastUtils.showTost(context,"主播不在。。");
                }

            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        searchView.setIconifiedByDefault(false);
        Arrayadapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                city);
        editText = (SearchView.SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setAdapter(Arrayadapter);
        editText.clearFocus();
        editText.setThreshold(2);
        editText.setImeActionLabel("搜索",1);

        editText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                CharSequence text = ((TextView) view).getText();
                editText.setText(text);
                editText.setSelection(text.length());

            }
        });
    }
    //TODO设置SearchView
    @OnClick({R.id.iv_back_search, R.id.iv_search_activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_search:
                finish();
                break;

            case R.id.iv_search_activity:
                searchstr = editText.getEditableText()+"";
                JsonObject object = getJson(searchstr,page);
                doSearch(object);
                break;
        }
    }
    public void doSearch(JsonObject object) {
        searchPresenter = new SearchPresenterImpl(this);
        searchPresenter.getData(object);

    }

    private JsonObject getJson(String searchstr, int page) {

        PostSearchBean bean = new PostSearchBean();
        bean.setOs(1);
        bean.setV(2.24f);
        bean.setVer(4f);
        PostSearchBean.p p =bean.new p(page,searchstr);
        bean.setp(p);

        Gson gson = new Gson();
        String json1 = gson.toJson(bean);

        JsonObject object = new JsonParser().parse(json1).getAsJsonObject();
        //JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象
        //String str = json.toString();//将json对象转换为字符串
        Log.e("TAG", "getJson: "+object);
        return object;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void disLoading() {

    }

    @Override
    public void loadSuccess(SearchBean searchBean) {
        int size = searchBean.getData().getItems().size();
        if(size ==0){
            ToastUtils.showTost(this,"找不到相关信息");
        }
//        if(recyclerView.getVisibility()== View.GONE){
//            recyclerView.setVisibility(View.VISIBLE);
//            viewStub.setVisibility(View.GONE);
//        }else{
//            recyclerView.setVisibility(View.GONE);
//            viewStub.setVisibility(View.VISIBLE);
//        }
        list.clear();
        list.addAll(searchBean.getData().getItems());
        searchAdapter.notifyDataSetChanged();

    }

    @Override
    public void loadFail(String error) {

    }

}
