package com.example.scheduling.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author demo
 * @since 2018-10-28
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Long Id;

    @TableField("Name")
    private String Name;

    @TableField("Age")
    private Integer Age;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }
    public LocalDateTime getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(LocalDateTime CreateTime) {
        this.CreateTime = CreateTime;
    }

    @Override
    public String toString() {
        return "User{" +
        "Id=" + Id +
        ", Name=" + Name +
        ", Age=" + Age +
        ", CreateTime=" + CreateTime +
        "}";
    }
}
