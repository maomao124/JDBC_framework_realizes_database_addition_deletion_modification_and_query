package tools;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Project name(项目名称)：JDBC框架实现数据库的增删改查
 * Package(包名): tools
 * Class(类名): ScalaerHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/23
 * Time(创建时间)： 20:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

/*
接口：
public interface ResultSetHandler<T>
{
    <T> T handler(ResultSet resultSet);
}
 */

@SuppressWarnings("all")
public class ScalarHandler<T> implements ResultSetHandler<T>
{

    //构造方法
    public ScalarHandler()
    {

    }

    /**
     * 根据结果集对象返回对应的数据
     *
     * @param resultSet 结果集对象
     * @return Long型的变量
     */
    @Override
    public Long handler(ResultSet resultSet)
    {
        //定义Long类型的变量
        Long value = null;
        try
        {
            //获取结果集的数据
            if (resultSet.next())
            {
                //通过结果集的对象获取结果源信息对象
                ResultSetMetaData metaData = resultSet.getMetaData();
                //获取第一列的列名
                String columnName = metaData.getColumnName(1);
                //通过列名获取数据
                value = resultSet.getLong(columnName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //返回对象
        return value;
    }
}

