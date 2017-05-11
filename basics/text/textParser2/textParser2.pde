int number1 = 65;
float number2 = 7.537;


void setup( ) {
  noLoop();
}

void draw( ) {
  //convierte int a float
  println(float (number1));

  //convierte float a int
  println(int(number2));

  //convierte número en string binario
  println(binary(number1));
  
}
