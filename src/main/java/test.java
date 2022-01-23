import data.Student;

import java.util.List;

/**
 * Project name(项目名称)：JDBC框架实现数据库的增删改查
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/23
 * Time(创建时间)： 22:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        List<Student> list = table.Student.find();
        for (data.Student student : list)
        {
            System.out.print(student);
        }
    }
}
