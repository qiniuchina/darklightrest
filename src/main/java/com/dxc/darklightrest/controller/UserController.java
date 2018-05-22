package com.dxc.darklightrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.darklightrest.entity.User;
import com.dxc.darklightrest.repository.UserRepository;
import com.dxc.darklightrest.service.UserService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询所有用户列表
	 */
	@RequestMapping(value="/userList",method=RequestMethod.GET)  
	@ApiOperation(value="获取所有的列表",notes="不需要传递参数")
	public List<User> UserList(){  
		return userService.findAll();  
	}
}
