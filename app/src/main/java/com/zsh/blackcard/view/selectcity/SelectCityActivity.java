package com.zsh.blackcard.view.selectcity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CityEventModel;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.StatusBarColorUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 选择城市
 *
 * @author sxj 2016/01/08
 */
public class SelectCityActivity extends Activity implements OnScrollListener {
    /**
     * a-z排序
     */
    @SuppressWarnings("rawtypes")
    Comparator comparator = new Comparator<City>() {
        @Override
        public int compare(City lhs, City rhs) {
            String a = lhs.getPinyi().substring(0, 1);
            String b = rhs.getPinyi().substring(0, 1);
            int flag = a.compareTo(b);
            if (flag == 0) {
                return a.compareTo(b);
            } else {
                return flag;
            }
        }
    };
    private BaseAdapter adapter;
    private ResultListAdapter resultListAdapter;
    private ListView personList;
    private ListView resultList;
    private TextView overlay; // 对话框首字母textview
    private MyLetterListView letterListView; // A-Z listview
    private Map<String, Integer> alphaIndexer; // 存放存在的汉语拼音首字母和与之对应的列表位置
    private String[] sections; // 存放存在的汉语拼音首字母
    private Handler handler;
    private OverlayThread overlayThread; // 显示首字母对话框
    private List<City> allCity_lists; // 所有城市列表
    private List<City> city_lists; // 城市列表
    private List<City> city_hot;
    private List<City> city_result;
    private EditText sh;
    private TextView tv_noresult;
    // private String currentCity;
    // private int locateProcess = 1;
    //   private boolean isNeedFresh;
    // private DatabaseHelper helper;
    private ImageView select_back;
    private String allCity = null;


    //	public void InsertCity(String name) {
//		SQLiteDatabase db = helper.getReadableDatabase();
//		Cursor cursor = db.rawQuery("select * from recentcity where name = '"
//				+ name + "'", null);
//		if (cursor.getCount() > 0) { //
//			db.delete("recentcity", "name = ?", new String[] { name });
//		}
//		db.execSQL("insert into recentcity(name, date) values('" + name + "', "
//				+ System.currentTimeMillis() + ")");
//		db.close();
//	}
    private boolean mReady;
    // 初始化汉语拼音首字母弹出提示框
    private WindowManager windowManager;
    private boolean isScroll = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarColorUtil.setStatusBarColor(this);
        setContentView(R.layout.activity_select_city);

