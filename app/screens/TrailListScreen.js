import React from "react";
import {
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from "react-native";
import FontAwesome from "@expo/vector-icons/FontAwesome";

import TrailList from "../components/TrailList";
import colors from "../config/colors";

function TrailListScreen() {
  // justifyContent for buttons not working

  return (
    <SafeAreaView style={styles.background}>
      <View
        style={{
          flexDirection: "row",
          justifyContent: "space-around",
          gap: 13,
          marginBottom: 8,
        }}
      >
        <TouchableOpacity style={styles.button}>
          <FontAwesome
            name="sort-amount-desc"
            size={17}
            color={colors.secondary}
          />
          <Text style={{ color: colors.secondary }}>Sort By</Text>
          <FontAwesome name="chevron-down" size={16} color={colors.secondary} />
        </TouchableOpacity>
        <TouchableOpacity style={styles.button}>
          <FontAwesome name="filter" size={16} color={colors.secondary} />
          <Text style={{ color: colors.secondary }}>Activity</Text>
          <FontAwesome name="chevron-down" size={16} color={colors.secondary} />
        </TouchableOpacity>
        <TouchableOpacity style={styles.button}>
          <FontAwesome name="filter" size={16} color={colors.secondary} />
          <Text style={{ color: colors.secondary }}>Length</Text>
          <FontAwesome name="chevron-down" size={16} color={colors.secondary} />
        </TouchableOpacity>
      </View>
      <TrailList />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  background: {
    justifyContent: "center",
    alignItems: "center",
    paddingTop: 30,
    backgroundColor: colors.background,
  },
  button: {
    flexDirection: "row",
    backgroundColor: colors.tertiary,
    paddingVertical: 5,
    paddingHorizontal: 15,
    borderRadius: 20,
    gap: 5,
  },
});

export default TrailListScreen;
