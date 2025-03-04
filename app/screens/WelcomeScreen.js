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
                    title="Login"
                    color={colors.primary}
                    onPress={() => navigation.navigate('SignIn')}
                />
                <Button
                    title="Register"
                    color={colors.secondary}
                    onPress={() => navigation.navigate('List')}
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
        backgroundColor: colors.background,
        height: 70,
        color: colors.primary,
        fontSize: 45,
        fontWeight: "bold",
    },
    buttonsContainer: {
        width: "100%",
        bottom: 25,
    },
})

export default WelcomeScreen;