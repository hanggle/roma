package com.oskyhang.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.frames.base.BaseController;
import com.frames.base.BaseResult;
import com.frames.util.Response;
import com.oskyhang.system.dto.BdMenuDto;
import com.oskyhang.system.entity.BdMenu;
import com.oskyhang.system.service.BdMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Description:
 * @author : z.hang
 * @Date: 2018-01-14
 * Time: 18:16
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class BdMenuController extends BaseController {

    @Autowired
    private BdMenuService bdMenuService;

    @RequestMapping(value = "/get", method= RequestMethod.GET)
    public BaseResult<BdMenu> select(@RequestParam Long id) {
        BdMenu bdMenu = bdMenuService.selectByPrimaryKey(id);
        return Response.success(bdMenu);
    }

    @RequestMapping(value="/list", method= RequestMethod.POST)
    public BaseResult<List<BdMenu>> list(@RequestBody BdMenuDto menuDto){
        log.info("list:{}", menuDto);
        List<BdMenu> list = bdMenuService.selectMenuList();
        return Response.success(list);
    }

    @RequestMapping(value="/menuTree", method= RequestMethod.GET)
    public BaseResult<BdMenu> menuTree(){
        List<BdMenu> list = bdMenuService.selectMenuTree();
        return Response.success(list);
    }

    @RequestMapping(value="/oneLevelMenu", method= RequestMethod.GET)
    public BaseResult<List<BdMenu>> oneLevelMenu(){

        Map<String, Object> params = new HashMap<>(16);
        params.put("level", "1");

        List<BdMenu> list = bdMenuService.selectMenuList(params);
        return Response.success(list);
    }

    @RequestMapping(value = "/insert", method= RequestMethod.POST)
    public String insert(@RequestBody BdMenu bdMenu){
        int i = bdMenuService.insert(bdMenu);
        return "";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(BdMenu bdMenu) {
        bdMenuService.updateByPrimaryKey(bdMenu);
        return "";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Long id) {
        bdMenuService.deleteByPrimaryKey(id);
        return JSONObject.toJSONString(Response.success(""));
    }
}
