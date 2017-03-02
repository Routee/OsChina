package com.zssfw.oschina.ui.pager.multiple;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.BasePagerAdapter;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.NewsBodyBean;
import com.zssfw.oschina.bean.NewsHeadBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.show.BlogDetailsFragment;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.DensityUtil;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.type;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;
import static com.zssfw.oschina.util.Constant.NEWS_BODY;
import static com.zssfw.oschina.util.Constant.NEWS_HEAD;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${资讯页  二级标签}
 */

public class NewsFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnTouchListener {

    private ViewPager mViewPager;
    private ListView  mListView;
    private List<NewsHeadBean.ResultBean.ItemsBean> headItems = new ArrayList<>();
    private List<NewsBodyBean.ResultBean.ItemsBean> bodyItems = new ArrayList<>();
    private TextView   mHead_title;
    private RadioGroup mRadioGroup;
    private       int     mCurrentItem = 0;
    private final int     START        = 1;
    private       Handler mHandler     = new Handler();
    private Runnable                                            mRunnable;
    private SwipeRefreshLayout                                  mSwipeRefreshLayout;
    private NewsHeadAdapter                                     mNewsHeadAdapter;
    private FinalListAdapter<NewsBodyBean.ResultBean.ItemsBean> mNewsBodyAdapter;
    private String                                              mNextPageToken;
    private int mDownX;
    private int mDownY;
    private int mEX;
    private int mEY;


    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_secondary, null);
        mListView = ((ListView) view.findViewById(R.id.secondary_listview));
        mSwipeRefreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.swiperefresh));

        View head = View.inflate(getContext(), R.layout.item_news_head, null);
        mViewPager = ((ViewPager) head.findViewById(R.id.secondary_viewpager));
        mHead_title = (TextView) head.findViewById(R.id.head_title);
        mRadioGroup = (RadioGroup) head.findViewById(R.id.radiogroup);
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setOnTouchListener(this);

        mListView.addHeaderView(head);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int lastVisiblePosition = mListView.getLastVisiblePosition();
                if (lastVisiblePosition == mNewsBodyAdapter.getCount()) {
                    System.out.println(lastVisiblePosition + "----" + mNewsBodyAdapter.getCount());
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            getBodyData(mNextPageToken);
                        }
                    }.start();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        return view;
    }

    @Override
    public Object getData() {//默认加载数据
        System.out.println("资讯刷新");
        haveData = false;
        NewsHeadBean newsHeadBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_HEAD, NewsHeadBean.class);
        if (newsHeadBean != null && TextUtils.equals(newsHeadBean.getMessage(), MESSAGE)) {
            headItems.clear();
            headItems.addAll(newsHeadBean.getResult().getItems());
            Util.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    showHead();

                }
            });
            haveData = true;
        }

        getBodyData("");
        //        SystemClock.sleep(1000);
        //        mSwipeRefreshLayout.setRefreshing(false);//停止刷新
        return haveData ? "" : null;
    }

    private void getBodyData(String pageToken) {//加载列表数据
        NewsBodyBean newsBodyBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_BODY + pageToken, NewsBodyBean.class);
        if (newsBodyBean != null && TextUtils.equals(newsBodyBean.getMessage(), MESSAGE)) {
            mNextPageToken = newsBodyBean.getResult().getNextPageToken();

            if (TextUtils.isEmpty(pageToken)) {
                bodyItems.clear();
            }
            bodyItems.addAll(newsBodyBean.getResult().getItems());

            Util.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    showBody();
                }


            });
            haveData = true;
        }
    }

    //获取数据后 显示头部 小圆点
    private void showHead() {
        if (mNewsHeadAdapter == null) {
            mNewsHeadAdapter = new NewsHeadAdapter(headItems);
            mViewPager.setAdapter(mNewsHeadAdapter);
        } else {
            mNewsHeadAdapter.notifyDataSetChanged();
        }

        mHead_title.setText(headItems.get(mCurrentItem).getName());

        if (mRadioGroup.getChildCount() != headItems.size()) {//如果轮播图数量没变,小圆点不重画了
            int margin = DensityUtil.dip2px(getContext(), 5);
            int width = DensityUtil.dip2px(getContext(), 8);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(width, width);
            layoutParams.setMargins(0, 0, margin, 0);
            mRadioGroup.removeAllViews();
            for (int i = 0; i < headItems.size(); i++) {
                RadioButton radioButton = new RadioButton(getContext());
                //            radioButton.setBackgroundResource(R.drawable.selector_radio);
                radioButton.setButtonDrawable(R.drawable.selector_radio);
                radioButton.setLayoutParams(layoutParams);
                radioButton.setId(i);
                mRadioGroup.addView(radioButton);

            }
            mRadioGroup.check(mCurrentItem);
            mViewPager.setCurrentItem(mCurrentItem);
        }
        //第一次创建定时器 往后刷新后重新设置一下
        if (mRunnable != null) {
            mHandler.removeCallbacks(mRunnable);
        } else {
            mRunnable = new Runnable() {
                @Override
                public void run() {
                    if (mCurrentItem < headItems.size()) {
                        mViewPager.setCurrentItem(mCurrentItem++);

                    } else {
                        mViewPager.setCurrentItem(mCurrentItem = 0);
                    }
                    mHandler.postDelayed(this, 2000);
                }
            };
        }
        mHandler.postDelayed(mRunnable, 2000);

    }

    //显示新闻列表
    private void showBody() {
        //listview的条目点击
        // TODO: 2017/2/25 浏览器打开
        if (mNewsBodyAdapter == null) {


            mNewsBodyAdapter = new FinalListAdapter<NewsBodyBean.ResultBean.ItemsBean>(bodyItems, R.layout.item_news, new FinalListAdapter.OnFinalListAdapterListener<NewsBodyBean.ResultBean.ItemsBean>() {
                @Override
                public void bindView(FinalListAdapter.FinalListViewHolder holder, NewsBodyBean.ResultBean.ItemsBean item) {
                    TextView title = (TextView) holder.getView(R.id.tv_title);
                    if (Util.isToday(item.getPubDate())) {
                        SpannableString ss = new SpannableString(" 今  " + item.getTitle());
                        ss.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ss.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ss.setSpan(new RelativeSizeSpan(0.7f), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        title.setText(ss);
                    } else {
                        title.setText(item.getTitle());
                    }

                    holder.setText(R.id.tv_body, item.getBody());
                    holder.setText(R.id.tv_date, Util.parseTime(item.getPubDate()));
                    holder.setText(R.id.tv_comment, item.getCommentCount() + "");
                }
            }) {
                @Override//listview的条目点击
                public void onItemClick(int position) {
                    super.onItemClick(position);
                    NewsBodyBean.ResultBean.ItemsBean itemsBean = bodyItems.get(position);
                    if (itemsBean.getType() == 0) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(itemsBean.getHref()));
                        startActivity(intent);
                        return;
                    }
                    if (itemsBean.getType() == 6) {
                        startShowActivityWithType(itemsBean.getType(), itemsBean.getCommentCount(), itemsBean.getId(), NewsDetailsFragment.class);
                        System.out.println("type:" + type + itemsBean.getType());
                        return;
                    }
                    // TODO: 2017/2/26 先统一处理
                    startShowActivity2("类型" + itemsBean.getType(), itemsBean.getCommentCount(), itemsBean.getHref(), BlogDetailsFragment.class);
                }
            };
            mListView.setAdapter(mNewsBodyAdapter);
        } else {
            mNewsBodyAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void refresh() {

    }

    @Override//RadioGroup选中
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mHead_title.setText(headItems.get(checkedId).getName());
    }

    @Override//viewpager 滑动
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override//viewpager 选中
    public void onPageSelected(int position) {
        mRadioGroup.check(position);
        mCurrentItem = position;
    }

    @Override//viewpager 滑动方式改变
    public void onPageScrollStateChanged(int state) {

    }

    @Override//轮播关闭
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
        System.out.println("轮播关闭");
    }

    @Override//轮播开始
    public void onStart() {
        super.onStart();
        if (mHandler != null) {
            mHandler.postDelayed(mRunnable, 2000);
        }
        System.out.println("轮播开始");
    }


    @Override//viewpager 触摸事件
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = (int) event.getX();
                mDownY = (int) event.getY();
                mHandler.removeCallbacks(mRunnable);

                break;
            case MotionEvent.ACTION_MOVE:
                mEX = (int) event.getX();
                mEY = (int) event.getY();
                int diffX=mEX-mDownX;
                int diffY=mEY-mDownY;
                int diffXY=Math.abs(diffX)-Math.abs(diffY);
                if (diffXY >= 0) {
                    mSwipeRefreshLayout.setEnabled(false);
                } else {
                    mSwipeRefreshLayout.setEnabled(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                mHandler.postDelayed(mRunnable, 2000);
                break;
            default:
                break;
        }
        return false;
    }

    //        @Override//下拉刷新监听
    //        public void onRefresh() {
    //            getData();
    //        }

    class NewsHeadAdapter extends BasePagerAdapter<NewsHeadBean.ResultBean.ItemsBean> {

        public NewsHeadAdapter(List<NewsHeadBean.ResultBean.ItemsBean> pagerList) {
            super(pagerList);
        }

        @Override
        public View initView(ViewGroup container, int position) {
            ImageView iv = new ImageView(container.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(MyApplication.mContent).load(mList.get(position).getImg()).into(iv);
            return iv;
        }
    }

}
