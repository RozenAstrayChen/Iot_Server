package com.Rozen.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleCallback implements MqttCallback{
	//lost connect
	public void connectionLost(Throwable arg0) {
		System.out.println("Connection lost to the broker");
	}
	//Called when a new message has arrived
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + topic);
        System.out.println("| Message: " + new String(message.getPayload()));
        System.out.println("-------------------------------------------------");
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("Delivery is Complete");
		
	}
}
