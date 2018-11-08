package com.example.scheduling.schedule.controller;


import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.scheduling.schedule.entity.Schedule;
import com.example.scheduling.schedule.mapper.ScheduleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author demo
 * @since 2018-10-30
 */
@RestController
public class ScheduleController {

    @Autowired 
    ScheduleMapper mapper;

    // 保存排班记录
    @RequestMapping(value="/schedule/save/{month}/{userid}", method=RequestMethod.GET)
    public boolean ScheduleSave(@PathVariable long month, @PathVariable long userid) throws ParseException {
        Schedule schedule = new Schedule();
        // LocalDate today = LocalDate.now();
        schedule.setUserId(userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 当月总天数
        int totalDays = getDaysOfMonth(sdf.parse("2018-"+month+"-01"));

        // 初始化都是大周
        Boolean initRest = true;

        for(int i = 1; i <= totalDays; i = i+1) {
            String strDay = i < 10 ? "0"+i : String.valueOf(i);
            String strDate = "2018-"+month+"-"+strDay;
            if(IsWeekendDay(sdf.parse(strDate),7)){ // 周六
                if(initRest)
                    schedule.setIsRest(1);         
                else
                    schedule.setIsRest(0);
                
                initRest = !initRest;
            }
            else if (IsWeekendDay(sdf.parse(strDate), 1)){ // 周日
                schedule.setIsRest(1);
            }
            else{ // 工作日
                schedule.setIsRest(0);
            }
            schedule.setWorkDate(LocalDate.parse(strDate));
            mapper.insert(schedule);
        }
        
        return true;
    }

    // 查看排班记录
    @RequestMapping(value="/schedule/view/{userid}", method=RequestMethod.GET)
    public List<Schedule> ScheduleView(){
        QueryWrapper queryWrapper = new QueryWrapper<Schedule>();
        // queryWrapper.select(i -> i.getProperty().startsWith("test"));
        // queryWrapper.setEntity(new Schedule());
        // queryWrapper
        List<Schedule> scheduleList = mapper.selectList(queryWrapper);
        // Schedule sch = mapper.selectById(4);

        return scheduleList;
    }

    public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Boolean IsWeekendDay(Date date, int dayOfWeek){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == dayOfWeek)
        {
            return true;
        } else{
            return false;
        }
    }
    
}
