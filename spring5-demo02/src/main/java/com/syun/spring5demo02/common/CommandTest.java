package com.syun.spring5demo02.common;

import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-03-25 21:02
 */
public class CommandTest {

    // This test method is a client
    @Test
    public void test() {

        Administrator admin = new Administrator();
        Server server = new Server();

        // start Apache
        admin.setCommand(new StartApache(server));
        admin.typeEnter();

        // start Tomcat
        admin.setCommand(new StartTomcat(server));
        admin.typeEnter();

        // check executed commands
        int executed = server.getExecutedCommands().size();
        assertTrue("Two commands should be executed but only "+
                executed+ " were", executed == 2);
    }

}

// commands
abstract class ServerCommand {

    protected Server server;

    public ServerCommand(Server server) {
        this.server = server;
    }

    public abstract void execute();
}

class StartTomcat extends ServerCommand {

    public StartTomcat(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        server.launchCommand("sudo service tomcat7 start");
    }
}

class StartApache extends ServerCommand {

    public StartApache(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        server.launchCommand("sudo service apache2 start");
    }
}

// invoker
class Administrator {

    private ServerCommand command;

    public void setCommand(ServerCommand command) {
        this.command = command;
    }

    public void typeEnter() {
        this.command.execute();
    }

}

// receiver
class Server {

    // as in common terminals, we store executed commands in history
    private List<String> executedCommands = new ArrayList<>();

    public void launchCommand(String command) {
        System.out.println("Executing: "+command+" on server");
        this.executedCommands.add(command);
    }

    public List<String> getExecutedCommands() {
        return this.executedCommands;
    }

}