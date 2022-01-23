package table;

import org.junit.jupiter.api.Test;
import tools.JDBCTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：JDBC框架实现数据库的增删改查
 * Package(包名): table
 * Class(测试类名): StudentTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/23
 * Time(创建时间)： 20:46
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentTest
{

    @Test
    void find()
    {
        List<data.Student> list = Student.find();
        for (data.Student student : list)
        {
            System.out.print(student);
        }
    }

    @Test
    void findById()
    {
        data.Student student = Student.findById(11);
        System.out.println(student);
    }

    @Test
    void insert()
    {
        data.Student student = new data.Student(12, "张九", "男", 17);
        int result = Student.insert(student);
        System.out.println(result);
    }

    @Test
    void update()
    {
        data.Student student = Student.findById(12);
        System.out.println(student);
        if (student != null)
        {
            student.setAge(18);
            int result = Student.update(student);
            System.out.println(result);
            student = Student.findById(12);
            System.out.println(student);
        }
    }

    @Test
    void testUpdate()
    {
        data.Student student = Student.findById(12);
        System.out.println(student);
        if (student != null)
        {
            student.setNo(13);
            int result = Student.update(student, 12);
            System.out.println(result);
            student = Student.findById(13);
            System.out.println(student);
        }
    }

    @Test
    void delete()
    {
        int result = Student.delete(13);
        System.out.println(result);
    }

    @Test
    void update1()
    {
        String sql = "insert into information values(?,?,?,?)";
        Object[][] object = {{12, "张5", "男", 17}, {13, "张6", "男", 17}, {14, "张5", "男", 17}};
        System.out.println(JDBCTemplate.update(sql, object));
    }

    @Test
    void update2()
    {
        String[] sql = new String[3];
        sql[0] = "insert into information values(?,?,?,?)";
        sql[1] = "update information set age=? where no=?";
        sql[2] = "update information set sex=? where no=?";
        Object[][] object = {{12, "张5", "男", 17}, {15, 12}, {"女", 13}};
        System.out.println(JDBCTemplate.update(sql, object));
    }
}