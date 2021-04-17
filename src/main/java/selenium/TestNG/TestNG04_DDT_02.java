package selenium.TestNG;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestNG04_DDT_02 {

    @Test(dataProvider = "testData")

    public void TestLogin (String username, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");

        //点击登录按钮
        driver.findElement(By.id("s-top-loginbtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
        Thread.sleep(1000);

        //输入账号密码
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys(username);
        driver.findElement(By.id("TANGRAM__PSP_11__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys(password);
    }



    @DataProvider(name = "testData")
    public Object[][] data() throws IOException {

//        //创建字节输入流对象,读取数据
        File file = new File(".\\files\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        //取消批注下的代码内部警告
        @SuppressWarnings("resource")
        //创建一个XSSFWorkbook,获取字节流
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // 获取Excel中sheet(0)的内容
        XSSFSheet sh1 = wb.getSheetAt(0);
        //获取总行数
        int rowNum = sh1.getPhysicalNumberOfRows();

        //创建一个二维数组对象
        Object[][] data = new Object[rowNum][2];

        for (int i=0; i<rowNum; i++){
            //获取第i行中第一个单元格的值
            data[i][0] = sh1.getRow(i).getCell(0).getStringCellValue();
            //获取第i行中第二个单元格的值
            data[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();

        }

        return data;
        };
    }
//        StringExcelListener listener = new StringExcelListener();
//        List<List<String>> readList = new ArrayList<>();
//
//         EasyExcel.read(fis, null, listener).sheet(0).doRead();
//
//         readList = listener.getList();
//         return readList;


//        EasyExcel.read("学生信息表" + ExcelTypeEnum.XLSX.getValue(), //学生信息表.xlsx
//                Student.class,
//                new AnalysisEventListener<Student>() {
//                    //每读取一行就调用该方法
//                    @Override
//                    public void invoke(Student data, AnalysisContext context) {
//                        readList.add(data);
//                    }
//                    //全部读完调用该方法
//                    @Override
//                    public void doAfterAllAnalysed(AnalysisContext context) {
//                        System.out.println("读取完成");
//                    }
//                }).sheet().doRead();




//    }

