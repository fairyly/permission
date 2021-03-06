package com.mall.controller;

import com.mall.beans.PageQuery;
import com.mall.beans.PageResult;
import com.mall.common.JsonData;
import com.mall.model.SysUser;
import com.mall.param.UserParam;
import com.mall.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 王乾 on 2018/1/13.
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private IUserService iUserService;

    /**
     * 增加用户
     * @param param
     * @return
     */
    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserParam param){
        iUserService.save(param);
        return  JsonData.success();
    }

    /**
     * 更新用户
     * @param param
     * @return
     */
    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserParam param){
        iUserService.update(param);
        return  JsonData.success();
    }

    @RequestMapping("page.json")
    @ResponseBody
    public JsonData page(@RequestParam("deptId") int deptId, PageQuery pageQuery){
        PageResult<SysUser> result = iUserService.getPageByDeptId(deptId, pageQuery);
        return  JsonData.success(result);
    }


}
