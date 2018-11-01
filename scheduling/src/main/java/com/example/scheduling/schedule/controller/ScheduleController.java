package com.example.scheduling.schedule.controller;


import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.scheduling.schedule.entity.Schedule;
import com.example.scheduling.schedule.mapper.ScheduleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/schedule/save/{userid}", method=RequestMethod.GET)
    public boolean ScheduleSave(@PathVariable long userid){
        Schedule schedule = new Schedule();
        LocalDate today = LocalDate.now();
        schedule.setUserId(userid);
        schedule.setIsRest(1);
        schedule.setWorkDate(today);
        // entity.setUserId(1);
        mapper.insert(schedule);

        return true;
    }

    @RequestMapping(value="/schedule/view/{userid}", method=RequestMethod.GET)
    public Schedule ScheduleView(){
        // List<String> listNames = Arrays.asList("John", "Peter", "Tom", "Mary", "David", "Sam");
        // List<String> list = List.of("one", "two", "three");
        // QueryWrapper qw = new QueryWrapper();
        // Wrapper<Schedule> queryWrapper = new Wrapper<Schedule>();        
        // Schedule sch = mapper.selectList(queryWrapper);
        Schedule sch = mapper.selectById(4);
        return sch;
    }
}
