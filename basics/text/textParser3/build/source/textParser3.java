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

public class textParser3 extends PApplet {

float[] price;
float minPrice, maxPrice;
float x1, y1, x2, y2;

int[] mm;

PFont legendFont = createFont("SansSerif",20);

public void setup( ) {
  size(800,600, P3D);
  x1 = 50; y1= 50;
  x2= width -50;
  y2 = height - y1;
  smooth();
  textFont(legendFont);
  String[] lines = loadStrings("aapl.txt");

  price = new float[lines.length];
  //println(price);
  mm = new int[lines.length];
  for(int i = 0; i < lines.length; i++){
    String[] pieces = split(lines[i],",");
    price[i]= PApplet.parseFloat(pieces[5]);
    mm[i] = PApplet.parseInt(pieces[0]);
  }
  println("Data loaded: "+price.length+" entries.");

  minPrice = min(price);
  maxPrice = max(price);
  println("Min: "+minPrice);
  println("Max: "+maxPrice);
}



public void draw( ) {
  background(0);
  rectMode(CORNERS);
  noStroke();
  fill(255);
  rect(x1,y1,x2,y2);
  drawGraph(price,minPrice,maxPrice);

  //t\u00edtulo
  fill(255);
  textSize(18);
  textAlign(LEFT);
  text("(AAPL) Apple Inc. 2016",x1,y1-10);
  textSize(10);
  textAlign(RIGHT,BOTTOM);
  text("Fuente: google finance (google.com/finance)", width-10, height-10);

  //banderas de los ejes
  drawXLabels();
  drawYLabels();
}

//funci\u00f3n drawYLabels
public void drawYLabels( ) {
  fill(255);
  textSize(10);
  textAlign(RIGHT);
  stroke(255);

  for(float i = minPrice ; i < maxPrice; i+=2){
    float y = map(i,minPrice,maxPrice,y2,y1) ;
    text(floor(i),x1-10,y);
    line(x1,y,x1-5,y);
  }
  textSize(18);
  text("$",x1-40,height/2);
}

//funci\u00f3n drawXLabels
public void drawXLabels( ) {

  fill(255);
  textSize(10);
  textAlign(CENTER);

  int m = 0;
  for (int i=0; i<mm.length; i++) {
    if (mm[i] == m) continue;
    m = mm[i];
    float x = map(i, 0, mm.length, x1, x2);
    text(m, x, y2+10);
    strokeWeight(0.3f);
    line(x, y2, x, y1);
  }
  textSize(18);
  textAlign(CENTER, TOP);
  text("Month", width/2, y2+10);
}

public void drawGraph(float[]data , float yMin, float yMax ) {
  stroke(0);
  beginShape();
    for(int i=0; i<data.length; i++){
      float x = map(i,0,data.length-1, x1, x2);
      float y = map(data[i], yMin, yMax, y1,y2) ;
      vertex(x,y);
    }
  endShape();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "textParser3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
