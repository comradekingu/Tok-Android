package com.client.tok.ui.chat2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.client.tok.R;
import com.client.tok.bean.Message;
import com.client.tok.constant.MessageType;
import com.client.tok.media.player.audio.AudioUtil;
import com.client.tok.ui.chat2.holders.BaseMsgHolder;
import com.client.tok.ui.chat2.holders.MsgAudioHolder;
import com.client.tok.ui.chat2.holders.MsgFileHolder;
import com.client.tok.ui.chat2.holders.MsgHelloHolder;
import com.client.tok.ui.chat2.holders.MsgImgHolder;
import com.client.tok.ui.chat2.holders.MsgTextHolder;
import com.client.tok.utils.ImageUtils;
import com.client.tok.utils.LogUtil;
import com.client.tok.utils.ViewUtil;
import java.util.ArrayList;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<BaseMsgHolder> {
    private String TAG = "MsgAdapter";
    private Context mContext;
    private List<Message> mMsgList = new ArrayList<Message>();

    private final int TEXT = 1;//text message
    private final int ACTION = 2;
    private final int FILE_IMG = 3;//file:image
    private final int FILE_AUDIO = 4;//file:audio
    private final int FILE_VIDEO = 5;//file:video
    private final int FILE = 5;//other file
    private final int CALL_INFO = 6;
    private final int HELLO_JOIN = 7;//hello message

    private Contract.IChatPresenter mPresenter;

    public MsgAdapter(Context context, Contract.IChatPresenter presenter) {
        this.mContext = context;
        mPresenter = presenter;
    }

    public void update(List<Message> msgList) {
        this.mMsgList.clear();
        this.mMsgList.addAll(msgList);
    }

    @Override
    public BaseMsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holderView;
        BaseMsgHolder msgHolder = null;
        switch (viewType) {
            case TEXT:
                holderView = ViewUtil.inflateViewById(mContext, R.layout.chat_msg_text);
                msgHolder = new MsgTextHolder(holderView, mPresenter);
                break;
            case HELLO_JOIN:
                holderView = ViewUtil.inflateViewById(mContext, R.layout.chat_hello_text);
                msgHolder = new MsgHelloHolder(holderView, mPresenter);
                break;
            case ACTION:
                break;
            case FILE_IMG:
                holderView = ViewUtil.inflateViewById(mContext, R.layout.chat_msg_img);
                msgHolder = new MsgImgHolder(holderView, mPresenter);
                break;
            case FILE_AUDIO:
                holderView = ViewUtil.inflateViewById(mContext, R.layout.chat_msg_audio);
                msgHolder = new MsgAudioHolder(holderView, mPresenter);
                break;
            case FILE:
                holderView = ViewUtil.inflateViewById(mContext, R.layout.chat_msg_file);
                msgHolder = new MsgFileHolder(holderView, mPresenter);
                break;
            case CALL_INFO:
                break;
        }
        return msgHolder;
    }

    @Override
    public void onBindViewHolder(BaseMsgHolder holder, int position) {
        Message curMsg = mMsgList.get(position);
        Message lastMsg = null;
        if (position > 0) {
            lastMsg = mMsgList.get(position - 1);
        }
        holder.setMessage(curMsg, lastMsg);
    }

    @Override
    public void onViewAttachedToWindow(BaseMsgHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(BaseMsgHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.stopListen();
    }

    @Override
    public int getItemCount() {
        return mMsgList == null ? 0 : mMsgList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = mMsgList.get(position);
        int typeVal = msg.getMsgTypeVal();
        int result = TEXT;
        if (typeVal == MessageType.MESSAGE.getType()
            || typeVal == MessageType.GROUP_MESSAGE.getType()) {
            result = TEXT;
        } else if (typeVal == MessageType.HELLO_JOIN.getType()) {
            result = HELLO_JOIN;
        } else if (typeVal == MessageType.ACTION.getType()
            || typeVal == MessageType.GROUP_ACTION.getType()) {
            result = ACTION;
        } else if (typeVal == MessageType.FILE_TRANSFER.getType()) {
            if (ImageUtils.isImgFile(msg.getMessage())) {
                result = FILE_IMG;
            } else if (AudioUtil.isAudio(msg.getMessage())) {
                result = FILE_AUDIO;
            } else {
                result = FILE;
            }
        } else if (typeVal == MessageType.CALL_EVENT.getType()) {
            result = CALL_INFO;
        }
        LogUtil.i(TAG, "typeVal:" + typeVal + ",resultType:" + result);
        return result;
    }
}
