package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.IChapterDao;
import com.zsy.video.model.Chapter;
import com.zsy.video.util.BaseDao;

@Repository
public class ChapterDaoImpl extends BaseDao {
	private IChapterDao iChapterDao;
	public List<Chapter> getChaptersByCid(int c_id){
		List<Chapter> chapters=new ArrayList<Chapter>();
		SqlSession session=null;
		try {
			session=openSession();
			iChapterDao=session.getMapper(IChapterDao.class);
			chapters=iChapterDao.getChaptersByCid(c_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iChapterDao=null;
		}
		return chapters;
	}
}
