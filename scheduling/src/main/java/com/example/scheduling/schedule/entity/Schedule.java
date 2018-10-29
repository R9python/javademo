package com.example.scheduling.schedule.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author demo
 * @since 2018-10-30
 */
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Long Id;

    @TableField("UserId")
    private Long UserId;

    @TableField("WorkDate")
    private LocalDate WorkDate;

    /**
     * 是否休息
     */
    @TableField("IsRest")
    private Integer IsRest;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }
    public LocalDate getWorkDate() {
        return WorkDate;
    }

    public void setWorkDate(LocalDate WorkDate) {
        this.WorkDate = WorkDate;
    }
    public Integer getIsRest() {
        return IsRest;
    }

    public void setIsRest(Integer IsRest) {
        this.IsRest = IsRest;
    }

    @Override
    public String toString() {
        return "Schedule{" +
        "Id=" + Id +
        ", UserId=" + UserId +
        ", WorkDate=" + WorkDate +
        ", IsRest=" + IsRest +
        "}";
    }
}
