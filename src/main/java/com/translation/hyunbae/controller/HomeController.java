package com.translation.hyunbae.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.hyunbae.dao.LikeDao;
import com.translation.hyunbae.vo.LikeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSessionFactoryBean dssfb;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private LikeDao likeDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOG.info("root 접속");
		LOG.info("SqlSessionFactoryBean : " + dssfb);
		LOG.info("dssfb.isSingleton() : " + dssfb.isSingleton());
		LOG.info("sqlSessionFactory : " + sqlSessionFactory);
		LOG.info("sqlSessionFactory.toString() : " + sqlSessionFactory.toString());
		LikeVO like = new LikeVO();
		like.setLikeId(4);
		long startTime = System.currentTimeMillis();
		LikeVO searchedLike = likeDao.selectLike(like);
		long endTime = System.currentTimeMillis();
		LOG.info("경과시간 : {}",endTime-startTime);
		LOG.info("like =>{}",searchedLike.toString());
		return "home";
	}
	
}
