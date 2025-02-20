import React from "react";
import {
  StyleSheet,
  View,
  Text,
} from "react-native";

function SettingsScreen() {
  return (
    <View style={styles.background}>
      <Text>Settings</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  background: {
    paddingTop: 20,
    paddingBottom: 20,

    flex: 1,
    justifyContent: "space-between",
    alignItems: "center",
  },
});

export default SettingsScreen;