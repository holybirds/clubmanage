package com.example.clubmanage.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message_id
     *
     * @mbggenerated
     */
    private Integer messageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.send_studentid
     *
     * @mbggenerated
     */
    private String sendStudentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.recv_studentid
     *
     * @mbggenerated
     */
    private String recvStudentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.send_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.send_content
     *
     * @mbggenerated
     */
    private String sendContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message_id
     *
     * @return the value of message.message_id
     *
     * @mbggenerated
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message_id
     *
     * @param messageId the value for message.message_id
     *
     * @mbggenerated
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.send_studentid
     *
     * @return the value of message.send_studentid
     *
     * @mbggenerated
     */
    public String getSendStudentid() {
        return sendStudentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.send_studentid
     *
     * @param sendStudentid the value for message.send_studentid
     *
     * @mbggenerated
     */
    public void setSendStudentid(String sendStudentid) {
        this.sendStudentid = sendStudentid == null ? null : sendStudentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.recv_studentid
     *
     * @return the value of message.recv_studentid
     *
     * @mbggenerated
     */
    public String getRecvStudentid() {
        return recvStudentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.recv_studentid
     *
     * @param recvStudentid the value for message.recv_studentid
     *
     * @mbggenerated
     */
    public void setRecvStudentid(String recvStudentid) {
        this.recvStudentid = recvStudentid == null ? null : recvStudentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.send_time
     *
     * @return the value of message.send_time
     *
     * @mbggenerated
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.send_time
     *
     * @param sendTime the value for message.send_time
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.send_content
     *
     * @return the value of message.send_content
     *
     * @mbggenerated
     */
    public String getSendContent() {
        return sendContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.send_content
     *
     * @param sendContent the value for message.send_content
     *
     * @mbggenerated
     */
    public void setSendContent(String sendContent) {
        this.sendContent = sendContent == null ? null : sendContent.trim();
    }
}