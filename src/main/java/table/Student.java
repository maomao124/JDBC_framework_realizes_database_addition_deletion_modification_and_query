package table;

import tools.BeanHandler;
import tools.BeanListHandler;
import tools.JDBCTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：JDBC框架实现数据库的增删改查
 * Package(包名): table
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/23
 * Time(创建时间)： 20:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Student
{
    private Student()
    {

    }

    /**
     * 数据库查找
     *
     * @return List<Student>对象
     */
    public static List<data.Student> find()
    {
        List<data.Student> list = null;
        String sql = "select * from information";
        list = tools.JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Student.class));
        return list;
    }

    /**
     * 按学号查找
     *
     * @param no 学号
     * @return Student对象
     */
    public static data.Student findById(Integer no)
    {
        String sql = "select * from information where no=?";
        Object[] objects = {no};
        data.Student student = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Student.class), objects);
        if (student.getNo() == null)
        {
            return null;
        }
        return student;
    }

    /**
     * 插入一条数据
     *
     * @param student Student对象
     * @return 影响行数
     */
    public static int insert(data.Student student)
    {
        String sql = "insert into information values(?,?,?,?)";
        Object[] objects = {student.getNo(), student.getName(), student.getSex(), student.getAge()};
        int result = JDBCTemplate.update(sql, objects);
        return result;
    }

    /**
     * 更新数据，不可更新学号
     *
     * @param student Student对象
     * @return 影响行数
     */
    public static int update(data.Student student)
    {
        String sql = "update information set no=? , name=? , sex=? , age=? where no=?";
        Object[] objects = {student.getNo(), student.getName(), student.getSex(), student.getAge(), student.getNo()};
        int result = JDBCTemplate.update(sql, objects);
        return result;
    }

    /**
     * 更新数据，可更新学号
     *
     * @param student Student对象
     * @param old_no  老的学号
     * @return 影响行数
     */

    public static int update(data.Student student, int old_no)
    {
        String sql = "update information set no=? , name=? , sex=? , age=? where no=?";
        Object[] objects = {student.getNo(), student.getName(), student.getSex(), student.getAge(), old_no};
        int result = JDBCTemplate.update(sql, objects);
        return result;
    }

    /**
     * 删除一条数据
     *
     * @param no 学号
     * @return 影响行数
     */
    public static int delete(Integer no)
    {
        String sql = "delete from information where no=?";
        Object[] objects = {no};
        int result = JDBCTemplate.update(sql, objects);
        return result;
    }

}
