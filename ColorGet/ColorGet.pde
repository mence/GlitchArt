PImage art, original;
String colors_as_hex = "";
String colors_as_int = "";

void setup() {
  // size(1578, 1080);
  art = loadImage("resources/Aivazovsky_Ivan_-_The_Ninth_Wave.jpg");
  image(art, 0, 0, width, height);

  loadPixels();
  for(int x = 0; x < width; x++) {
    for(int y = 0; y < height; y++) {
      colors_as_hex = colors_as_hex + hex(pixels[y*width+x]);
      colors_as_int = colors_as_int +
                      int(red(pixels[y*width+x])) +
                      int(green(pixels[y*width+x])) +
                      int(blue(pixels[y*width+x]));
    }
  }

  println("Hex:", colors_as_hex);
  println("Int:", colors_as_int);
}

void draw() {
}