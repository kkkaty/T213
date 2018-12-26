package com.zking.mybatis02.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = SqlSessionFactoryUtils.class.getResourceAsStream("/mybatis.cfg.xml");
            SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = SqlSessionFactoryBuilder.build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        SqlSession sqlSession = threadLocal.get();
        if (null == sqlSession) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static SqlSession closeSession(){
        SqlSession sqlSession=threadLocal.get();
        if(null!=sqlSession){
           sqlSession.close();
            threadLocal.set(null);
        }
        return sqlSession;
    }

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        System.out.println(sqlSession.getConnection());
        System.out.println("已连接。。。");
        sqlSession.close();
        System.out.println("已关闭。。");
    }


}
