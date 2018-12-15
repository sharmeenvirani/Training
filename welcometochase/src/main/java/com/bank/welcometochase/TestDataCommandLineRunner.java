package com.bank.welcometochase;

import com.bank.welcometochase.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    private AccessToolRepository accessToolRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        accessToolRepository.save(new AccessTool(ToolName.AIM, "Production Deployment", StatusType.NOT_SUBMITTED));
        accessToolRepository.save(new AccessTool(ToolName.BIT_BUCKET, "Data Writer", StatusType.NEEDS_APPROVAL));
        accessToolRepository.save(new AccessTool(ToolName.EURC, "Phone Line", StatusType.NOT_ASSIGNED));
        accessToolRepository.save(new AccessTool(ToolName.JIRA, "Agile Dashboard", StatusType.COMPLETED));
        accessToolRepository.save(new AccessTool(ToolName.RSAM, "Server Access", StatusType.PENDING));

        userRepository.save(new User("Igor", "Vish",
                UserType.EMPLOYEE, UserStatus.EMPLOYED));
        userRepository.save(new User("Luke", "LukesLastName",
                UserType.EMPLOYEE, UserStatus.EMPLOYED));
    }
}
