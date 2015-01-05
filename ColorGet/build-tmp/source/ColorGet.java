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

public class ColorGet extends PApplet {

PImage art, original;
String colors_as_hex = "";
String colors_as_int = "";

public void setup() {
  // size(1578, 1080);
  art = loadImage("resources/Aivazovsky_Ivan_-_The_Ninth_Wave.jpg");
  image(art, 0, 0, width, height);

  loadPixels();
  for(int x = 0; x < width; x++) {
    for(int y = 0; y < height; y++) {
      colors_as_hex = colors_as_hex + hex(pixels[y*width+x]);
      colors_as_int = colors_as_int +
                      PApplet.parseInt(red(pixels[y*width+x])) +
                      PApplet.parseInt(green(pixels[y*width+x])) +
                      PApplet.parseInt(blue(pixels[y*width+x]));
    }
  }

  println("Hex:", colors_as_hex);
  println("Int:", colors_as_int);
}

public void draw() {
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ColorGet" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
