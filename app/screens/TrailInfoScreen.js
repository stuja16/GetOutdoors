import React from 'react';
import { SafeAreaView, ScrollView, StyleSheet, Text, StatusBar } from 'react-native';

function TrailInfoScreen({route, navigation}) {
    const { trailName } = route.params;

    return (
        <SafeAreaView style={styles.container}>
            <ScrollView style={styles.scrollView}>
                <Text style={styles.title}>{JSON.stringify(trailName).replace(/\"/g, "")}</Text>
                <Text style={styles.text}>Distance: 200 miles</Text>
            </ScrollView>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: StatusBar.currentHeight,
    },
    scrollView: {
        marginHorizontal: 20,
    },
    title: {
        fontSize: 50,
    },
    text: {
        fontSize: 30,
    },
    background: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    }
})

export default TrailInfoScreen;