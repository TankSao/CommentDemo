package com.example.administrator.commentdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2018/8/9.
 */

public class CommentView extends LinearLayout{
    private Context mContext;
    private List<Comment> mDatas;
    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        this.mContext = context;
    }

    /**
     * 设置评论列表信息
     *
     * @param list
     */
    public void bindData(List<Comment> list) {
        mDatas = list;
    }



    public void notifyDataSetChanged() {
        removeAllViews();
        if (mDatas == null || mDatas.size() <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 10, 0, 10);
        for (int i = 0; i < mDatas.size(); i++) {
            View view = getView(i);
            if (view == null) {
                throw new NullPointerException("error");
            }
            addView(view, i, layoutParams);
        }
    }

    private View getView(final int position) {
        final Comment item = mDatas.get(position);
        boolean hasReply = false;   // 是否有回复
        if (item.getTag() != null) {
            if(!item.getTag().equals("false")) {
                hasReply = true;
            }
        }
        TextView textView = new TextView(mContext);
        textView.setTextSize(12);
        textView.setTextColor(0xff686868);
        String fromName = item.getFromName();
        String fromId = item.getFromId();
        String toName = item.getToName();
        String toId = item.getToId();
        SpannableStringBuilder builder = new SpannableStringBuilder();

        if (hasReply) {
            builder.append(setClickableSpan(fromName, item));
            builder.append(" 回复 ");
            builder.append(setClickableSpan(toName,item));

        } else {
            builder.append(setClickableSpan(fromName,item));
        }
        builder.append(" : ");
        builder.append(setClickableSpanContent(item.getContent(), item,position));
        builder.append(" ");
        textView.setText(builder);
        // 设置点击背景色
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        return textView;
    }

    /**
     * 设置评论内容点击事件
     *
     * @param item
     * @param bean
     * @param position
     * @return
     */
    public SpannableString setClickableSpanContent(final String item, final Comment bean,final int position) {
        final SpannableString string = new SpannableString(item);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //点击内容
                Toast.makeText(mContext,item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // 设置显示的内容文本颜色
                ds.setColor(0xff686868);
                ds.setUnderlineText(false);
            }
        };
        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;
    }

    /**
     * 设置评论用户名字点击事件
     *
     * @param item
     * @param bean
     * @return
     */
    public SpannableString setClickableSpan(final String item, final Comment bean) {
        final SpannableString string = new SpannableString(item);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //点击名字
                Toast.makeText(mContext,item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // 设置显示的用户名文本颜色
                ds.setColor(Color.parseColor("#3CB371"));
                ds.setUnderlineText(false);
            }
        };

        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;
    }


}




