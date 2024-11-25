import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

function SplashScreen() {
    return (
        <ImageBackground
            style={styles.background}
            source={require("../assets/splash.jpg")}
        />
    );
}

const styles = StyleSheet.create({
    background: {
        paddingTop: 20,
        paddingBottom: 20,

        flex: 1,
        justifyContent: 'space-between',
        alignItems: 'center',
      },
})

export default SplashScreen;