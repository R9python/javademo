package com.example.scheduling.schedule.controller;


import com.example.scheduling.schedule.entity.Schedule;
import com.example.scheduling.schedule.mapper.ScheduleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/schedule/save")
    public void ScheduleSave(){
        Schedule entity = new Schedule();
        // entity.setUserId(1);
        mapper.insert(entity);
    }
}
