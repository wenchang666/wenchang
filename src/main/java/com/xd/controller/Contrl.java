package com.xd.controller;

import com.xd.bean.Emp;
import com.xd.bean.User;
import com.xd.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author wc
 * @create 2019-11-29-14:14
 */
@Controller
public class Contrl {

    @RequestMapping(value = "iwantin")
    public String a1(){
        System.out.println("进入了Servlet");
        return "index2";
    }


    @RequestMapping(value = "i2")
    @ResponseBody
    public String a2(String name,int age){

        System.out.println(name+""+age);

        return  name+" "+age;
    }
    @RequestMapping(value = "i3")
    @ResponseBody
    public String a3(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name+""+age);

        return  name+" "+age;
    }
    @RequestMapping(value = "i4")
    @ResponseBody
    public User a4(User user){
        System.out.println(user);
        return user;
    }
    //consumes指定前端传递的数据类型,produces指定后端返回的数据类型
    //常见的三种 text/html application/json application/xml
    @RequestMapping(value = "i5",consumes = "application/json",produces = "application/json")
    @ResponseBody
    public User a5(@RequestBody  User user){
        System.out.println(user);
        return user;
    }
    @RequestMapping(value = "i6")
    @ResponseBody
    public Map a6(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return map;
    }
    @RequestMapping(value = "i7",method = RequestMethod.GET)
    @ResponseBody
    public User a7(User user){
        System.out.println(user);
        return user;
    }
    @RequestMapping(value = "i8/{age}",method = RequestMethod.GET)
    public void a8(@PathVariable("age") Integer age1){
        System.out.println(age1);
    }

    @RequestMapping("upload")
    @ResponseBody
    public String u1(MultipartFile uploadfile)throws IOException {
        //获取真实文件名称
        String originalFilename = uploadfile.getOriginalFilename();

        String pathname="D:\\io\\";
        uploadfile.transferTo(new File(pathname+originalFilename));
        return "success";
    }


    @RequestMapping("upload2")
    @ResponseBody
    public String u2(MultipartFile [] uploadfile) throws IOException{
        for (MultipartFile multipartFile : uploadfile) {
            String originalFilename = multipartFile.getOriginalFilename();

            String pathname="D:\\io\\";
            multipartFile.transferTo(new File(pathname+originalFilename));
        }
        return "success";
    }
    @RequestMapping("ajaxupload")
    @ResponseBody
    public String u3(MultipartHttpServletRequest req)throws IOException {

        MultipartFile file=req.getFile("uploadfile");
        System.out.println(file.getOriginalFilename());
        Enumeration names = req.getParameterNames();
        while (names.hasMoreElements()){
            String name=(String)names.nextElement();
            String parameter = req.getParameter(name);
            System.out.println(name+"  "+parameter);
        }


        //        //获取真实文件名称
//        String originalFilename = uploadfile.getOriginalFilename();
//
//        String pathname="D:\\io\\";
//        uploadfile.transferTo(new File(pathname+originalFilename));
       return "success";
    }

    @Autowired
    private JavaMailSenderImpl jms;

    @RequestMapping("sendmail")
    @ResponseBody
    public String f1(MultipartFile fujian){
        MimeMessage message = jms.createMimeMessage();
        try {

            MimeMessageHelper mm = new MimeMessageHelper(message, true);
            mm.addAttachment(fujian.getOriginalFilename(),fujian);
            mm.setSubject("这是一封邮件");
            mm.setText("这是一封测试的邮件");
            mm.setSentDate(new Date());
            mm.setFrom("979808998@qq.com");
            mm.setTo(new String[]{"940722725@qq.com"});
            jms.send(message);
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "fail";
    }
   @Autowired
   private EmpMapper empMapper;
    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<Emp> emps = empMapper.selectByAll(null);
        model.addAttribute("empList",emps);
        return "showEmp";
    }

}
