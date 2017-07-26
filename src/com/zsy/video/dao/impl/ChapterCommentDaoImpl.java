package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.IChapterCommentDao;
import com.zsy.video.model.ChapterComment;
import com.zsy.video.util.BaseDao;

@Repository
public class ChapterCommentDaoImpl extends BaseDao implements IChapterCommentDao{
	private IChapterCommentDao iCommentDao;
	public List<ChapterComment> getCommentsByVid(int vid){
		List<ChapterComment> comments= new ArrayList<ChapterComment>();
		SqlSession session=null;
		try {
			session=openSession();
			iCommentDao=session.getMapper(IChapterCommentDao.class);
			comments=iCommentDao.getCommentsByVid(vid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCommentDao=null;
		}
		return comments;
	}
	@Override
	public int addComment(ChapterComment chapterComment) {
		int num=0;
		SqlSession session=null;
		try {
			session=openSession();
			iCommentDao=session.getMapper(IChapterCommentDao.class);
			num=iCommentDao.addComment(chapterComment);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCommentDao=null;
		}
		return num;
	}
	
}
