package com.bird.schedule;

import java.util.Timer;

/**
 * @author jiangzhiqiang
 * 我们可以看到，很遗憾的是Timer只可以指定多久执行一次，并不能指定在具体那个时间点执行这项任务，
 * 比如说我们需要每天午夜1：00执行某一任务，而正是QuartZ调度器起作用的时候了。
 * 关于QuartZ的更多信息可以访问http://www.opensymphony.com/quartz/，下面让我们来看QuartZ是怎么工作的吧！
 * 2010-12-1
 */
public class TestTimeTask {
	
	
	/**
	 * schedule(TimerTask task, long delay, long period)中task指定了需要执行的任务，
	   delay指定在第一次运行任务后的多少毫秒执行此任务，
	   period参数指定在以后的多少毫秒执行一次任务。
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	       Timer timer=new Timer();
	       timer.schedule(new TimeTask(), 3000, 5000);
	       //注册此任务在第一次运行后的3秒钟时间执行，以后每隔5秒钟时间执行一次。
	 
	 }
}
