// comparing the computational performence of standard activation functions
// and their gradients

int numTests = 10000000;

void setup(){
  size(500,500);
  background(0);
  stroke(255);
  fill(255);
  translate(10,20);
  text("Comparing NN-activation functions. ("+numTests+" activations)",0,0);
  translate(0,20);
  text("FORWARD: + BACKWARD",0,0);
  translate(0,20);
  translate(0,20);


  int timer = millis();
  for(int i=0;i<numTests;i++){
    sigmoid(i);
    dSigmoid(i);
  }
  text("Sigmoid: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    softSign(i);
    dSoftSign(i);
  }
  text("SoftSign: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    tanh(i);
    dTanh(i);
  }
  text("Tanh: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    rectifiedLinear(i);
    dRectifiedLinear(i);
  }
  text("RectifiedLinear: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    arcTan(i);
    dArcTan(i);
  }
  text("ArcTan: "+(millis()-timer)+"ms",0,0);

}


//================================
// 0 -> 1
float sigmoid(float val) {  return 1.0 / (1.0 + exp(-1.0 * val));}
float dSigmoid(float val){  return val * (1.0 - val ) * 1.0;}
//================================
// -1 -> 1 (scale-able)
float softSign(float val) {  return val / (1.0 + abs(val));}
float dSoftSign(float val){  return 1.0/sq(1.0+abs(val)) * 1.0;}
//================================
// -1 -> 1
float tanh(float x) {  return (exp(x) - exp(-x)) / (exp(x) + exp(-x));}
float dTanh(float x){  return (1.0 - sq(x)) * 1.0; }
//================================
// 0 -> inf
float rectifiedLinear(float x) {  return max(x,0.0);}
float dRectifiedLinear(float x){  return (x > 0.0 ? x : 0.0);}
//================================
// -PI/2 -> PI/2
float arcTan(float x) {  return atan(x);}
float dArcTan(float x){  return(1.0/(sq(x)+1.0))*1.0;}
//================================
