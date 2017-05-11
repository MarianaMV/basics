import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class textParser2 extends PApplet {

int number1 = 65;
float number2 = 7.537f;
String[] nums = {10,15,20,35,45};

public void setup( ) {
  noLoop();
}

public void draw( ) {
  //convierte int a float
  println(PApplet.parseFloat (number1));

  //convierte float a int
  println(PApplet.parseInt(number2));

  //convierte n\u00famero en string binario
  println(binary(number1));

  println(nums[0]);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "textParser2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
