package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile
{
 public static void main(String[] args) throws IOException
 {
	 FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	 Properties p = new Properties();
	 p.load(fis);
//	 String value = p.getProperty("browser");
//	 System.out.println(value);
//	 value = p.getProperty("url");
//	 System.out.println(value);
//	 value = p.getProperty("username");
//	 System.out.println(value);
//	 value = p.getProperty("password");
//	 System.out.println(value);

	 System.out.println(p.getProperty("browser"));
	 System.out.println(p.getProperty("url"));
	 System.out.println(p.getProperty("username"));
	 System.out.println(p.getProperty("password"));


}
}
