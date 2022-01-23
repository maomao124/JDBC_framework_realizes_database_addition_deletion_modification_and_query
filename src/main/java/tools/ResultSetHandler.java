package tools;

import java.sql.ResultSet;

/**
 * Project name(项目名称)：JDBC框架实现数据库的增删改查
 * Package(包名): tools
 * Interface(接口名): ResultSetHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/23
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@SuppressWarnings("all")
public interface ResultSetHandler<T>
{
    <T> T handler(ResultSet resultSet);
}
