package jab; 

import jab.gun.*; 
import jab.module.*; 
import jab.module.Module; 
import jab.movement.*; 
import jab.radar.*; 
import jab.selectEnemy.*; 
import jab.targeting.*; 
import java.awt.Color; 

public   class  ModuleBot  extends Module {
	

	protected void initialize() {
		// TODO Customize the colors here
		setBodyColor(Color.BLACK);
		setGunColor(Color.BLACK);
		setRadarColor(Color.BLACK);
		setScanColor(Color.BLUE);
		setBulletColor(Color.RED);
	}

	

	protected void selectBehavior() {
		radar = selectedRadar;
		movement = selectedMovement;
		targeting = selectedTargeting;
		selectEnemy = selectedSelectEnemy;
		gun = selectedGun;
	}

	
	Radar selectedRadar = new MouseRadar(this);

	
	Targeting selectedTargeting = new MouseTargeting(this);

	
	Movement selectedMovement = new KeyboardMovement(this);

	
	SelectEnemy selectedSelectEnemy = new Closest(this);

	
	Gun selectedGun = new MouseClickGun(this);


}
