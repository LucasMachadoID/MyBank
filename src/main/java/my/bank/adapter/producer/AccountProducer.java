package my.bank.adapter.producer;

import my.bank.adapter.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountProducer {

    @Value("kafka.topic.account-interest-rate")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Account> kafkaTemplate;

    public void sendEvent(Account account) {
        kafkaTemplate.send(topicName, account);
    }

}
