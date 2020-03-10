package com.guowenxu.dao.impl;

import com.guowenxu.dao.UserDao;
import com.guowenxu.entiy.User;
import com.guowenxu.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        try {
            int result = queryRunner.update(DBUtil.getConn(), "insert into users(user,pwd) values(?,?)", user.getUser(), user.getPwd());
            if (result > 0) {
                System.out.println("添加成功。。。");
            } else {
                System.out.println("添加失败。。。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        try {
            int result = queryRunner.update(DBUtil.getConn(), "delete from users where id = ?", id);
            if (result > 0) {
                System.out.println("删除成功。。。");
            } else {
                System.out.println("删除失败。。。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        try {
            int result = queryRunner.update(DBUtil.getConn(), "update users set user = ?, pwd = ? where id = ?", user.getUser(), user.getPwd(), user.getId());
            if (result > 0) {
                System.out.println("修改成功。。。");
            } else {
                System.out.println("修改失败。。。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        try {
            List<User> list = queryRunner.query(DBUtil.getConn(), "select * from users", new BeanListHandler<>(User.class));
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 查找一个
     *
     * @return
     */
    @Override
    public User findOne(Integer id) {
        try {
            List<User> list = queryRunner.query(DBUtil.getConn(), "select * from users where id = ?", id, new BeanListHandler<>(User.class));
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

//    /**
//     * 第一种ResultSetHandler实现类:ArrayHandler 返回查询结果中的一行数据
//     */
//    public static void arrayHandler() throws SQLException {
//        //创建QueryRunner对象,构造方法中传递DataSource实现类对象
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        //拼写SQL语句
//        String sql = "SELECT * FROM emp";
//        //调用query方法,放回结果的第一行数据
//        Object[] objs = qr.query(sql, new ArrayHandler());
//        for (Object obj : objs) {
//            System.out.print(obj + "\t");
//        }
//    }
//
//    /**
//     * 第二种实现类 : ArrayListHandler
//     * 每行数据都对应存放在一个Object[] 数组中,多行数据的多个Object[]数组存放在集合中
//     *
//     * @throws SQLException
//     */
//    public static void arrayListHandler() throws SQLException {
//        //创建QueryRunner 对象,构造方法中传入DataSource实现类对象
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        //拼写SQL语句
//        String sql = "SELECT * FROM emp";
//        //qr调用query方法执行SQL
//        List<Object[]> list = qr.query(sql, new ArrayListHandler());
//
//        //遍历集合打印数据
//        for (Object[] objs : list) {
//            for (Object obj : objs) {
//                System.out.print(obj + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//    /**
//     * 第三种实现类:BeanHandler(重要)
//     * 将查询结果的第一行存储到javaBean对象中
//     *
//     * @throws SQLException
//     */
//    public static void beanHandler() throws SQLException {
//        //创建QueryRunner对象
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        //拼写SQL语句
//        String sql = "SELECT * FROM emp";
//        //调用query方法执行SQL,BeanHandler的构造方法中传入javaBean类的Class对象
//        Employee emp = qr.query(sql, new BeanHandler<Employee>(Employee.class));
//        //打印数据
//        System.out.println(emp);
//    }
//
//    /**
//     * 第四种实现类:BeanListHandler(非常重要)
//     *
//     * @throws SQLException
//     */
//    public static void beanListHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT * FROM emp";
//        List<Employee> list = qr.query(sql, new BeanListHandler<Employee>(Employee.class));
//        for (Employee emp : list) {
//            System.out.println(emp);
//        }
//    }
//
//    /**
//     * 第五种实现类:ScalarHandler(重要)
//     * 适合单个查询,一个select查询的结果只有一个值
//     *
//     * @throws SQLException
//     */
//    public static void scalarHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT AVG(sal) as '平均工资' FROM emp";
//        //ScalarHandler<返回值类型>(列名);
//        Object obj = qr.query(sql, new ScalarHandler<Object>("平均工资"));
//        System.out.println(obj);
//    }
//
//    /**
//     * 第六种实现类:ColumnListHandler
//     * 用于返回一个列的信息,存储集合中
//     *
//     * @throws SQLException
//     */
//    public static void columnListHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT ename as '姓名' FROM emp";
//        List<Object> list = qr.query(sql, new ColumnListHandler<Object>("姓名"));
//        for (Object obj : list) {
//            System.out.println(obj);
//        }
//    }
//
//    /**
//     * 第七种实现类:MapHandler
//     * 查询结果中的第一行,存储map集合
//     * Map<K,V>
//     * K:列名
//     * V:列中的值
//     *
//     * @throws SQLException
//     */
//    public static void mapHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT * FROM emp";
//        Map<String, Object> map = qr.query(sql, new MapHandler());
//        //遍历map
//        for (Object key : map.keySet()) {
//            System.out.println(key + "\t" + map.get(key));
//        }
//    }
//
//    /**
//     * 第八种实现类:MapListHandler
//     * 将查询出的每一行数据存储到map集合中,再将每一个map集合存储list集合中
//     *
//     * @throws SQLException
//     */
//    public static void mapListHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT * FROM emp";
//        List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
//        //遍历list,再遍历map
//        for (Map<String, Object> map : list) {
//            for (Object key : map.keySet()) {
//                System.out.print(key + "\t" + map.get(key) + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//    /**
//     * 第九种实现类:KeyedHandler
//     * 查询的每一行数据存储到map集合中,将多个map集合再存储到map中
//     *
//     * @throws SQLException
//     */
//    public static void KeyedHandler() throws SQLException {
//        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "SELECT * FROM emp";
//        Map<Object, Map<String, Object>> map = qr.query(sql, new KeyedHandler<>());
//        //遍历map(两层)
//        for (Object obj : map.keySet()) {
//            for (String key : map.get(obj).keySet()) {
//                System.out.print(key + "\t" + map.get(obj).get(key) + "\t");
//            }
//            System.out.println();
//        }
//    }
}
