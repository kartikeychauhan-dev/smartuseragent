package com.abnamro.smartuserassignai.controller;

import com.abnamro.smartuserassignai.service.SmartUserAssign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartUserAssignController {
	final SmartUserAssign smartUserAssign;
	SmartUserAssignController(SmartUserAssign smartUserAssign) {
		this.smartUserAssign = smartUserAssign;
	}
	@GetMapping("getGroup")
	ResponseEntity<String> smartUserAssign(@RequestParam String short_desc, @RequestParam String desc){
		return  ResponseEntity.ok(smartUserAssign.getUserAssignedFormAi(short_desc, desc));
	}
}
