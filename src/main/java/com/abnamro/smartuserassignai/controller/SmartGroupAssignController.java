package com.abnamro.smartuserassignai.controller;

import com.abnamro.smartuserassignai.service.SmartUserGroupAssign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class SmartGroupAssignController {
	final SmartUserGroupAssign smartUserGroupAssign;
	SmartGroupAssignController(SmartUserGroupAssign smartUserGroupAssign) {
		this.smartUserGroupAssign = smartUserGroupAssign;
	}

	@CrossOrigin("https://capgeminipolskaspzoo16.service-now.com/")
	@GetMapping("/v1/getGroupName")
	ResponseEntity<String> smartUserAssign(@RequestParam String short_desc, @RequestParam String desc){
		return  ResponseEntity.ok(smartUserGroupAssign.getUserGroupAssignedByAi(short_desc, desc));
	}
}
