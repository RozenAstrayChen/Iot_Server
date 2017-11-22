package com.Rozen.mqtt;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Rozen.user.User;

@RestController
@RequestMapping(value = "/mqtt")
public class MqttPublish {
	
	
	@RequestMapping(method=RequestMethod.POST) 
	public String WebPublish(String topic, String broker, int qos,String payload) {
		PublishSubscribe pubScb = new PublishSubscribe(topic, qos, broker);
		pubScb.Publish(payload);
		System.out.println("success");
		return "successful";
		
		
	}
}
