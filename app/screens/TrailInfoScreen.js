import React from 'react';
import { SafeAreaView, ScrollView, StyleSheet, Text, StatusBar } from 'react-native';
import MapView from 'react-native-maps';

function TrailInfoScreen({route, navigation}) {
    const { trailName } = route.params;

    return (
        <SafeAreaView style={styles.container}>
            <ScrollView style={styles.scrollView}>
                <Text style={styles.title}>{JSON.stringify(trailName).replace(/\"/g, "")}</Text>
                <MapView 
                    style={styles.map}
                    region={{
                        latitude: 44.256717560654074,
                        longitude: -88.4091455998427,
                        latitudeDelta: 0.00922,
                        longitudeDelta: 0.00421,
                      }}
                />
                <Text style={styles.text}>Trail Distance: 200 miles</Text>
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
    map: {
      width: '100%',
      height: 150,
    },
    background: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    }
})

export default TrailInfoScreen;