package selenium.WebDriverTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Selenium33_DateTime {
    public static void main(String[] args) throws ParseException {
        //创建DateFormat对象
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");

        //利用Date获取当前时间
        Date date = new Date();

        //格式化时间,Date到String
        String st = dateFormat.format(date);

        System.out.println(st);

        //格式化时间,String到Date
        String ss = "2048-08-09 11:11:11";
        //ParseException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = sdf2.parse(ss);
        System.out.println(dd);

    }
}
