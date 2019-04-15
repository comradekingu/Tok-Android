package com.client.tok.pagejump;

import com.client.tok.BuildConfig;

public class GlobalParams {
    //broadcast action when login success
    public static final String ACTION_LOGIN_SUCCESS = "action_login_success";
    //broadcast action when scan success
    public static final String ACTION_SCAN_RESULT = "action_scan_result";

    //profile Suffix
    public static final String ACCOUNT_FILE_SUFFIX = ".tox";

    //may be some tox id have prefix
    public static final String CHAT_ID_PRE_SUFFIX = "tox:";

    public static final String OFF_LINE = "0";
    public static final String ON_LINE = "1";
    public static final String AWAY = "2";
    public static final String BUSY = "3";

    /**
     * show the tok id detail,it control the id is mine/friend/group
     */
    public static final String TYPE_MINE = "1";
    public static final String TYPE_FRIEND = "2";



    /**
     * chat to
     * friend or group
     */
    public static final String CHAT_FRIEND = "0";

    public static final String CUSTOMER_SERVICE_TOK_ID =
        "3415845A7145854DE91046FF4666503A83EED05BC47CA222644C5F47A8E0F072938433360B34";

    /**
     * provider authority
     */
    public static final String PROVIDER_AUTH = BuildConfig.APPLICATION_ID + ".provider";

    public static int MAX_AUDIO = 60;//max length of record audio(second)

    public static String STR_CONNECTOR = ",";//String connector
    public static int MOST_UNREAD_MSG = 99;//max show unread messages

    /**
     * message send status
     */
    public final static int SEND_FAIL = -1;
    public final static int SEND_ING = 0;
    public final static int SEND_SUCCESS = 1;

    /**
     * file receive status
     */
    public final static int RECEIVE_FAIL = -1;
    public final static int RECEIVE_ING = 0;
    public final static int RECEIVE_SUCCESS = 1;

    /**
     * time out of message send failed
     */
    public final static int MSG_OUT_TIME = 5 * 1000;



    /**
     * avatar request code
     */
    public final static int REQ_CODE_PORTRAIT = 10001;

    //address length and pk length
    public static int ADDRESS_LENGTH = 76;
    public static int PK_LENGTH = 64;

    public static int MAX_MESSAGE_LENGTH = 800; //one text message max length
    public static int MAX_AVATAR_SIZE = 640 * 1024; //in bytes

    public static String DEFAULT_TOX_ME_DOMAIN = "toxme.io";

    public static int USER_NAME_MAX_LENGTH = 100;
    public static int PASSWORD_LENGTH = 50;

    public static int DELAY_ENTER_HOME = 500;//ms
}
