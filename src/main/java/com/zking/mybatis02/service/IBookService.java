package com.zking.mybatis02.service;

import com.zking.mybatis02.model.Book;
import com.zking.mybatis02.util.PageBean;
import com.zking.mybatis02.vo.BookVO;

import java.util.List;
import java.util.Map;

public interface IBookService {
    int insert(Book record);
    List<Book> queryList();

    /**
     * 案例一：foreach
     */
    List<Book> queryForeach(BookVO bookVO);

    /**
     * 案例2：模糊查询（3种方式）
     * 1) #{...}
     * 2) ${...}
     * 3) concat()
     */
    List<Book> queryLike(Book book);

    /**
     * 案例3：resultMap返回自定义类型集合
     */
    List<Book> resultLstMap();

    /**
     * 案例4：resultType返回List<T>
     *
     */
    List<Book> resultLst();

    /**
     * 案例5：resultType返回单个对象
     *
     */
    List<Book> querySing(Book book);

    /**
     * 6:resultType返回List<Map>，适用于多表查询返回结果集
     */
    List<Map<String,Object>> queryLM();

    /**
     * 案例7：resultType返回Map<String,Object>，适用于多表查询返回单个结果集
     *
     */
    Map<String,Object> queryMap();

    /**
     * 案例8:分页查询
     */
    List<Book> queryPager(Book book, PageBean pageBean);

    /**
     * 案例9：范围查询
     */
    List<Book> queryPrice(BookVO bookVO);
}