        allCity = getIntent().getStringExtra("allCity");
        personList = (ListView) findViewById(R.id.list_view);
        allCity_lists = new ArrayList<City>();
        city_hot = new ArrayList<City>();
        city_result = new ArrayList<City>();
        resultList = (ListView) findViewById(R.id.search_result);
        sh = (EditText) findViewById(R.id.sh);
        tv_noresult = (TextView) findViewById(R.id.tv_noresult);
        //  helper = new DatabaseHelper(this);
        select_back = (ImageView) findViewById(R.id.im_back);
        select_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cityFinish();
            }
        });

        sh.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString() == null || "".equals(s.toString())) {
                    letterListView.setVisibility(View.VISIBLE);
                    personList.setVisibility(View.VISIBLE);
                    resultList.setVisibility(View.GONE);
                    tv_noresult.setVisibility(View.GONE);
                } else {
                    city_result.clear();
                    letterListView.setVisibility(View.GONE);
                    personList.setVisibility(View.GONE);
                    getResultCityList(s.toString());
                    if (city_result.size() <= 0) {
                        tv_noresult.setVisibility(View.VISIBLE);
                        resultList.setVisibility(View.GONE);
                    } else {
                        tv_noresult.setVisibility(View.GONE);
                        resultList.setVisibility(View.VISIBLE);
                        resultListAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (null != resultListAdapter) {
                    resultListAdapter.notifyDataSetChanged();
                }
            }
        });
        letterListView = (MyLetterListView) findViewById(R.id.MyLetterListView01);
        letterListView.setOnTouchingLetterChangedListener(new LetterListViewListener());
        alphaIndexer = new HashMap<String, Integer>();
        handler = new Handler();
        overlayThread = new OverlayThread();
        // isNeedFresh = true;
        personList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position >= 2) {
                    // 全部城市
                    postCityEvent(allCity_lists.get(position).getName());
                }
            }
        });
        // locateProcess = 1;
        personList.setAdapter(adapter);
        personList.setOnScrollListener(this);
        resultListAdapter = new ResultListAdapter(this, city_result);
        resultList.setAdapter(resultListAdapter);
        resultList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 搜索结果 城市
                postCityEvent(city_result.get(position).getName());
            }
        });
        initOverlay();
        cityInit();
        hotCityInit();
        setAdapter(allCity_lists, city_hot);

    }

    private void cityInit() {
        City city = new City("热门", "0"); // 热门城市
        allCity_lists.add(city);
        city = new City("全部", "1"); // 全部城市
        allCity_lists.add(city);
        city_lists = getCityList();
        allCity_lists.addAll(city_lists);
    }

    /**
     * 热门城市
     */
    public void hotCityInit() {
        City city;
        if (null != allCity) {
            city = new City("全部城市", "0");
            city_hot.add(city);
        }
        city = new City("北京", "0");
        city_hot.add(city);
        city = new City("上海", "0");
        city_hot.add(city);
        city = new City("广州", "0");
        city_hot.add(city);
        city = new City("深圳", "0");
        city_hot.add(city);
        city = new City("武汉", "0");
        city_hot.add(city);
        city = new City("天津", "0");
        city_hot.add(city);

    }

    @SuppressWarnings("unchecked")
    private List<City> getCityList() {
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<City> list = new ArrayList<City>();
        try {
            dbHelper.createDataBase();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from city", null);
            City city;
            while (cursor.moveToNext()) {
                city = new City(cursor.getString(1), cursor.getString(2));
                list.add(city);
            }
            cursor.close();
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list, comparator);
        return list;
    }

    @SuppressWarnings("unchecked")
    private void getResultCityList(String keyword) {
        DBHelper dbHelper = new DBHelper(this);
        try {
            dbHelper.createDataBase();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery(
                    "select * from city where name like \"%" + keyword
                            + "%\" or pinyin like \"%" + keyword + "%\"", null);
            City city;
            LogUtils.e("info", "length = " + cursor.getCount());
            while (cursor.moveToNext()) {
                city = new City(cursor.getString(1), cursor.getString(2));
                city_result.add(city);
            }
            cursor.close();
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(city_result, comparator);
    }

    private void setAdapter(List<City> list, List<City> hotList) {
        adapter = new ListAdapter(this, list, hotList);
        personList.setAdapter(adapter);
    }

    private void postCityEvent(String city) {
        EventBus.getDefault().post(new CityEventModel(city));
        cityFinish();
    }

    public void cityFinish() {
        finish();
        windowManager.removeView(overlay);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }

    private void initOverlay() {
        mReady = true;
        LayoutInflater inflater = LayoutInflater.from(this);
        overlay = (TextView) inflater.inflate(R.layout.overlay_city, null);
        overlay.setVisibility(View.GONE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        windowManager = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(overlay, lp);
    }

    // 获得汉语拼音首字母
    private String getAlpha(String str) {
        if (str == null) {
            return "#";
        }
        if (str.trim().length() == 0) {
            return "#";
        }
        char c = str.trim().substring(0, 1).charAt(0);
        // 正则表达式，判断首字母是否是英文字母
        Pattern pattern = Pattern.compile("^[A-Za-z]+$");
        if (pattern.matcher(c + "").matches()) {
            return (c + "").toUpperCase();
        } else if (str.equals("0")) {
            return "热门";
        } else if (str.equals("1")) {
            return "全部";
        } else {
            return "#";
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_TOUCH_SCROLL
                || scrollState == SCROLL_STATE_FLING) {
            isScroll = true;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (!isScroll) {
            return;
        }

        if (mReady) {
            String text;
            String name = allCity_lists.get(firstVisibleItem).getName();
            String pinyin = allCity_lists.get(firstVisibleItem).getPinyi();
            if (firstVisibleItem < 2) {
                text = name;
            } else {
                text = PingYinUtil.converterToFirstSpell(pinyin)
                        .substring(0, 1).toUpperCase();
            }
            overlay.setText(text);
            overlay.setVisibility(View.VISIBLE);
            handler.removeCallbacks(overlayThread);
            // 延迟一秒后执行，让overlay为不可见
            handler.postDelayed(overlayThread, 1000);
        }
    }

    private class ResultListAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<City> results = new ArrayList<City>();

        public ResultListAdapter(Context context, List<City> results) {
            inflater = LayoutInflater.from(context);
            this.results = results;
        }

        @Override
        public int getCount() {
            return results.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item_city, null);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView
                        .findViewById(R.id.name);
                viewHolder.rl_alpha = (RelativeLayout) convertView.findViewById(R.id.rl_alpha);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.rl_alpha.setVisibility(View.GONE);
            viewHolder.name.setText(results.get(position).getName());
            return convertView;
        }

        class ViewHolder {
            TextView name;
            RelativeLayout rl_alpha;
        }
    }

    public class ListAdapter extends BaseAdapter {
        static final int VIEW_TYPE = 3;
        ViewHolder holder;
        private Context context;
        private LayoutInflater inflater;
        private List<City> list;
        private List<City> hotList;

        public ListAdapter(Context context, List<City> list, List<City> hotList) {
            this.inflater = LayoutInflater.from(context);
            this.list = list;
            this.context = context;
            this.hotList = hotList;

            alphaIndexer = new HashMap<String, Integer>();
            sections = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                // 当前汉语拼音首字母
                String currentStr = getAlpha(list.get(i).getPinyi());
                // 上一个汉语拼音首字母，如果不存在为" "
                String previewStr = (i - 1) >= 0 ? getAlpha(list.get(i - 1)
                        .getPinyi()) : " ";
                if (!previewStr.equals(currentStr)) {
                    String name = getAlpha(list.get(i).getPinyi());
                    alphaIndexer.put(name, i);
                    sections[i] = name;
                }
            }
        }

        @Override
        public int getViewTypeCount() {
            return VIEW_TYPE;
        }

        @Override
        public int getItemViewType(int position) {
            return position < 2 ? position : 2;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            int viewType = getItemViewType(position);
            if (viewType == 0) {
                convertView = inflater.inflate(R.layout.hot_city, null);
                GridView hotCity = (GridView) convertView
                        .findViewById(R.id.recent_city);
                hotCity.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        postCityEvent(city_hot.get(position).getName());
                    }
                });
                hotCity.setAdapter(new HotCityAdapter(context, this.hotList));
                TextView hotHint = (TextView) convertView
                        .findViewById(R.id.recentHint);
                hotHint.setText("热门城市");
            } else if (viewType == 1) {
                convertView = inflater.inflate(R.layout.total_item_city, null);
            } else {
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.list_item_city, null);
                    holder = new ViewHolder();
                    holder.alpha = (TextView) convertView
                            .findViewById(R.id.alpha);
                    holder.rl_alpha = (RelativeLayout) convertView
                            .findViewById(R.id.rl_alpha);
                    holder.name = (TextView) convertView
                            .findViewById(R.id.name);
                    // holder.line = (View) convertView.findViewById(R.id.line);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                if (position >= 1) {
                    holder.name.setText(list.get(position).getName());
                    String currentStr = getAlpha(list.get(position).getPinyi()); // 标题
                    // ABCD
                    String previewStr = (position - 1) >= 0 ? getAlpha(list.get(position - 1).getPinyi()) : " ";
                    if (!previewStr.equals(currentStr)) {
                        holder.alpha.setVisibility(View.VISIBLE);
                        holder.rl_alpha.setVisibility(View.VISIBLE);
                        holder.alpha.setText(currentStr);
                        // holder.line.setVisibility(View.VISIBLE);
                    } else {
                        holder.alpha.setVisibility(View.GONE);
                        holder.rl_alpha.setVisibility(View.GONE);
                    }
                }
            }
            return convertView;
        }

        private class ViewHolder {
            RelativeLayout rl_alpha;
            TextView alpha; // 首字母标题
            TextView name; // 城市名字
            // View line;
        }
    }

    class HotCityAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private List<City> hotCitys;

        public HotCityAdapter(Context context, List<City> hotCitys) {
            this.context = context;
            inflater = LayoutInflater.from(this.context);
            this.hotCitys = hotCitys;
        }

        @Override
        public int getCount() {
            return hotCitys.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_city, null);
            TextView city = (TextView) convertView.findViewById(R.id.city);
            city.setText(hotCitys.get(position).getName());
            return convertView;
        }
    }

    class HitCityAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private List<String> hotCitys;

        public HitCityAdapter(Context context, List<String> hotCitys) {
            this.context = context;
            inflater = LayoutInflater.from(this.context);
            this.hotCitys = hotCitys;
        }

        @Override
        public int getCount() {
            return hotCitys.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_city, null);
            TextView city = (TextView) convertView.findViewById(R.id.city);
            city.setText(hotCitys.get(position));
            return convertView;
        }
    }

    private class LetterListViewListener implements
            MyLetterListView.OnTouchingLetterChangedListener {

        @Override
        public void onTouchingLetterChanged(final String s) {
            isScroll = false;
            if (alphaIndexer.get(s) != null) {
                int position = alphaIndexer.get(s);
                personList.setSelection(position);
                overlay.setText(s);
                overlay.setVisibility(View.VISIBLE);
                handler.removeCallbacks(overlayThread);
                // 延迟一秒后执行，让overlay为不可见
                handler.postDelayed(overlayThread, 1000);
            }
        }
    }

    // 设置overlay不可见
    private class OverlayThread implements Runnable {
        @Override
        public void run() {
            overlay.setVisibility(View.GONE);
        }
    }
}
