import processing.core.PApplet;
  /**
   * A scavenger hunt game. Using the rocket, you are to explore the not so vast space in search for the legendary blue 
   * star using movement commands. Also alternatively a strobelight program and an art program.
   * 
   * @author: James Bian
   * Date: 01/06/22
   */

public class Sketch extends PApplet {
  int rocketY = 0;
  int rocketX = 0;
  int red = 25;
  int green = 25;
  int blue = 112;
  float randred = random(100, 255);
  float randgreen = random(100, 255);
  float randblue = random(100, 255);
  int starcount = 0;
  float randstarx = random(50, 600);
  float randstary = random(20, 300);
  float [] stararr = new float [30];

  int screensaver = 1;
  boolean drawmode = false;
  int rocketS = 0;
  String message = "";
  boolean keyup = false;
  boolean keydown = false;
  boolean keyright = false;
  boolean keyleft = false;

  
	
	
  /** 
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(600, 600);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    /**
     * Creates mouse and keyboard related controls to operate the rocket. The controls are as follows:
     * > Mouse Pressed: Creates an aftertrail of the rocket's movements and changes the colour of the background randomly
     * > KeyCode UP, DOWN, LEFT, RIGHT: Moves the rocket in the corresponding direction
     * > KeyCode Control: Places the rocket back at it's original position
     * > KeyCode SHIFT: Puts the brake on the rocket's movements, and pauses any movements done on the rocket
     */
    if (mousePressed == false) {
      if(drawmode == false) {
        background(red,green,blue);
    }
  }

    if (mousePressed) {
      if (drawmode == false) {
        screensaver = screensaver + 1;
        if (screensaver % 43 == 0) {
          randred = random(100, 220);
          randgreen = random(100, 220);
          randblue = random(100, 220);
        background(randred,randgreen,randblue);
      } 
    }
  }
  
    if (keyup == true) {
      rocketY = rocketY + 4;
      if (rocketY > 600) {
        rocketY = 0;
      }
    }

    if (keydown == true) {
      rocketY = rocketY - 4;
      if (rocketY < - 600) {
        rocketY = 0;
      }
    }

    if (keyright == true) {
      rocketX = rocketX + 4;
      if (rocketX > 600) {
        rocketX = 0;
    }
  }
  
    if (keyleft == true) {
      rocketX = rocketX - 4;
      if (rocketX < - 600) {
        rocketX = 0;
    }
  }

    if (keyCode == CONTROL) {
      rocketY = 0;
      rocketX = 0;
      drawmode = false;
      rocketS = 0;
      starcount = 0;
    }

    if (keyCode == SHIFT) {
      rocketS = rocketS + 0;
    }
    
    if (keyCode == TAB) {
      drawmode = true;
    }
    
    if (drawmode == true) {
      textSize(20);
      text(message, 25, 150);
      if (starcount < 30) {
        noStroke();
        int i = 0;
        stararr[i] = randstarx;
        i = i + 1;
        randstarx = random(50, 600);
        randstary = random(20, 300);
        fill(255,215,100);
        rect(randstarx, randstary, 10, 10);
        starcount = starcount + 1;
      }
    }

    //Guess the secret letter to win the game!
    if ((rocketX > -290) && (rocketX < -215 )) {
       if ((rocketY > -250) && (rocketY < -200)) {
        textSize(120);
        text(key, 500, 500);
        if (key == 'z') {
          System.out.println("Good Job");
          exit();
          if (key != 'z') {
            System.out.println("Not quite");
          }
      }
    }
  }

	// Drawings of the rocket and an insane amount of stars again
    
    noStroke();
    fill(255, 105, 105);
    ellipse(310 + rocketX, 400 - rocketY, 30 + rocketS, 60 + rocketS);
    ellipse(270 + rocketX, 400 - rocketY, 30 + rocketS, 60 + rocketS);
    fill(245, 245, 245);
    ellipse(290 + rocketX, 315 - rocketY, 70 + rocketS, 150 + rocketS);
    fill(197, 224, 255);
    ellipse(290 + rocketX, 285 - rocketY, 40 + rocketS, 40 + rocketS);
    fill(25,25,112);
    rect(40, 525, 10, 10);
    fill(255,255,15);
    fill(255,255,255);
    ellipse(mouseX, mouseY, 20, 20);
    if (key == 'b') {
      rocketS = rocketS - 1;
      
      }


  }
    
    public void mouseWheel() {
      rocketS = rocketS + 1;
    }
    public void mouseDragged() {
      fill(255,255,255);
      ellipse(mouseX, mouseY, 20, 20);
    }
    public void keyTyped() {
      message += key;
    }
    public void keyPressed() {

      if (keyCode == DOWN) {
        keydown = true;
      }

      if (keyCode == UP) {
        keyup = true;
      }

      if (keyCode == RIGHT) {
        keyright = true;
      }

      if (keyCode == LEFT) {
        keyleft = true;
      }
}
    public void keyReleased() {
      if (keyCode == UP) {
        keyup = false;
      }
      else if (keyCode == DOWN) {
        keydown = false;
      }
      else if (keyCode == LEFT) {
        keyleft = false;
      }
      else if (keyCode == RIGHT) {
        keyright = false;
  }
}
}

    
      
