from firebase_streaming import Firebase
import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)

TRIG1 = 4 
ECHO1 = 17
TRIG2 = 27 
ECHO2 = 22
TRIG3 = 23 
ECHO3 = 24

print "Distance Measurement In Progress"

GPIO.setup(TRIG1,GPIO.OUT)
GPIO.setup(ECHO1,GPIO.IN)
GPIO.setup(TRIG2,GPIO.OUT)
GPIO.setup(ECHO2,GPIO.IN)
GPIO.setup(TRIG3,GPIO.OUT)
GPIO.setup(ECHO3,GPIO.IN)
fb = Firebase('https://fir-rtdbtest.firebaseio.com/')

GPIO.output(TRIG1, False)
GPIO.output(TRIG2, False)
GPIO.output(TRIG3, False)
print "Waiting For Sensor To Settle"
time.sleep(2)
while True:
    GPIO.output(TRIG1, True)
    time.sleep(0.00001)
    GPIO.output(TRIG1, False)


    while GPIO.input(ECHO1)==0:
        pulse_start1 = time.time()

    while GPIO.input(ECHO1)==1:
        pulse_end1 = time.time()
        
    pulse_duration1 = pulse_end1 - pulse_start1
    distance1 = pulse_duration1 * 17150
    distance1 = round(distance1, 2)

    
    if distance1<6:
        fb.child("Parking_spot").child('1').put('1')
    else:
        fb.child("Parking_spot").child('1').put('0')

    print "Distance1:",distance1,"cm"
    time.sleep(0.1)


    

    GPIO.output(TRIG2, True)
    time.sleep(0.00001)
    GPIO.output(TRIG2, False)


    while GPIO.input(ECHO2)==0:
        pulse_start2 = time.time()

    while GPIO.input(ECHO2)==1:
        pulse_end2 = time.time()

    pulse_duration2 = pulse_end2 - pulse_start2
    distance2 = pulse_duration2 * 17150
    distance2 = round(distance2, 2)
    if distance2<6:
        fb.child("Parking_spot").child('2').put('1')
    else:
        fb.child("Parking_spot").child('2').put('0')

    print "Distance2:",distance2,"cm"
    time.sleep(0.1)



    

    GPIO.output(TRIG3, True)
    time.sleep(0.00001)
    GPIO.output(TRIG3, False)


    while GPIO.input(ECHO3)==0:
        pulse_start3 = time.time()

    while GPIO.input(ECHO3)==1:
        pulse_end3 = time.time()

    pulse_duration3 = pulse_end3 - pulse_start3
    distance3 = pulse_duration3 * 17150
    distance3 = round(distance3, 2)
    if distance3<6:
        fb.child("Parking_spot").child('3').put('1')
    else:
        fb.child("Parking_spot").child('3').put('0')

    print "Distance3:",distance3,"cm"
    time.sleep(0.1)
GPIO.cleanup()

'''
    GPIO.output(TRIG3, True)
    time.sleep(0.00001)
    GPIO.output(TRIG3, False)



    while GPIO.input(ECHO3)==0:
        pulse_start3 = time.time()

#    while GPIO.input(ECHO3)==1:
#        pulse_end3 = time.time()

   
#    pulse_duration3 = pulse_end3 - pulse_start3

#    distance3 = pulse_duration3 * 17150

#    distance2 = round(distance2, 2)
#    distance3 = round(distance3, 2)
#    if distance2<6:
#        fb.child("Parking_spot").child('2').put('1')
#    else:
#        fb.child("Parking_spot").child('2').put('0')

#    print "Distance2:",distance2,"cm"
#    if distance3<6:
#        fb.child("Parking_spot").child('3').put('1')
#    else:
#        fb.child("Parking_spot").child('3').put('0')

#    print "Distance3:",distance3,"
'''
