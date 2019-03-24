export DEV_HOME=~/Bureau/JSON
export ANDROID_HOME=~/Bureau/JSON
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$ANDROID_HOME/build-tools/20.0.0

aapt package -f -m -S $DEV_HOME/res -J $DEV_HOME/src -M $DEV_HOME/AndroidManifest.xml -I $ANDROID_HOME/platforms/android-18/android.jar

javac -source 1.7 -target 1.7 -d $DEV_HOME/obj -classpath $ANDROID_HOME/platforms/android-18/android.jar:$DEV_HOME/lib/android-support-v4.jar -sourcepath $DEV_HOME/src $DEV_HOME/src/com/mkyong/android/HelloWorldActivity.java
# --no-strict
java -jar $ANDROID_HOME/build-tools/20.0.0/lib/dx.jar --dex --output=$DEV_HOME/bin/classes.dex $DEV_HOME/obj $DEV_HOME/lib

aapt package -f -m -S $DEV_HOME/res -M $DEV_HOME/AndroidManifest.xml -I $ANDROID_HOME/platforms/android-18/android.jar -F $DEV_HOME/bin/AndroidTest.unsigned.apk $DEV_HOME/bin

jarsigner -sigalg MD5withRSA -digestalg SHA1 -keystore $ANDROID_HOME/AndroidTest.keystore -storepass password -keypass password -signedjar $DEV_HOME/bin/AndroidTest.signed.apk $DEV_HOME/bin/AndroidTest.unsigned.apk AndroidTestKey

zipalign -f 4 $DEV_HOME/bin/AndroidTest.signed.apk $DEV_HOME/bin/AndroidTest.apk

emulator -wipe-data -avd MySonyEricsson

adb -e install $DEV_HOME/bin/AndroidTest.apk

#android create avd --name Android --target android-18 --sdcard 1024M
#android delete avd --name Android
#keytool -genkeypair -validity 10000 -dname "CN=company name,OU=organisational unit,O=organisation,L=location,S=state,C=country code" -keystore $ANDROID_HOME/AndroidTest.keystore -storepass password -keypass password -alias AndroidTestKey -keyalg RSA -v
