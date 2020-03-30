package com.example.chamber.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChamberManager{
	private int chamberSize;
	private int speed;
	private boolean[] leftWardParticles;
	private boolean[] rightWardParticles;
	
	public ChamberManager(int speed, String initCondition) {
		super();
		this.chamberSize = initCondition.length();
		this.speed = speed;
		this.leftWardParticles = new boolean[chamberSize];
		this.rightWardParticles = new boolean[chamberSize];
		
		char[] particlesLocationArray = initCondition.toCharArray();
		for(int i=0; i<particlesLocationArray.length; i++) {
			if (particlesLocationArray[i]=='L') {
				leftWardParticles[i] = true;
			}else if (particlesLocationArray[i]=='R'){
				rightWardParticles[i] = true;
			}
		}				
	}			
	
	public int getChamberSize() {
		return chamberSize;
	}

	public int getSpeed() {
		return speed;
	}
	public boolean[] getLeftWardParticles() {
		return leftWardParticles;
	}

	public boolean[] getRightWardParticles() {
		return rightWardParticles;
	}

		
	public String getParticleLocation() {
		char[] particleLocations = new char[chamberSize];
		Arrays.fill(particleLocations, '.');
		for(int i=0; i<chamberSize; i++) {
			if (leftWardParticles[i]|| rightWardParticles[i]) {
				particleLocations[i]='X';
			}
		}		
		return new String(particleLocations);		
	}
	
	public List<String> animate() {
		List<String> chamberParticleAnimations = new ArrayList<>();
		chamberParticleAnimations.add(getParticleLocation());

		while(!isEmptyChamber()){
			move();
			chamberParticleAnimations.add(getParticleLocation());
		}		
		return chamberParticleAnimations;
	}	
	
	public String move() {
		
		//Moving left
		for (int i=0; i<chamberSize; i++) {
			if (leftWardParticles[i]) {
				if (i-speed>=0) {
					leftWardParticles[i-speed]= leftWardParticles[i];
				}
				leftWardParticles[i] =  false;
			}
		}
		
		//Moving right
		for (int i=chamberSize-1; i>=0; i--) {
			if (rightWardParticles[i]) {
				if (i+speed<=chamberSize-1) {
					rightWardParticles[i+speed]= rightWardParticles[i];
				}
				rightWardParticles[i] = false;
			}
		}						
		return getParticleLocation();
	}
	
	public boolean isEmptyChamber() {
		boolean result = true;
				
		for (int i =0; i<chamberSize; i++) {
			if (leftWardParticles[i] || rightWardParticles[i]){
				return false;
			}
		}
		return result;
	}
	
}
