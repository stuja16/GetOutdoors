import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

function SplashScreen() {
    return (
        <View style={styles.background}>
            <Text>Loading</Text>
        </View>
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