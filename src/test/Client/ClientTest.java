package test.Client;

import com.psposs.PoJo.Java;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import net.sf.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * Created by Psposs on 2017/5/11.
 */
import javax.ws.rs.core.UriBuilder;
public class ClientTest {
    public static   void main(String a[]) throws URISyntaxException {
        ClientConfig cc = new DefaultClientConfig();
        cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(cc);
        URI uri=getBaseURI();
        WebResource resource=client.resource(uri);
//        String result=resource.path("/getString").type(MediaType.APPLICATION_FORM_URLENCODED).post(String.class);
//        System.out.println("PostGetString:"+result);

//        uri=getBaseURI();
//        resource=client.resource(uri);
        JSONObject json=resource.path("/getJson").accept(MediaType.APPLICATION_JSON) .type(MediaType.APPLICATION_JSON).post(JSONObject.class);
        System.out.print(json.toString());
    }
    public static URI getBaseURI() throws URISyntaxException {
        URI uri= UriBuilder.fromUri("http://localhost:8080/restFulApi/jersey/PostTest").port(8080).build();
        return uri;
    }
}
