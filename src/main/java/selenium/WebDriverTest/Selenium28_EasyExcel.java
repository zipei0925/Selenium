package selenium.WebDriverTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.util.*;

public class Selenium28_EasyExcel {
    public static void main(String[] args) {
        List<Student> lists = new ArrayList<Student>();

        for (int i=0; i<=10; i++){
            Student student = new Student();
            student.setId(i+1);
            student.setName("Mike" + i);
            student.setBirthday(new Date());
            lists.add(student);
        }

        //设置要写入列的属性名
        //必须要和类的属性名一致
        Set<String> set = new HashSet<>();
        set.add("id");
        set.add("name");

        /*EasyExcel.write 表示构建一个Excel写对象，其参数含义为：
            - 第一个参数： 写出表格的文件名
            - 第二个参数：写到表格数据类型的class对象*/
        EasyExcel.write("学生信息表.xlsx", Student.class)
                .includeColumnFiledNames(set)   //添加自定义写入的列名
                //自适应宽度,但是这个不是很精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet(2, "学生信息")  //可指定写入的Sheet序号和名称,默认为0
                .doWrite(lists); //表示写入的数据，写入的数据为List集合

        /*
        * EasyExcel的读取是基于SAX方式
        * 因此在解析时需要传入监听器
        * */
        // 第一个参数: Excel的文件路径
        // 第二个参数: 读取时的数据类型
        // 第三个参数: 监听器
        List<Student> readList = new ArrayList<>();

        EasyExcel.read("学生信息表" + ExcelTypeEnum.XLSX.getValue(), //学生信息表.xlsx
                Student.class,
                new AnalysisEventListener<Student>() {
            //每读取一行就调用该方法
            @Override
            public void invoke(Student data, AnalysisContext context) {
                readList.add(data);
            }
            //全部读完调用该方法
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("读取完成");
            }
        }).sheet().doRead();

        readList.forEach(System.out::println);
    }
}
