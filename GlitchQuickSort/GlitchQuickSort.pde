PImage img;
int increment=2;

void setup() {
  size(1578, 1080);
  img = loadImage("resources/Great_Wave_off_Kanagawa2_1080.jpg");
  image(img, 0, 0, width, height);
  loadPixels();
  for (int x = 0; x < ((width*height)-(increment+2)); x+=increment) {
    quicksort(pixels, x, x+increment);
  }
  updatePixels();
}

int partition(int x[], int left, int right) {
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

void quicksort(int x[], int left, int right) {
  int index = partition(x, left, right);
  if (left < index - 1) {
    quicksort(x, left, index-1);
  }
  if (index < right) {
    quicksort(x, index, right);
  }
}

void draw() {
}