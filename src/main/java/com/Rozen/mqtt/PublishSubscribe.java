package com.Rozen.mqtt;

import java.nio.charset.Charset;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class PublishSubscribe {
	private String topic = "sample";
	private int qos = 2;
	private String broker = "tcp://localhost:1883";
	private String clientId = "sample";
	//private MqttClient mqttClient = null;
	
	public PublishSubscribe(String topic, int qos, String broker) {
		this.topic = topic;
		this.qos = qos;
		this.broker = broker;
	}
	private MqttClient mqttConnect() throws MqttException{
		MemoryPersistence memoryPer = new MemoryPersistence();
		System.out.println("MQTT connect borker " + broker + " and Topic " + topic);
		MqttClient mqttClient = new MqttClient(broker, clientId , memoryPer);
		MqttConnectOptions connOptions = new MqttConnectOptions();
		connOptions.setCleanSession(true);
		mqttClient.connect(connOptions);
		System.out.println("connect to broker!\n");
		
		return mqttClient;
	}
	public void Publish(String payload) {
		try {
			MqttClient client = mqttConnect();
			System.out.println("payload message " + payload.toString());
			
			MqttMessage message = new MqttMessage(payload.toString().getBytes(Charset.forName("UTF-8")));
			client.setCallback(new SimpleCallback());
			//publish
			client.publish(topic, message);
			System.out.println("message has been published");
			client.disconnect();
			System.out.println("client disconnected");
			
		}catch(MqttException me) {
			System.out.println("reason " + me.getReasonCode());
	        System.out.println("msg " + me.getMessage());
	        System.out.println("loc " + me.getLocalizedMessage());
	        System.out.println("cause " + me.getCause());
	        System.out.println("except " + me);
	        me.printStackTrace();
		}
	}
}
