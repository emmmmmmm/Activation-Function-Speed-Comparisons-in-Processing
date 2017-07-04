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

public class sketch_160525a_NN_activation_function_speed_comparison extends PApplet {

// comparing different activation functions:
int numTests = 10000000;

public void setup(){
  size(500,500);
  background(0);
  stroke(255);
  fill(255);
  translate(10,20);
  text("Comparing NN-activation functions. ("+numTests+" activations)",0,0);
  translate(0,20);
  text("FORWARD: + BACKWARD",0,0);
  translate(0,20);


  int timer = millis();
  for(int i=0;i<numTests;i++){
    sigmoid(i);
    Gsigmoid(i);
  }
  text("Sigmoid: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    softSign(i);
    GsoftSign(i);
  }
  text("SoftSign: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    tanh(i);
    Gtanh(i);
  }
  text("Tanh: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    rectifiedLinear(i);
    GrectifiedLinear(i);
  }
  text("RectifiedLinear: "+(millis()-timer)+"ms",0,0);
  translate(0,20);
  timer=millis();
  for(int i=0;i<numTests;i++){
    arcTan(i);
    GarcTan(i);
  }
  text("ArcTan: "+(millis()-timer)+"ms",0,0);

}


//================================
// 0 -> 1
public float sigmoid(float val) {  return 1.0f / (1.0f + exp(-1.0f * val));}
public float Gsigmoid(float val){  return val * (1.0f - val ) * 1.0f;}
//================================
// -1 -> 1 (scaleable)
public float softSign(float val) {  return val / (1.0f + abs(val));}
public float GsoftSign(float val){  return 1.0f/sq(1.0f+abs(val)) * 1.0f;}
//================================
// -1 -> 1
public float tanh(float x) {  return (exp(x) - exp(-x)) / (exp(x) + exp(-x));}
public float Gtanh(float x){  return (1.0f - sq(x)) * 1.0f; }
//================================
// 0 -> inf
public float rectifiedLinear(float x) {  return max(x,0.0f);}
public float GrectifiedLinear(float x){  return (x > 0.0f ? 1.0f*x : 0.0f);}
//================================
// -PI/2 -> PI/2
public float arcTan(float x) {  return atan(x);}
public float GarcTan(float x){  return(1.0f/(sq(x)+1.0f))*1.0f;}
//================================
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_160525a_NN_activation_function_speed_comparison" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
