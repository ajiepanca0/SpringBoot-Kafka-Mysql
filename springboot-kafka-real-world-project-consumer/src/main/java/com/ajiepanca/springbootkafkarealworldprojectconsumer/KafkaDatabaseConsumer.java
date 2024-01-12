package com.ajiepanca.springbootkafkarealworldprojectconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ajiepanca.springbootkafkarealworldprojectconsumer.entity.WikimediaData;
import com.ajiepanca.springbootkafkarealworldprojectconsumer.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository dataRepository;
	
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@KafkaListener(
			topics = "wikimedia_recentchange",
			groupId = "myGroup"
	)
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Message received -> %s",eventMessage));
		
		
		// set to mysql
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		dataRepository.save(wikimediaData);
		
		//set to mongo
	}
}
