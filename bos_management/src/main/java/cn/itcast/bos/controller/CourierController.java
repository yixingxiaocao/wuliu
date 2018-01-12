package cn.itcast.bos.controller;

import cn.itcast.bos.javabean.Courier;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhongnan on 2017/12/25.
 */
@Controller
public class CourierController {
    @Autowired
    private CourierService courierService;

    @RequestMapping("courier_save")
    public String courierSave(Courier c){
        courierService.saveCourier(c);
        return "redirect:./pages/base/courier.html";
    }
    @ResponseBody
    @RequestMapping("courier_pageQuery")
    public Map findPageQuery(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows, Courier c){
        HashMap<String, Object> map = new HashMap<>();
        Page<Courier>pages=courierService.findPageQuery(page,rows,c);
        map.put("total", pages.getTotal());
        map.put("rows", pages.getRows());
        return map;
    }

    @RequestMapping("courier_delBatch")
    public String delBatch(String ids){
        String[] idss = ids.split(",");
        courierService.delBatch(idss);


        return "redirect:./pages/base/courier.html";
    }
    @ResponseBody
    @RequestMapping("courier_findnoassociation")
    public List<Courier> findnoassociation(){
        List<Courier> couriers= courierService.findnoassociation();
        return couriers;
    }
}
