import mybatis.dao.IUser;
import mybatis.models.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by ly on 2018/3/2.
 */
public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    @Before
    public void init() {
        try {
            reader = Resources.getResourceAsReader("Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //注解测试
            //sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test1() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne(
                    "mybatis.mappers.UserMapper.getUserByID", 1);
            if (user != null) {
                String userInfo = "名字：" + user.getName() + ", 所属部门：" + user.getDept() + ", 主页：" + user.getWebsite();
                System.out.println(userInfo);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void Test2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUser iuser = session.getMapper(IUser.class);
            User user = iuser.getUserByID(1);
            System.out.println("名字：" + user.getName());
            System.out.println("所属部门：" + user.getDept());
            System.out.println("主页：" + user.getWebsite());
        } finally {
            session.close();
        }
    }

    @Test
    public void Test3() {
        SqlSession session = sqlSessionFactory.openSession();
        IUser userMapper = session.getMapper(IUser.class);

        System.out.println("Test insert start...");
        // 执行插入
        User user = new User();
        user.setId(0);
        user.setName("Google");
        user.setDept("Tech");
        user.setWebsite("http://www.google.com");
        user.setPhone("120");

        userMapper.insertUser(user);

        //提交事物
        session.commit();

        // 显示插入之后User信息
        System.out.println("After insert");
        getUserList();
        System.out.println("Test insert finished...");

    }

    @Test
    public void getUserList() {
        SqlSession session = sqlSessionFactory.openSession();
        IUser iuser = session.getMapper(IUser.class);
        // 显示User信息
        System.out.println("Test Get start...");
        printUsers(iuser.getUserList());
        System.out.println("Test Get finished...");
    }


    /**
     * 打印用户信息到控制台
     *
     * @param users
     */
    private static void printUsers(final List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format(
                    "============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Dept: " + user.getDept());
            System.out.println("User Website: " + user.getWebsite());
        }
    }


    @Test
    public void Test4() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int userid = 1;
            Users user = session.selectOne("mybatis.models.UsersMapper.getUser", 1);
            System.out.println("username: " + user.getUsername() + ",");
            List<Post> posts = user.getPosts();
            for (Post p : posts) {
                System.out.println("Title:" + p.getTitle());
                System.out.println("Content:" + p.getContent());
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void insertTest() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Post post = new Post();
            post.setTitle("MyBatis开发环境搭建");
            post.setContent("在实际项目中，经常使用关联表的查询，比如：多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。我们首先创建一个 post 表，并初始化数据.0");
            int i = 0;
            while (i < 10000) {
                session.insert("mybatis.models.PostMapper.insertPost", post);
                i++;
            }
            session.commit();

        } finally {
            session.close();
        }
    }


    @Test
    public void TestChcahe() {
        long start = System.currentTimeMillis();
        System.out.println("=====start time:" + start + "=======");
        int i = 0;
        while (i < 100) {
            SqlSession session = sqlSessionFactory.openSession();
            try {
                int postId = 1;
                List<Object> list = session.selectList("mybatis.models.PostMapper.getAllPosts");
                //System.out.println("title: " + post.getTitle());
                //System.out.println("userName: " + post.getUsers().getUsername());
            } finally {
                session.close();
            }
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println("=====start time:" + (end - start) + "=======");
    }


    @Test
    public void testGetGroupAndUsers(){

    }

}
