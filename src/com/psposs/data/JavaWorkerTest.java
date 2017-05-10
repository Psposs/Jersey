package com.psposs.data;

import com.alibaba.fastjson.JSON;
import com.psposs.PoJo.Java;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by psposs on 2017/5/10.
 *
 * Jersey
 * @path 标注资源类或者方法的相对路径
 * @GET @PUT @POST @DELETE 标注方法是http请求类型
 * @Produces 标注返回的MIME媒体类型
 * @Consumes 标注可接受请求的MIME媒体类型
 * MIME 类型 MIME (Multipurpose Internet Mail Extensions) 是描述消息内容类型的因特网标准。 MIME 消息能包含文本、图像、音频、视频以及其他应用程序专用的数据。
 *
 *  @PathParam  @QueryParam,@HeaderParam,@CookieParam,@MatrixParam,@MatrixParam,@FormParam,分别标注方法的参数
 * 来自于HTTP请求的不同位置
 * 例:
 * @PathParam来自于URL的路径,@QueryParam来自于URL的查询参数,@HeaderParam来自于HTTP请求头信息
 * @CookieParam来自HTTP请求的Cookie
 *
 * Jersey是JAX-RS的参考实现
 *      核心服务器（Core Server）：通过提供 JSR 311 中标准化的注释和 API 标准化，您可以用直观的方式开发 RESTful Web 服务。
 *      核心客户端（Core Client）：Jersey 客户端 API 帮助您与 REST 服务轻松通信。
 *      集成（Integration）：Jersey 还提供可以轻松集成 Spring、Guice、Apache Abdera 的库
 */
//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@Path("/Java")
public class JavaWorkerTest {
    @GET//该注解表示被标记的方法提供的是一个GET请求
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})//该注解表示以json或者xml文件的形式进行输出，类似于SpringMVC中的@ResponseBody注解
    public String getJava(){
        System.out.print("entry jersey");

        Map map=new HashMap();
        map.put("Java1","SpringMVC");
        map.put("Java2","struts2");

        return  JSON.toJSONString(map);
    }
    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String getPathParam(@PathParam("param") String getParam){
        return  "JavaWorker is?"+getParam;
    }

    @GET
    @Path("/work/post")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPostJava(){
        System.out.print("entry post jersey ");
        Java java=new Java();
        java.setAge("30");
        java.setName("proMonkoney");
        java.setSex("man");
        return  JSON.toJSONString(java);
    }
}
