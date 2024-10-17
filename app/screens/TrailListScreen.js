import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

function TrailListScreen(props) {
    return (
        <View style={styles.background}>
            <Text>Trail List Screen</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    background: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    }
})

export default TrailListScreen;