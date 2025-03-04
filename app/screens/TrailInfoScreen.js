import React from "react";
import {
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  StatusBar,
} from "react-native";
import MapView from "react-native-maps";

// Local imports
import colors from "../config/colors";

function TrailInfoScreen({ route }) {
  // Retrieve parameter from navigation object from TrailList.js
  const { trailName, length, coordLat, coordLong } = route.params;

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView style={styles.scrollView}>
        <Text style={styles.title}>
          {JSON.stringify(trailName).replace(/\"/g, "")}
        </Text>
        <Text style={styles.text}>{length ? length.toFixed(2) : "?"} miles</Text>
        <MapView
          style={styles.map}
          region={{
            latitude: coordLat || "?",
            longitude: coordLong || "?",
            latitudeDelta: 0.00922,
            longitudeDelta: 0.00421,
          }}
        />
      </ScrollView>
    </SafeAreaView>
  );

  // To Do:
  //  - Add address? (Would need to convert from coords to address)
  //  - Add primary maintainer?
  //  - Add icons from list screen?
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: StatusBar.currentHeight,
    backgroundColor: colors.background,
  },
  scrollView: {
    marginHorizontal: 20,
  },
  title: {
    fontSize: 50,
    color: colors.primary,
    textAlign: "center",
  },
  text: {
    fontSize: 30,
    color: colors.secondary,
    textAlign: "center",
  },
  map: {
    width: "100%",
    height: 250,
    marginTop: 20,
    marginBottom: 20,
  },
  background: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});

export default TrailInfoScreen;
