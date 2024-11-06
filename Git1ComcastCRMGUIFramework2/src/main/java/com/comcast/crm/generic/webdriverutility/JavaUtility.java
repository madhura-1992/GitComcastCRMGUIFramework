package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sim;
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnumber = random.nextInt(5000);
		return randomnumber;
	}
	public String getSystemDate()
	{
		Date dObj=new Date();
		sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dObj);
		return date;
	}
	public String getRequiredDate(int days) 
	{
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
