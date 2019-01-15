package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Service
public class AcademyNoticeService implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	@Transactional
	public List<NoticeView> getNoticeViewList() 
	{
		
		Notice notice = noticeDao.getNotice(567);
		notice.setHit(notice.getHit()+1);
		noticeDao.update(notice);
		
		Notice n = new Notice("test tx", "no content", "newlec1");
		noticeDao.insert(n);
		
		
		return noticeDao.getViewList();
	}
	
}
