package com.fukutaku.web.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository
public class MyBatisNoticeDao implements NoticeDao {

	
	@Autowired
	private SqlSessionTemplate session;  
	
	
	@Override
	public List<NoticeView> getViewList() 
	{
		// TODO Auto-generated method stub
		return getViewList(1,"","title");
	}

	@Override
	public List<Notice> getList() 
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		return noticeDao.getList();
	}

	@Override
	public List<NoticeView> getViewList(int page) 
	{
		
		return getViewList(page,"","title");
	}

	@Override
	public List<NoticeView> getViewList(int page, String query)
	{
		
		return getViewList(page,query,"title");
	}

	@Override
	public List<NoticeView> getViewList(int page, String query, String field)
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		
		
		return noticeDao.getViewList(page, query, field);
	}

	@Override
	public NoticeView getNoticeView(int id) 
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.getNoticeView(id);
	}

	@Override
	public Notice getNotice(int id)
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.getNotice(id);
	}

	@Override
	public int insert(Notice notice) 
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.insert(notice);
	}

	@Override
	public int update(Notice notice) 
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.update(notice);
	}

	@Override
	public int delete(int id) 
	{
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.delete(id);
	}

}
