package com.unipi.ipap.domainservice.config;

import com.unipi.ipap.appcommons.model.Domain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kStream -> kStream.foreach((key, domain) -> {
            String isActive = domain.getIsDead() ? "Inactive" : "Active";
            log.info("Domain consumed: {}, status: {}", domain.getDomain(), isActive);
        });
    }
}
