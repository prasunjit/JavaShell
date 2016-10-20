/**
 * @author prasunjit
 */
package main.java.org.javashell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is kicked off when the user interacts with the application. THe
 * user input is parsed and separate process is kicked off
 * 
 */
public class AppStarterMain {

	/**
	 * @param args
	 * user enters the commands as the arguments
	 */

	// Constants
	public static final String SHELL_USERNAME = "shell.username";
	public static final String SHELL_HOSTNAME = "shell.computername";
	public static final String SHELL_PROMPT = "shell.prompt";
	// variables used in the class
	private static BufferedReader shell_input;

	public static void main(String[] args) {
		new AppStarterMain();
	}

	private AppStarterMain() {
		// initialize the shell
		initialize_shell();
		// process the user input in a a loop
		while (true)
			command_line_process();
	}

	private void command_line_process() {
		String text = read_command_line();
		//Start separate threads/process 
		
	}

	private String read_command_line() {
		String line = null;
		do {
			System.out.print(System.getProperty(SHELL_USERNAME));
			System.out.println(System.getProperty(SHELL_HOSTNAME));
			System.out.print(System.getProperty(SHELL_PROMPT));
			System.out.flush();
			line = parseInputLine();
		} while (line == null || line.trim().length() == 0);
		return line.trim();
	}

	private void initialize_shell() {
		// set up the shell input
		shell_input = new BufferedReader(new InputStreamReader(System.in));
		// initialize the environment
		initialize_env();
	}

	private void initialize_env() {
		Util.systemProperty(SHELL_PROMPT, ">");
		Util.systemProperty(SHELL_USERNAME, System.getenv("USERNAME"));
		Util.systemProperty(SHELL_HOSTNAME, System.getenv("COMPUTERNAME"));
	}

	private static String parseInputLine() {
		StringBuffer strBuffer = new StringBuffer();
		char temp_read_char;
		try {
			while ((temp_read_char = (char) shell_input.read()) != '\n') {
				strBuffer.append(temp_read_char);
			}
		} catch (IOException e) {
			// use LOG to print the error
			e.printStackTrace();
		}
		return strBuffer.toString();
	}
}
