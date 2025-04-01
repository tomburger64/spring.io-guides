package com.example.scheduling_tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

// will likely see this later
// makes the class a Spring Bean, so Spring manages it in various way (I'll get deeper into it later, this guide isn't about this yet)
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger((ScheduledTasks.class));

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // @Scheduled tells when a method should run
    // fixedRate runs the method every at every specified interval (5s here), could also be cron(), fixedDelay() or initialDelay for one-time task
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
