package com.bird.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author jiangzhiqiang
 * ʱ�����
 */
public class TimeTask extends TimerTask {

	@Override
    public void run() {
        //û�����ӣ��������ڵ�ʱ������

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM�� HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }

}
