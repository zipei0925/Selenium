package selenium.WebDriverTest;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Selenium30_OpenCSV {
    public static void main(String[] args) throws IOException {
        //加载CSV文件
        CSVReader csvReader = new CSVReader(new FileReader("test.csv"));

        //把csv内容加载到list文件中
        List<String[]> list = csvReader.readAll();
        System.out.println("总行数是:" + list.size());

//        for (String[] strings: list){
//            System.out.print("本行的值为:");
//            for (int i=0; i<strings.length; i++){
//                System.out.print(" " + strings[i]);
//            }
//            System.out.println();
//        }

        //创建一个Iterator引用
        Iterator<String[]> iterator = list.iterator();

        //遍历每个值
        while (iterator.hasNext()){
            String[] strings = iterator.next();
            System.out.print("本行的值为: ");

            for (int i=0; i<strings.length; i++) {
                System.out.print("" + strings[i]);
            }
            System.out.println();
        }



    }
}
