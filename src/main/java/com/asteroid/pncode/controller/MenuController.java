package com.asteroid.pncode.controller;

import com.asteroid.pncode.result.Result;
import com.asteroid.pncode.result.ResultFactory;
import com.asteroid.pncode.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuSai
 */
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/api/userMenus")
    public Result menu() {
        return ResultFactory.buildSuccessResult(menuService.getMenusByCurrentUser());
    }


}
