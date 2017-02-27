package com.zssfw.oschina.ui.pager.plus;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.BaseRecyclerViewAdapter;
import com.zssfw.oschina.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class PlusPager extends BaseFragment implements BaseRecyclerViewAdapter.OnItemClickListener {

    @Bind(R.id.edittext)
    EditText  mEdittext;
    @Bind(R.id.iv_picture)
    ImageView mIvPicture;
    @Bind(R.id.iv_mention)
    ImageView mIvMention;
    @Bind(R.id.iv_trend)
    ImageView mIvTrend;
    @Bind(R.id.iv_emoji)
    ImageView mIvEmoji;

    private List<Integer> list        = new ArrayList<>();
    private boolean       isEmojiOpen = false;
    private String[]     mEmojis;
    private RecyclerView mRecyclerview;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private boolean isKeyOpen;
    private int minH = 0;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        final View view = View.inflate(getContext(), R.layout.fragment_stair_plus, null);
        ButterKnife.bind(this, view);
        mRecyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);

        for (int i = 0; i < Constant.EMOJI.length; i++) {
            list.add(Constant.EMOJI[i]);
        }
        BaseRecyclerViewAdapter recyclerViewAdapter = new BaseRecyclerViewAdapter(list);
        mRecyclerview.setLayoutManager(new GridLayoutManager(getContext(), 6, GridLayout.VERTICAL, false));
        mRecyclerview.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(this);

        mEdittext.setText("123456789");


        mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /**
             * the result is pixels
             */
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                view.getWindowVisibleDisplayFrame(r);
                int screenHeight = view.getRootView().getHeight();
                int heightDifference = screenHeight - (r.bottom - r.top);
                isKeyOpen = heightDifference > screenHeight / 3;
                if (isKeyOpen) {
                    ViewGroup.LayoutParams layoutParams = mRecyclerview.getLayoutParams();
                    layoutParams.height = heightDifference-minH;//获取输入法高度
                    mRecyclerview.setLayoutParams(layoutParams);
                } else {
                    minH = heightDifference;//底部导航栏高度
                }

            }
        };
        view.getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);

        mEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerview.setVisibility(View.GONE);
                isEmojiOpen = false;
            }
        });
        return view;
    }

    @Override
    public Object getData() {
        return "";
    }


    @Override
    public void refresh() {

    }


    @OnClick({R.id.iv_picture, R.id.iv_mention, R.id.iv_trend, R.id.iv_emoji})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_picture:
                break;
            case R.id.iv_mention:
                break;
            case R.id.iv_trend:
                break;
            case R.id.iv_emoji:

                if (isEmojiOpen) {
                    mRecyclerview.setVisibility(View.GONE);
                } else {
                    if (isKeyOpen) {
                        //关
                        ((InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE))
                                .hideSoftInputFromWindow(
                                        getActivity().getCurrentFocus().getWindowToken(),
                                        InputMethodManager.HIDE_NOT_ALWAYS);
                    } else {
                        //直接开
                    }

                    mRecyclerview.setVisibility(View.VISIBLE);
                }
                isEmojiOpen = !isEmojiOpen;
                break;
        }
    }

    private void deleteSelected() {//删除选中部分
        int selectionStart = mEdittext.getSelectionStart();
        int selectionEnd = mEdittext.getSelectionEnd();
        mEdittext.getText().delete(selectionStart, selectionEnd);
    }


    @Override//emoji表情点击
    public void onItemClick(int position) {
        if (mEmojis == null)
            mEmojis = getResources().getStringArray(R.array.qq_emoji_vals);

        SpannableString spannableString = new SpannableString(mEmojis[position]);
        int id = getResources().getIdentifier("smiley_" + position, "mipmap", getContext().getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, 50, 50);
        ImageSpan imageSpan = new ImageSpan(drawable);

        spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        deleteSelected();
        mEdittext.getText().insert(mEdittext.getSelectionStart(), spannableString);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //移除布局变化监听
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(mOnGlobalLayoutListener);
        } else {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        }
    }
}
