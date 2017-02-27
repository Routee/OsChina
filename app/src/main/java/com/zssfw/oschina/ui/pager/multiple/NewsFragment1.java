package com.zssfw.oschina.ui.pager.multiple;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${资讯页  二级标签}
 */

public class NewsFragment1 extends BaseFragment {
    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        return null;
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public void refresh() {

    }
    //
//    @Bind(R.id.tv_desc)
//    TextView     mTvDesc;
//    @Bind(R.id.ll_point_group)
//    LinearLayout mLlPointGroup;
//    private ListView mListView;
//    private int preousPostion = 0;
//    private ViewPager             mViewPager;
//    private PullToRefreshListView mPullRefreshList;
//    private List<NewsHeadBean.ResultBean.ItemsBean> headItems = new ArrayList<>();
//    private List<NewsBodyBean.ResultBean.ItemsBean> bodyItems = new ArrayList<>();
//    private Handler                                 mHandler  = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            int current = mViewPager.getCurrentItem();
//            mViewPager.setCurrentItem(current + 1);
//            mHandler.sendEmptyMessageDelayed(0, 2000);
//        }
//    };
//    private String mNextPageToken;
//    private String mPageToken = null;
//
//
//    @Override
//    public View createView() {
//
//        View view = View.inflate(getContext(), R.layout.activity_ptr_list, null);
//
//        mPullRefreshList = ((PullToRefreshListView) view.findViewById(R.id.pull_refresh_list));
//        mPullRefreshList.setMode(PullToRefreshBase.Mode.BOTH);
//        mPullRefreshList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
//            @Override
//            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//                mSelectPage.showPage();
//            }
//        });
//        mListView = mPullRefreshList.getRefreshableView();
//        View head = View.inflate(getContext(), R.layout.item_news_head, null);
//        mViewPager = ((ViewPager) head.findViewById(R.id.secondary_viewpager));
//        mListView.addHeaderView(head);
//        ButterKnife.bind(this,view);
//        return view;
//    }
//
//    @Override
//    public Object getData() {
//        haveData = false;
//
//        final NewsHeadBean newsHeadBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_HEAD, NewsHeadBean.class);
//        headItems.clear();
//
//        if (newsHeadBean != null && TextUtils.equals(newsHeadBean.getMessage(), MESSAGE)) {
//            headItems.addAll(newsHeadBean.getResult().getItems());
//
//            Util.runOnUIThread(new Runnable() {
//                @Override
//                public void run() {
//                    //initData();
//                    int offset = Integer.MAX_VALUE / 2 % headItems.size();
//                    mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - offset);
//                    mHandler.sendEmptyMessageDelayed(0, 2000);
//                    mViewPager.setOnTouchListener(new View.OnTouchListener() {
//                        @Override
//                        public boolean onTouch(View view, MotionEvent motionEvent) {
//                            switch (motionEvent.getAction()) {
//                                case MotionEvent.ACTION_DOWN:
//                                    mHandler.removeCallbacksAndMessages(null);
//                                    break;
//                                case MotionEvent.ACTION_UP:
//                                    mHandler.sendEmptyMessageDelayed(0, 2000);
//                                    break;
//                                default:
//                                    break;
//                            }
//                            return false;
//                        }
//                    });
//
//                    mTvDesc.setText(headItems.get(0).getName());
//                    NewsHeadAdapter newsHeadAdapter =  new NewsHeadAdapter(headItems);
//                    mViewPager.setAdapter(newsHeadAdapter);
//                    mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                        @Override
//                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                        }
//
//                        @Override
//                        public void onPageSelected(int position) {
//                            int pos = position % headItems.size();
//                            mTvDesc.setText(headItems.get(pos).getName());
////                            mLlPointGroup.getChildAt(preousPostion).setEnabled(false);
////                            preousPostion = pos;
////                            mLlPointGroup.getChildAt(pos).setEnabled(true);
//                        }
//
//                        @Override
//                        public void onPageScrollStateChanged(int state) {
//
//                        }
//                    });
//                }
//            });
//
//            haveData = true;
//        }
//        PullToRefreshBase.Mode currentMode = mPullRefreshList.getCurrentMode();
//        if (currentMode == PullToRefreshBase.Mode.PULL_FROM_START) {
//            bodyItems.clear();
//            mPageToken = null;
//        }
//
//
//        NewsBodyBean newsBodyBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_BODY + mPageToken, NewsBodyBean.class);
//
//        if (newsBodyBean != null && TextUtils.equals(newsBodyBean.getMessage(), MESSAGE)) {
//            bodyItems.addAll(newsBodyBean.getResult().getItems());
//            mPageToken = newsBodyBean.getResult().getNextPageToken();
//
//            Util.runOnUIThread(new Runnable() {
//                @Override
//                public void run() {
//                    FinalListAdapter<NewsBodyBean.ResultBean.ItemsBean> adapter
//                            =  new FinalListAdapter<>(bodyItems, R.layout.item_news, new FinalListAdapter.OnFinalListAdapterListener<NewsBodyBean.ResultBean.ItemsBean>() {
//                        @Override
//                        public void bindView(FinalListAdapter.FinalListViewHolder holder, NewsBodyBean.ResultBean.ItemsBean item) {
//                            holder.setText(R.id.tv_title, item.getTitle());
//                            holder.setText(R.id.tv_body, item.getBody());
//                            holder.setText(R.id.tv_date, item.getPubDate());
//                            holder.setText(R.id.tv_comment, item.getCommentCount() + "");
//                        }
//                    });
//                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                            String body = bodyItems.get(i - 2).getBody();
////                            System.out.println(body);
//                            String href = bodyItems.get(i-2).getHref();
//                            Intent intent =new Intent(adapterView.getContext(), WebActivity.class);
//                            intent.putExtra("href",href);
//                            startActivity(intent);
//
//
//                        }
//                    });
//                    mPullRefreshList.onRefreshComplete();
//                    mListView.setAdapter(adapter);
//
//                }
//            });
//
//            haveData = true;
//        }
//        return haveData ? "" : null;
//    }
//
//    private void initData() {
//        mLlPointGroup.removeAllViews();
//        for (int i = 0; i < headItems.size(); i++) {
//            ImageView point = new ImageView(getContext());
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(6, 6);
//            if (i != 0) {
//                layoutParams.leftMargin = 5;
//                point.setEnabled(false);
//            }
//            point.setImageResource(R.drawable.select_point_bg);
//            point.setLayoutParams(layoutParams);
//            mLlPointGroup.addView(point);
//        }
//    }
//
//    @Override
//    public void refresh() {
//
//    }
//
//
//
//
//    class NewsHeadAdapter extends BasePagerAdapter<NewsHeadBean.ResultBean.ItemsBean> {
//
//
//        public NewsHeadAdapter(List<NewsHeadBean.ResultBean.ItemsBean> pagerList) {
//            super(pagerList);
//        }
//
//        @Override
//        public View initView(ViewGroup container, int position) {
//            ImageView iv = new ImageView(container.getContext());
//            int pos = position % headItems.size();
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
//
//            Picasso.with(MyApplication.mContent).load(mList.get(pos).getImg()).into(iv);
//
//            return iv;
//        }
//    }

}
