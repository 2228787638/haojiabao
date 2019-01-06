package com.haojiabao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 主键id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限
     */
    private int role;
    /**
     * 状态
     */
    private int state;
}
