package com.huz.rest.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huz.common.pojo.HzResult;
import com.huz.common.utils.ExceptionUtil;
import com.huz.rest.pojo.TbUser;
import com.huz.rest.service.TbUserService;

@Controller
@RequestMapping("/user")
//@Path("/user")
public class TbUserController {
	@Autowired
	private TbUserService tbUserService;
	
	/*@GET
	@Path("/query/{id}")
	@Produces(MediaType.TEXT_PLAIN) //@Produces(MediaType.TEXT_XML) | @Produces(MediaType.APPLICATION_JSON)  
*/
	@RequestMapping(value ="/query", method = RequestMethod.GET)
	@ResponseBody
	public HzResult findById(@RequestParam("id") Long id){
		try {
		List<TbUser> list =	tbUserService.queryById(id);
		return HzResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return HzResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
