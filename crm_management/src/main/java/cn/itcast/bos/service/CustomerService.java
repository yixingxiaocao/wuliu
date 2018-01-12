package cn.itcast.bos.service;

import cn.itcast.crm.domain.Customer;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by xuhongnan on 2018/1/2.
 */
public interface CustomerService
{
    //查询所有未关联客户的列表
    @Path("/noAssociationCustomers")
    @GET
    @Produces({"application/xml","application/json"})
public List<Customer> findNoAssociationCustomers();

//已经关联到指定定区的客户列表
    @Path("/findFixedAreaCustomers/{fixedareaid}")
    @GET
    @Produces({ "application/xml", "application/json" })                                                                                                                                                 
public List<Customer> findFixedAreaCustomers(@PathParam("fixedareaid") String fixedAreaId);
    @Path("/associationCustomersToFiexdArea")
    @PUT
    public void associationCustomersToFiexdArea(@QueryParam("customerIdStr") String customerIdStr, @QueryParam("fixedAreaId") String fixedAreaId);
    @Path("customer")
    @POST
    @Consumes({ "application/xml", "application/json" })
    public void regist(Customer customer);

    @Path("/customer/telephone/{telephone}")
    @GET
    @Consumes({ "application/xml", "application/json" })
    public Customer findByTelephone(@PathParam("telephone") String telephone);

    @Path("/customer/updatetype/{telephone}")
    @GET
    public void updateType(@PathParam("telephone") String telephone);

}
