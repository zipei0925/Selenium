package selenium.WebDriverTest;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.io.Serializable;
import java.util.Date;

@HeadRowHeight(value = 35) //自定义表头行高
@ContentRowHeight(value = 25) //自定义内容的行高
//@ColumnWidth(value = 50)    //自定义列宽

public class Student implements Serializable {

//    @ExcelProperty(value = "学生编号",order = 4)  //自定义表头信息, order自定义列的顺序,值越大，列越往右
//    @ExcelIgnore    //忽略该列写入
    @ExcelProperty(value = {"学生信息","学生编号"},order = 4)  //在分类的表头上,新增一个总的表头
    private Integer id;

    @ExcelProperty(value = {"学生信息","学生姓名"}, order = 3)
    private String name;

    @ExcelProperty(value = {"学生信息","学生生日"}, order = 1)
    @DateTimeFormat("yyyy-MM-dd")   //自定义日期格式
    private Date birthday;

    //get、set方法快捷键: Alt+Insert
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
