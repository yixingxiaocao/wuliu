package cn.itcast.bos.web.action;

import cn.itcast.bos.utils.MailUtils;
import cn.itcast.bos.utils.SmsUtils;
import cn.itcast.crm.domain.Customer;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuhongnan on 2018/1/6.
 */
@Controller
public class CustomerController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @RequestMapping("customer_sendSms")
    public void sendMsm(Customer c, HttpServletRequest request) throws ClientException {
        String s = RandomStringUtils.randomNumeric(6);
       SmsUtils.sendSms(c.getTelephone(),s);
        System.out.println(s);
        request.getSession().setAttribute(c.getTelephone(),s);

    }
    @RequestMapping("customer_regist")
    public String regist(Customer c, HttpServletRequest request,String checkcode){
        String checkcodeSession= (String) request.getSession().getAttribute(c.getTelephone());
        if (checkcodeSession == null || !checkcodeSession.equals(checkcode)) {
            System.out.println("短信验证码错误...");
            return "redirect:signup.html";
        }
        WebClient.create("http://localhost:9100/crm_management/services" +"/customerService/customer"
                ).type(MediaType.APPLICATION_JSON).post(c);
        // 发送一封激活邮件
        // 生成激活码
        String activecode = RandomStringUtils.randomNumeric(32);

        // 将激活码保存到redis，设置24小时失效
        redisTemplate.opsForValue().set(c.getTelephone(), activecode, 24,
                TimeUnit.HOURS);

        // 调用MailUtils发送激活邮件
        String content = "尊敬的客户您好，请于24小时内，进行邮箱账户的绑定，点击下面地址完成绑定:<br/><a href='"
                + MailUtils.activeUrl + "?telephone=" + c.getTelephone()
                + "&activecode=" + activecode + "'>速运快递邮箱绑定地址</a>";
        MailUtils.sendMail("速运快递激活邮件", content, c.getEmail());
        return "redirect:signup-success.html";
    }
    @RequestMapping("customer_activeMail")
    public void activeMail(Customer c,HttpServletRequest request,HttpServletResponse response,String activecode) throws IOException {
       // 判断激活码是否有效
        String activecodeRedis = redisTemplate.opsForValue().get(
                c.getTelephone());
        if (activecodeRedis == null || !activecodeRedis.equals(activecodeRedis)) {
            // 激活码无效
           response.getWriter()
                    .println("激活码无效，请登录系统，重新绑定邮箱！");
        } else {
            // 激活码有效
            // 防止重复绑定
            // 调用CRM webService 查询客户信息，判断是否已经绑定
            Customer customer = WebClient
                    .create("http://localhost:9100/crm_management/services"
                            + "/customerService/customer/telephone/"
                            + c.getTelephone())
                    .accept(MediaType.APPLICATION_JSON).get(Customer.class);
            if (customer.getType() == null || customer.getType() != 1) {
                // 没有绑定,进行绑定
                WebClient.create(
                        "http://localhost:9100/crm_management/services"
                                + "/customerService/customer/updatetype/"
                                + c.getTelephone()).get();
               response.getWriter()
                        .println("邮箱绑定成功！");
            } else {
                // 已经绑定过
               response.getWriter()
                        .println("邮箱已经绑定过，无需重复绑定！");
            }

            // 删除redis的激活码
            redisTemplate.delete(c.getTelephone());
        }

    
    }
}
