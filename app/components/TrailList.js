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
            biking: false,
            snowshoeing: false,
            skiing: false,
            lat: 45.76155426751046,
            long: -89.06059277949225,
          },
          {
            key: "Oak Island Trail",
            length: 0.92480217,
            hiking: true,
            long: -90.72771460815454,
            lat: 46.95792454482012,
          },
          {
            key: "Newberry Trail",
            length: 1.75,
            hiking: true,
            biking: true,
            snowshoeing: true,
            skiing: false,
            lat: 44.26199743054238,
            long: -88.40139410140904,
          },
          {
            key: "Hydroelectric Heritage Trailway Park",
            hiking: true,
            biking: true,
            snowshoeing: true,
            skiing: true,
          },
          { key: "Telulah Park" },
          {
            key: "Ellen Kort Peace Park",
            lat: 44.256717560654074,
            long: -88.4091455998427,
          },
          { key: "Old Stone Bridge Trail" },
          { key: "Peabody Park" },
          { key: "Trestle Trail" },
          { key: "Loop the Little Lake Trail" },
          { key: "Bubolz Nature Preserve" },
          { key: "Heckrodt Wetland Reserve" },
          { key: "Example Trail" },
        ]}
        renderItem={({ item }) => (
          <TouchableWithoutFeedback
            onPress={() => {
              navigation.navigate("Info", {
                trailName: item.key,
                length: item.length,
                coordLat: item.lat,
                coordLong: item.long,
              });
            }}
          >
            <View style={{paddingVertical:5}}>
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
              <Divider
                color={colors.primary}
              />
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
    color: "grey",
  },
  iconRow: {
    flexDirection: "row",
    justifyContent: "center",
    paddingHorizontal: 20,
    gap: 20,
  },
});

export default TrailList;
