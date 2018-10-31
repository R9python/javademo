package com.example.scheduling.schedule.controller;


import java.time.LocalDate;

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
    public void ScheduleSave(@PathVariable long userid){
        Schedule schedule = new Schedule();
        LocalDate today = LocalDate.now();
        schedule.setUserId(userid);
        schedule.setIsRest(1);
        schedule.setWorkDate(today);
        // entity.setUserId(1);
        mapper.insert(schedule);
    }


}
