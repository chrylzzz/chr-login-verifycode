/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.yamiadmin;


import com.chryl.yamiadmin.util.SimpleCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录相关
 *
 * @author chryl
 */
@Controller
public class SysLoginController {


    @GetMapping("/captcha.jpg")
    public void login(HttpServletResponse response, String uuid) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        SimpleCaptcha simpleCaptcha = new SimpleCaptcha(200, 50, 4, 20);
        try {
            simpleCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
