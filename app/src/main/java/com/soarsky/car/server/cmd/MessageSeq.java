package com.soarsky.car.server.cmd;

/**
 * 车主APP
 * 作者： 孙向锦
 * 时间： 8/18/2016
 * 公司：长沙硕铠电子科技有限公司
 * Email：sunxiangjin@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：消息ID管理器，生成器
 */
public class MessageSeq {

    private static MessageSeq instance = new MessageSeq();

    private MessageSeq(){}

    private int msgId = 0;

    public static MessageSeq getInstance(){
        return instance;
    }
    public int getMessageSeq(){
        return ++msgId ;
    }
}
