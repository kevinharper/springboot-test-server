package hello.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Component
@Named("customerpublishservice")
public class CustomerPublishService {
	
	@Value("${aws.sqs.customerqueue}")
	private String queueUrl;
	
	@Inject
	@Named("amazonSqs")
	AmazonSQS amazonSqs;
	
	public void sendCustomerToSQS() {

		SendMessageRequest sendMessageStandardQueue = new SendMessageRequest()
				.withQueueUrl(queueUrl)
				.withMessageBody("Customer data message.");
		amazonSqs.sendMessage(sendMessageStandardQueue);
	}
	
}
