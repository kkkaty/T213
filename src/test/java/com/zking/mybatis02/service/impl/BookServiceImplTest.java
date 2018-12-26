package com.zking.mybatis02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.mybatis02.mapper.BookMapper;
import com.zking.mybatis02.model.Book;
import com.zking.mybatis02.service.IBookService;
import com.zking.mybatis02.util.PageBean;
import com.zking.mybatis02.util.SqlSessionFactoryUtils;
import com.zking.mybatis02.vo.BookVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookServiceImplTest {

    private IBookService bookService;
    private SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        sqlSession=SqlSessionFactoryUtils.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        BookServiceImpl bs=new BookServiceImpl();
        bs.setBookmapper(mapper);
        bookService=bs;
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        Book book=new Book();
        book.setBookname("yiyi");
        book.setBooktype("lij");
        book.setPrice(20f);
        bookService.insert(book);
    }

    @Test
    public void queryList() {
        List<Book> books = bookService.queryList();
        System.out.println(books);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForeach() {
        BookVO bookVO=new BookVO();
        bookVO.setIds(Arrays.asList(new Integer[]{1,2,3}));
        List<Book> books = bookService.queryForeach(bookVO);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryLike() {
        Book book=new Book();
        //book.setBookname("%1%");
        book.setBookname("1");
        List<Book> books = bookService.queryLike(book);
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }

    @Test
    public void resultLstMap() {
        List<Book> books = bookService.resultLstMap();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void resultLst() {
        List<Book> books = bookService.resultLst();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void querySing() {
        Book book=new Book();
        book.setId(1);
        List<Book> books = bookService.querySing(book);
        System.out.println(books);
    }

    @Test
    public void queryLM() {
        List<Map<String, Object>> maps = bookService.queryLM();
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void queryMap() {
        Map<String, Object> stringObjectMap = bookService.queryMap();
        System.out.println(stringObjectMap);
    }

    @Test
    public void queryPager() {
        Book book=new Book();

        PageBean pageBean=new PageBean();
        pageBean.setPagination(true);
        pageBean.setRows(8);
        pageBean.setPage(2);

        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }
        List<Book> books = bookService.queryPager(book, pageBean);
        if(null!=pageBean&&pageBean.isPagination()){
            PageInfo pageInfo=new PageInfo(books);
            System.out.println("页码：" + pageInfo.getPageNum());
            System.out.println("页大小：" + pageInfo.getPageSize());
            System.out.println("总记录：" + pageInfo.getTotal());
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        System.out.println("总记录：" +pageBean.getTotal());
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }

    @Test
    public void queryPrice() {
        BookVO bookVO=new BookVO();
        bookVO.setMinPrice(10f);
        bookVO.setMaxPrice(50f);
        List<Book> books = bookService.queryPrice(bookVO);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}