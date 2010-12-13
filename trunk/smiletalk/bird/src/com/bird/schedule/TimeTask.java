package com.bird.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author jiangzhiqiang
 * 时间调度
 */
public class TimeTask extends TimerTask {

	@Override
    public void run() {
        //没有秒钟，报告现在的时刻任务

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月 HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }

}
