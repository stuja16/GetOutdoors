import React from 'react';
import { StyleSheet, View } from 'react-native';

import TrailList from '../components/TrailList';

function TrailListScreen() {
    return (
        <View style={styles.background}>
            <TrailList/>
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