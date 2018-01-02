package com.zyj.controller;

import com.zyj.pojo.Good;
import com.zyj.pojo.GoodType;
import com.zyj.pojo.Supplier;
import com.zyj.pojo.User;
import com.zyj.service.GoodService;
import com.zyj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private GoodService goodService;


    //进入main.jsp页面
    @RequestMapping("/enterMain")
    public ModelAndView enterMain(HttpServletRequest request) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("type::"+user.getGrade());
        if(user.getGrade()==0){
            mav.setViewName("/WEB-INF/jsp/main.jsp");
        }else{
            //查出所有商品类型
            List<GoodType> types = goodService.selAllGoodType();
            mav.getModel().put("types",types);
            //查出有商品的 图片url，商品名称，商品价格，商品编码
            List<Good> goods = goodService.selAllGood();
            mav.getModel().put("goods",goods);
            mav.getModel().put("name",user.getUsername());
            mav.setViewName("/WEB-INF/jsp/VIPMain.jsp");
        }
        return mav;
    }

    //frame的跳转
    @RequestMapping("/frame/{name}")
    public ModelAndView enterMain(@PathVariable(value = "name") String name) throws Exception{
        ModelAndView mav = new ModelAndView();
        if(name.equals("welcome")){
            mav.setViewName("/WEB-INF/jsp/admWelcome.jsp");
        }else{
            mav.setViewName("/WEB-INF/jsp/function.jsp");
        }
        return mav;
    }
    @RequestMapping("/peopleInformation")
    public ModelAndView peopleInformation() throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/peopleInformation.jsp");
        return mav;
    }
    //会员注册
    @RequestMapping("/reg")
    public ModelAndView reg(User user) throws Exception{
        ModelAndView mav = new ModelAndView();
        //shiro加密
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<6;i++){
            char c = (char)(Math.random()*26+97);
            sb.append(c);
        }
        String salt = sb.toString();
        user.setSalt(salt);
        SimpleHash sh = new SimpleHash("MD5",user.getPassword(), ByteSource.Util.bytes(salt),3);
        String password = sh.toString();
        user.setPassword(password);

        //生成会员编码
        String number="t_";
        Random ra = new Random();
        StringBuffer sb2 = new StringBuffer();
        for(int i=0;i<6;i++){
            int num=ra.nextInt(9);
            sb2.append(num);
        }
        number=number+sb2.toString();
        //System.out.println(number);
        user.setNumber(number);
        user.setRegDate(new Date());
        userService.saveUser(user);
        mav.setViewName("/WEB-INF/jsp/main.jsp");
        return mav;
    }
    //检查会员账号是否已经有人用过
    @RequestMapping("/check")
    public @ResponseBody int  check(String no) throws Exception{
    //   System.out.println("no:::"+no);
        int num = userService.checkNo(no);
     //   System.out.println(num);
        return num;
    }
    //登录
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("login:::");

       /* Subject subject = SecurityUtils.getSubject();
        System.out.println("subject:::"+subject);
        User user = (User)subject.getPrincipal();
        System.out.println("login:::"+user);
       // request.setAttribute("user",user);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);*/

        //--登录失败之后才执行的
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
}
