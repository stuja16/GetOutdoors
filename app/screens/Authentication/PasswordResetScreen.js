import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

function PasswordResetScreen() {
    return (
        <View style={styles.background}>
            <Text>Reset Your Password</Text>
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

export default PasswordResetScreen;