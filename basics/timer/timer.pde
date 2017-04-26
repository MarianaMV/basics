int time;
int wait = 10000;

void setup(){
  time = millis();//store the current time
}
void draw(){
  //check the difference between now and the previously stored time is greater than the wait interval
  if(millis() - time >= wait){
    println("tick");//if it is, do something
    time = millis();//also update the stored time
  }
}