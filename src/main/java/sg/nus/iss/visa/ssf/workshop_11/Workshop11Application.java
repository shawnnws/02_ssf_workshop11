package sg.nus.iss.visa.ssf.workshop_11;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Workshop11Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);

	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {

		logger.info("Math method started...");

		//Initialize Spring app
		SpringApplication app = new SpringApplication(Workshop11Application.class);

		//Read args array and check for "port" parameter
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List opsValues = appArgs.getOptionValues("port");

		String portNumber = null;

		//If port number is not in argument
		if (opsValues == null || opsValues.get(0) == null) {

			//read port number from env variables
			portNumber = System.getenv("PORT");

			if (portNumber == null) {
				portNumber = DEFAULT_PORT;
			}
			
			else {
				//pass port number from CLI
				portNumber = opsValues.get(0).toString();
			}

			if (portNumber != null) {
				//set port number in the spring boot config
				app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
			}

			//run Springboot app
			app.run(args);
		}
	}
}
