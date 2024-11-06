package Practice;

import java.util.Date;

public class CaptureTimeStamp {

	public static void main(String[] args) {
		String time=new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		System.out.println(time);
	}
}
