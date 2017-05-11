String[] textLines;

void setup( ) {
  size(640,200 , P3D);
  smooth();

  textLines = loadStrings("test1.csv");

  noLoop();
}

void draw( ) {
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
