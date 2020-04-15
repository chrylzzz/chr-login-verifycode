package com.chryl.controller;


import com.chryl.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * 登录测试
 */
@RestController
public class LoginController {

    //返回 验证码img
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);//使用session记录 验证码
        VerificationCode.output(image, resp.getOutputStream());
    }


    //校验code
    public void checkCode(HttpServletRequest request, HttpServletResponse resp, String code) {
        //session 获取
        String verify_code = (String) request.getSession().getAttribute("verify_code");
        if (code == null || verify_code == null ||
                "".equals(code) ||
                !verify_code.toLowerCase().equals(code.toLowerCase())) {
            //验证码不正确
            throw new RuntimeException("验证码不正确");
        }
    }


}
