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

public class textParser01 extends PApplet {

String[] textLines;

public void setup( ) {
  size(640,200 , P3D);
  smooth();

  textLines = loadStrings("test1.csv");

  noLoop();
}

public void draw( ) {
  background(255);
  translate(20,height/2);

  stroke(128);
  fill(255,128);

  for (int i = 0; i < textLines.length; i++){
    String[] currentLine = split(textLines[i],",");
    for(int j = 0; j < currentLine.length; j++){
      println(currentLine[j]);
    }
    println("---");
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "textParser01" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
