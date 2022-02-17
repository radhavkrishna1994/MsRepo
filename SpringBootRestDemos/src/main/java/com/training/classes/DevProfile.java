package com.training.classes;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.training.interfaces.TestProfile;

@Component
@Profile("dev")
public class DevProfile implements TestProfile {

	@Override
	public void process() {
		System.out.println("This is Dev Profile");

	}

}
