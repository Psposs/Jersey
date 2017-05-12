package com.psposs.service;

import com.psposs.PoJo.Java;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by chetuan on 2017/5/11.
 */
@Component
@Path("PostTest")
public class postTest {
    @POST
    @Produces(MediaType.APPLICATION_ATOM_XML)
    @Path("getString")
    public String  getPostString(){

        return "Post请求测试";
    }

    @POST
    @Path("getJson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getPostJson(){
        System.out.println("entry getPostJson");
        Map json=new HashMap();
        json.put("java","1");
        json.put("c","2");
        System.out.println("end getJson");
        return  json;
    }


}
