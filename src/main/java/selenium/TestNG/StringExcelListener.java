package selenium.TestNG;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringExcelListener extends AnalysisEventListener{
    /**
     * StringList 解析监听器
     =============================
     * 自定义用于暂时存储data
     * 可以通过实例获取该值
     */
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    //private static final int BATCH_COUNT = 5;

    private List<List<String>> list = new ArrayList<>();

    /**
     * 每解析一行都会回调invoke()方法
     *
     * @param object  读取后的数据对象
     * @param context 内容
     */
    @Override
    public void invoke(Object object, AnalysisContext context) {
        @SuppressWarnings("unchecked") Map<String, String> stringMap = (HashMap<String, String>) object;
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        list.add(new ArrayList<>(stringMap.values()));
        //根据自己业务做处理
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
        //注意不要调用datas.clear(),否则getDatas为null
    }

    /**
     * 返回数据
     *
     * @return 返回读取的数据集合
     **/
    public List<List<String>> getList() {
        return list;
    }

    /**
     * 设置读取的数据集合
     *
     * @param list 设置读取的数据集合
     **/
    public void setList(List<List<String>> list) {
        this.list = list;
    }


}
