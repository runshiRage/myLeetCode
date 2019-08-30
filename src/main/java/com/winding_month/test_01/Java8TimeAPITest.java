package com.winding_month.test_01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * java8 新增的时间api测试
 * @author Eric
 */
public class Java8TimeAPITest {

	/**
	 * java.time包：这是新的Java日期/时间API的基础包，所有的主要基础类都是这个包的一部分，
	 * 如：LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration等等。
	 * 所有这些类都是不可变的和线程安全的，在绝大多数情况下，这些类能够有效地处理一些公共的需求。
	 * 
	 * java.time.chrono包：这个包为非ISO的日历系统定义了一些泛化的API，
	 * 我们可以扩展AbstractChronology类来创建自己的日历系统。
	 * 
	 * java.time.format包：这个包包含能够格式化和解析日期时间对象的类，
	 * 在绝大多数情况下，我们不应该直接使用它们，因为java.time包中相应的类已经提供了格式化和解析的方法。
	 * 
	 * java.time.temporal包：这个包包含一些时态对象，我们可以用其找出关于日期/时间对象的某个特定日期或时间，
	 * 比如说，可以找到某月的第一天或最后一天。你可以非常容易地认出这些方法，因为它们都具有“withXXX”的格式。
	 * 
	 * java.time.zone包：这个包包含支持不同时区以及相关规则的类
	 */

	public static void main(String[] args) {
		//Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);
 
        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date="+firstDay_2014);
 
        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid date 'February 29' as '2014' is not a leap year
 
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST="+todayKolkata);
 
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
 
        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= "+dateFromBase);
 
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 101);
        System.out.println("100th day of 2014="+hundredDay2014);
        
        
        
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
	}
	
}
