package main.service;

import main.model.Schedule;
import main.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService
{
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository)
    {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAll()
    {
        return scheduleRepository.findAll();
    }
}