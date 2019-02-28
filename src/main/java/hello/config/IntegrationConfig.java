package hello.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class IntegrationConfig {
    public String INPUT_DIR = "/opt/springboot-test-server/integration/input";
    public String OUTPUT_DIR = "/opt/springboot-test-server/integration/output";
    public String FILE_PATTERN = "*.txt";
 
    @Bean
    public MessageChannel fileChannel() {
        return new DirectChannel();
    }
 
    @Bean
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "5"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader= new FileReadingMessageSource();
        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return sourceReader;
    }
 
	/*
	 * @Bean
	 * 
	 * @ServiceActivator(inputChannel= "fileChannel") public MessageHandler
	 * fileWritingMessageHandler() { FileWritingMessageHandler handler = new
	 * FileWritingMessageHandler(new File(OUTPUT_DIR));
	 * handler.setFileExistsMode(FileExistsMode.REPLACE);
	 * handler.setExpectReply(false); return handler; }
	 */
    
    
	@Splitter(inputChannel= "fileChannel", outputChannel= "stringListChannel")
	public List<String> splitMessage(File file) {
		ArrayList<String> lineList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			int count =0;
			System.out.println("Processing file " + file.getAbsolutePath());
			while((line = reader.readLine()) !=null) {
				StringBuffer sb = new StringBuffer();
				sb.append(OUTPUT_DIR).append("newFile").append(count++).append(".txt :::").append(line);
				System.out.println(sb.toString());	
				lineList.add(sb.toString());
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			
		}
		System.out.println("Finished with file " + file.getAbsolutePath());
		return lineList;
	}
	
	@Aggregator(inputChannel = "stringListChannel")
	public String aggregateMessages(List<String> lines) {
		System.out.println("Aggregate Data");
		int file =0;
		int lineNum =0;
		System.out.println("The entire list of lines for file" + ++file);
		System.out.println(lines.toString());
		for (String line : lines) {
			System.out.println("File="+ file + " Line=" + lineNum + " Text=" + line);
		}

		return "abc";
	}
	

}
