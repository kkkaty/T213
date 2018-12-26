package com.zking.mybatis02.service.impl;

import com.zking.mybatis02.mapper.BookMapper;
import com.zking.mybatis02.model.Book;
import com.zking.mybatis02.service.IBookService;
import com.zking.mybatis02.util.PageBean;
import com.zking.mybatis02.vo.BookVO;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements IBookService {
    private BookMapper bookmapper;

    public BookMapper getBookmapper() {
        return bookmapper;
    }

    public void setBookmapper(BookMapper bookmapper) {
        this.bookmapper = bookmapper;
    }

    @Override
    public int insert(Book record) {
        return bookmapper.insert(record);
    }
    @Override
    public List<Book> queryList() {
        return bookmapper.queryList();
    }

    @Override
    public List<Book> queryForeach(BookVO bookVO) {
        return bookmapper.queryForeach(bookVO);
    }

    @Override
    public List<Book> queryLike(Book book) {
        return bookmapper.queryLike(book);
    }

    @Override
    public List<Book> resultLstMap() {
        return bookmapper.resultLstMap();
    }

    @Override
    public List<Book> resultLst() {
        return bookmapper.resultLst();
    }

    @Override
    public List<Book> querySing(Book book) {
        return bookmapper.querySing(book);
    }

    @Override
    public List<Map<String, Object>> queryLM() {
        return bookmapper.queryLM();
    }

    @Override
    public Map<String, Object> queryMap() {
        return bookmapper.queryMap();
    }

    @Override
    public List<Book> queryPager(Book book, PageBean pageBean) {
        return bookmapper.queryPager(book);
    }

    @Override
    public List<Book> queryPrice(BookVO bookVO) {
        return bookmapper.queryPrice(bookVO);
    }
}
