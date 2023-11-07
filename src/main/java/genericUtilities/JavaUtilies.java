package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtilies
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(10000);
		return r;
	}

	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;

	}
}
