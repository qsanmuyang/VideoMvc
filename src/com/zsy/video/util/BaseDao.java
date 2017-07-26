package com.zsy.video.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �������ݲ�����
 * @author ��ɭ��
 *
 */
public class BaseDao {
	private static SqlSessionFactory sessionFactory;
	static{
		try {
			//��ȡ�����ļ�
			Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
			sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���ز������ݿ��session����
	 * @return
	 */
	public static SqlSession openSession(){
		return sessionFactory.openSession();
	}
}
