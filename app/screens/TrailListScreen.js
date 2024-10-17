import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

import List from '../components/TrailList';
import TrailList from '../components/TrailList';

function TrailListScreen(props) {
    return (
        <View style={styles.background}>
            <TrailList />
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