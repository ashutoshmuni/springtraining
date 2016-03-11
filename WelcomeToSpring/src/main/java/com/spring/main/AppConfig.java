package com.spring.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.beans.MessagePrinterBean;

@Configuration
public class AppConfig {

	@Bean(name="messagePrinter")
	public MessagePrinterBean getMessagePrinterBean() {
		return new MessagePrinterBean();
	}
}
