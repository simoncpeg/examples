package com.example.chamber.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chamber.component.ChamberManager;


@RestController
public class AnimateController {
	private static final Logger logger = LoggerFactory.getLogger(AnimateController.class);
	
			
	@RequestMapping(value="/animate", consumes = MediaType.APPLICATION_JSON_VALUE)	
	public List<String> animate(@RequestBody AnimateControllerParam animateParam){
		logger.info(String.format("animate is running - speed=%d , init condition=%s", animateParam.getSpeed(), animateParam.getInit()));
		ChamberManager chamberManager = new ChamberManager(animateParam.getSpeed(), animateParam.getInit());
		List<String> result = chamberManager.animate();
		return result;
	}

}
