import React from 'react';
import { ImageBackground, StyleSheet, View, Text, Button } from 'react-native';

import colors from '../config/colors';

function WelcomeScreen(props) {
    return (
        <ImageBackground
            style={styles.background}
            source={require("../assets/welcome-background.jpg")}
        >
            <Text style={styles.logoContainer}> Get Outdoors </Text>
            <View style={styles.buttonsContainer}>
                <Button
                    styles={styles.loginButton}
                    onPress={this._onPressButton}
                    title="Login"
                    color={colors.primary}
                />
                <Button
                    style={styles.registerButton}
                    onPress={this._onPressButton}
                    title="Register"
                    color={colors.secondary}
                />
            </View>
        </ImageBackground>
    );
}

const styles = StyleSheet.create({
    background: {
        flex: 1,
        justifyContent: "flex-end",
        alignItems: "center",
    },
    logoContainer: {
        position: "absolute",
        top: 350,
        backgroundColor: colors.light,
        height: 70,
        color: colors.primary,
        fontSize: 45,
        fontWeight: "bold",
    },
    buttonsContainer: {
        width: "100%",
        bottom: 25,
    },
    loginButton: {
        width: "50%",
        fontSize: 30,
        backgroundColor: colors.primary
    },
    registerButton: {
        width: "100%",
        height: 70,
        backgroundColor: colors.secondary
    }
})

export default WelcomeScreen;