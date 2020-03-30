package com.example.chamber.controller;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@ExtendWith(MockitoExtension.class)
public class TestAnimateController {
	@InjectMocks
	AnimateController animateController;

		
    @Test
    public void testAnimate() {
    	MockHttpServletRequest request = new MockHttpServletRequest();
    	RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    	List<String> expectedParticleLocation = Arrays.asList(new String[] {"XX..XXX", ".X.XX..", "X.....X", "......."});
    	
    	AnimateControllerParam animateParam = new AnimateControllerParam();
    	animateParam.setSpeed(3);
    	animateParam.setInit("RR..LRL");
    	
		List<String> responses = animateController.animate(animateParam);
		responses.forEach(System.out::println);
		
		Assertions.assertEquals(expectedParticleLocation, responses);
		
    }


    
}
