package cn.itcast.bos.controller;

import cn.itcast.bos.javabean.FixedArea;
import cn.itcast.bos.service.FixedAreaService;
import cn.itcast.bos.utils.Page;
import cn.itcast.crm.domain.Customer;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuhongnan on 2017/12/28.
 */
@Controller
public class FixedAreaContorller {

    @Autowired
    private FixedAreaService fixedAreaService;

    @RequestMapping("fixedArea_save")
    public String fixedArea_save(FixedArea fixedArea){

        fixedAreaService.saveFixedArea(fixedArea);
        return "redirect:./pages/base/fixed_area.html";
    }
    @ResponseBody
    @RequestMapping("fixedArea_pageQuery")
    public Map pageQuery(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows,FixedArea fixedArea){
        HashMap<String, Object> map = new HashMap<>();
        Page<FixedArea> pages=fixedAreaService.pageQuery(page,rows,fixedArea);
        map.put("total", pages.getTotal());
        map.put("rows", pages.getRows());
        return map;

    }
    @ResponseBody
    @RequestMapping("fixedArea_findNoAssociationCustomers")
    public Collection findNoAssociationCustomers(){
        // 使用webClient调用 webService接口
        Collection<? extends Customer> collection = WebClient
                .create("http://localhost:9100/crm_management/services/customerService/noAssociationCustomers")
                .accept(MediaType.APPLICATION_JSON)
                .getCollection(Customer.class);
        return collection;
    }
    @ResponseBody
    @RequestMapping("fixedArea_findHasAssociationFixedAreaCustomers")
    public Collection findHasAssociationFixedAreaCustomers(FixedArea fixedArea) {
        Collection<? extends Customer> collection = WebClient
                .create("http://localhost:9100/crm_management/services/customerService/findFixedAreaCustomers/"
                        + fixedArea.getId()).accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON).getCollection(Customer.class);
        return collection;
    }
    @RequestMapping("fixedArea_associationCustomersToFixedArea")
    public String associationCustomersToFixedArea(String[] customerIds,FixedArea fixedArea){
        String customerIdStr = StringUtils.join(customerIds, ",");
        WebClient.create(
                "http://localhost:9100/crm_management/services/customerService"
                        + "/associationCustomersToFiexdArea?customerIdStr="
                        + customerIdStr + "&fixedAreaId=" + fixedArea.getId()).put(
                null);
        return "redirect:./pages/base/fixed_area.html";
    }
   /* @RequestMapping("fixedArea_associationCourierToFixedArea")
    public String associationCourierToFixedArea(Integer courierId,Integer takeTimeId,FixedArea fixedArea) {
        // 调用业务层， 定区关联快递员
        fixedAreaService.associationCourierToFixedArea(fixedArea, courierId,
                takeTimeId);
        return "redirect:./pages/base/fixed_area.html";
    }*/

}
