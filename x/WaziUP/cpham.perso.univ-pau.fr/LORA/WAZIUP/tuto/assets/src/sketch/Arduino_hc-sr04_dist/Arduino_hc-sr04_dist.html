/********************
 * Program:  HC-SR04 sensor tester
 * Description: print distance to serial
 ********************/
 
#define ECHO_PIN  6 
#define TRIG_PIN 7 

float v=331.5+0.6*20; // m/s

void setup() {
  // to run once
  Serial.begin(38400); // Initialize the serial port
  pinMode(TRIG_PIN, OUTPUT); 
  digitalWrite(TRIG_PIN, LOW);
  pinMode(ECHO_PIN, INPUT);
}

// Define a new function that reads and convert the raw reading to distance
float distance_centimetre() {
  // send sound pulse
  digitalWrite(TRIG_PIN, HIGH); // pulse started
  delayMicroseconds(12);
  digitalWrite(TRIG_PIN, LOW); // pulse stopped

  // listen for echo 
  float tUs = pulseIn(ECHO_PIN, HIGH); // microseconds
  float distance = tUs / 58; // cm
  return distance;
}

void loop() {
  Serial.print(distance_centimetre(), DEC);
  Serial.println("cm");
  delay(1000); // ms
}
