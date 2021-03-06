package com.unipi.ipap.domaincrawler.service;

import com.unipi.ipap.appcommons.model.Domain;
import com.unipi.ipap.appcommons.model.DomainList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainCrawlerService {

    private final KafkaTemplate<String, Domain> kafkaTemplate;
    private final String KAFKA_TOPIC = "web-domains";
    private final WebClient.Builder webClient;

    public void crawl(String name) {
         webClient
                 .baseUrl("https://api.domainsdb.info/v1/")
                 .build()
                 .get()
                 .uri(uriBuilder -> uriBuilder
                         .path("/domains/search")
                         .queryParam("domain", name)
                         //.queryParam("zone", "")
                         .build()
                 )
                 .accept(MediaType.APPLICATION_JSON)
                 .retrieve()
                 .bodyToMono(DomainList.class)
                 .subscribe(domainList -> domainList.getDomains()
                         .forEach(domain -> {
                             kafkaTemplate.send(KAFKA_TOPIC, domain);
                             log.info("Domain message: {}", domain.getDomain());
                         }));
    }
}
