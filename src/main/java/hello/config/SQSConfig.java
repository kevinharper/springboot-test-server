package hello.config;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class SQSConfig {


		@Value("${aws.accesskey}")
		private String awsAccessKey;
		
		@Value("${aws.secretkey}")
		private String awsSecretKey;

	@Bean
	@Named("amazonSqs")
	public AmazonSQS createSQSClient() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey,awsSecretKey);
	
		AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard()
    		.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
    		.withRegion(Regions.US_EAST_1)
    		.build();
  
		return amazonSQS;	
	}
}
