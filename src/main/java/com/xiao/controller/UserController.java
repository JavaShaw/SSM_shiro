package com.xiao.controller;

import com.xiao.domain.User;
import com.xiao.util.Stringhelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String randcode = request.getParameter("code");
        String validateCode =(String) request.getSession().getAttribute("validateCode");
        if (Stringhelper.isNullOrEmpty(username)||Stringhelper.isNullOrEmpty(password)||Stringhelper.isNullOrEmpty(randcode)) {
            return "login";
        }
        if (!randcode.equals(validateCode)){
            return "login";
    }
            //主体,当前状态未认证
            Subject subject = SecurityUtils.getSubject();
            // 登录后存放进shiro的token中
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            User user = null;
            //登录方法（认证是否通过）
            //使用subject调用securityManager,安全管理器调用Realm
            try {
                subject.login(token);
                user = (User) subject.getPrincipal();
                session.setAttribute("subject", subject);
            } catch (Exception e) {
                return "login";
            }
        return "index";
    }

    @RequestMapping("/check")
    public String check(HttpSession session) {
        Subject subject = (Subject) session.getAttribute("subject");
        User user = (User) subject.getPrincipal();
        if(user != null){
            return "permission";
        }else{
            return "login";
        }

    }

    @RequestMapping("/readUser")
    public String readName(HttpSession session) {
        return "User";
    }

    @RequestMapping("/readBook")
    public String readData() {
        return "Book";
    }

    @RequestMapping("/nopermission")
    public String noPermission() {
        return "error";
    }


}
