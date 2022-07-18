package com.lec.ch11.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BcontentService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("bDto",bDao.contentView(bid));
	}

}
