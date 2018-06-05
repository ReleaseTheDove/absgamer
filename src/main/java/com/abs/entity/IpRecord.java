package com.abs.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ip_record")
public class IpRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ip
     */
    private String ip;

    /**
     * ip对应的实际地址
     */
    private String address;

    private Date createdatetime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取ip
     *
     * @return ip - ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip
     *
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取ip对应的实际地址
     *
     * @return address - ip对应的实际地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置ip对应的实际地址
     *
     * @param address ip对应的实际地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return createdatetime
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * @param createdatetime
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
}