package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeDao {
	List<NoticeView> getViewList();
	List<Notice> getList();
	List<NoticeView> getViewList(int page);
	List<NoticeView> getViewList(int page, String query);
	List<NoticeView> getViewList(@Param("page") int page, String query, String field);
	//                          이걸 사용한다면 param1,param2,pram3 대신에
	//									page , query , field 라 할수있다.
	NoticeView getNoticeView(int id);
	Notice getNotice(int id);
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
}
