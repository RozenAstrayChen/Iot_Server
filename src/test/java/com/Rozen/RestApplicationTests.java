package com.Rozen;

import com.Rozen.mqtt.MqttPublish;
import com.Rozen.mqtt.PublishSubscribe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestApplication.class)
public class RestApplicationTests {
	
	private MockMvc mvc;
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new MqttPublish()).build();
	}
	

	@Test
	public void TestMqtt() throws Exception{
		RequestBuilder request = null;
		//test post 
		
		request = post("/mqtt/")
				.param("topic", "EE_test")
				.param("broker", "tcp://192.168.0.10:1883")
				.param("qos", "2")
				.param("payload","mvc test");
		
		mvc.perform(request)
			.andExpect(content().string(equalTo("success")));
		
		System.out.printf("test unit success!!");
		
	}

}
