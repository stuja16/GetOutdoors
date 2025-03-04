import React from "react";
import {
  FlatList,
  StyleSheet,
  Text,
  View,
  TouchableWithoutFeedback,
} from "react-native";
import { Divider } from "@rneui/themed";
import { useNavigation } from "@react-navigation/native";
import FontAwesome6 from "@expo/vector-icons/FontAwesome6";
import MaterialIcons from "@expo/vector-icons/MaterialIcons";

import colors from "../config/colors";

const TrailList = () => {
  const navigation = useNavigation();

  // Test trail data

  return (
    <View style={styles.background}>
      <FlatList
        data={[
          {
            key: "Scott Creek Hwt",
            length: 0.27188279,
            hiking: true,
            lat: 45.76155426751046,
            long: -89.06059277949225,
            maintainer: "US Forest Service",
          },
          {
            key: "Oak Island Trail",
            length: 0.92480217,
            hiking: true,
            long: -90.72771460815454,
            lat: 46.95792454482012,
            maintainer: "National Park Service",
          },
          {
            key: "Glacial Drumlin State Trail",
            length: 5.17468934,
            hiking: true,
            biking: true,
            long: -88.56189529589136,
            lat: 43.01163706969555,
            maintainer: "State",
          },
          {
            key: "Mccomb Ski Trail Spur C",
            length: 0.09643258,
            snowshoeing: true,
            skiing: true,
            long: -88.49576481370235,
            lat: 45.15041104450074,
            maintainer: "US Forest Service",
          },
        ]}
        renderItem={({ item }) => (
          <TouchableWithoutFeedback
            onPress={() => {
              navigation.navigate("Info", {
                trailName: item.key,
                length: item.length,
                coordLat: item.lat,
                coordLong: item.long,
                maintainer: item.maintainer,
              });
            }}
          >
            <View style={{ paddingVertical: 5 }}>
              <View style={styles.item}>
                <View style={{ flexShrink: 1 }}>
                  <Text style={styles.name}>{item.key}</Text>
                  <Text style={styles.length}>
                    {item.length ? item.length.toFixed(2) : "?"} miles
                  </Text>
                </View>
                <View style={styles.iconRow}>
                  {item.hiking && (
                    <FontAwesome6
                      name="person-hiking"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                  {item.biking && (
                    <FontAwesome6
                      name="person-biking"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                  {item.snowshoeing && (
                    <MaterialIcons
                      name="snowshoeing"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                  {item.skiing && (
                    <FontAwesome6
                      name="person-skiing-nordic"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                </View>
              </View>
              <Divider color={colors.primary} />
            </View>
          </TouchableWithoutFeedback>
        )}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  background: {
    paddingTop: 22,
    backgroundColor: colors.background,
  },
  item: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    paddingHorizontal: 10,
    paddingBottom: 12,
  },
  name: {
    color: colors.primary,
    fontSize: 25,
    flexWrap: "wrap",
    flexShrink: 1,
  },
  length: {
    fontSize: 17,
    color: colors.secondary,
  },
  iconRow: {
    flexDirection: "row",
    justifyContent: "center",
    paddingHorizontal: 20,
    gap: 20,
  },
});

export default TrailList;
