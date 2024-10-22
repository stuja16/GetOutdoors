import React from 'react';
import { ImageBackground, StyleSheet, View, Text, Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import colors from '../config/colors';

function WelcomeScreen({ navigation }) {
    return (
        <ImageBackground
            style={styles.background}
            source={require("../assets/welcome-background.jpg")}
        >
            <Text style={styles.logoContainer}> Get Outdoors </Text>
            <View style={styles.buttonsContainer}>
                <Button
                    styles={styles.loginButton}
                    title="Login"
                    color={colors.primary}
                    onPress={() => navigation.navigate('List')}
                />
                <Button
                    style={styles.registerButton}
                    title="Register"
                    color={colors.secondary}
                    onPress={this._onPressButton}
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
        backgroundColor: colors.primary
    },
    registerButton: {
        width: "100%",
        height: 70,
        backgroundColor: colors.secondary
    }
})

export default WelcomeScreen;