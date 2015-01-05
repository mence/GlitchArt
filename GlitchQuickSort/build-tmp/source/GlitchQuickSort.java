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

public class GlitchQuickSort extends PApplet {

PImage img;
int increment=2;

public void setup() {
  size(1578, 1080);
  img = loadImage("resources/Great_Wave_off_Kanagawa2_1080.jpg");
  image(img, 0, 0, width, height);
  loadPixels();
  for (int x = 0; x < ((width*height)-(increment+2)); x+=increment) {
    quicksort(pixels, x, x+increment);
  }
  updatePixels();
}

public int partition(int x[], int left, int right) {
  int i = left;
  int j = right;
  int temp;
  int pivot = x[(left+right)/2];
  while (i <= j) {
    while (x[i] < pivot) {
      i++;
    }
    while (x[j] > pivot) {
      j--;
    }
    if (i <= j) {
      temp = x[i];
      x[i] = x[j];
      x[j] = temp;
      i++;
      j--;
    }
  }
  return i;
}

public void quicksort(int x[], int left, int right) {
  int index = partition(x, left, right);
  if (left < index - 1) {
    quicksort(x, left, index-1);
  }
  if (index < right) {
    quicksort(x, index, right);
  }
}

public void draw() {
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GlitchQuickSort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
