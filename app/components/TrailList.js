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
import MaterialCommunityIcons from "@expo/vector-icons/MaterialCommunityIcons";

// Local imports
import colors from "../config/colors";

// TrailData.json holds current production data
// Trans_TrailSegment.json holds full data from USGS National Transportation Database
//  - Needs cleaning for trails without names
//  - Remove duplicates: same values for "sourcefeatureid" and "sourcedatasetid" OR same value for "trailnumber"
//  - Other data cleaning needs?

// Add optimization for FlatList
//  - Lazy rendering for not currently displayed?

const TrailList = (props) => {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <FlatList
        data={props.data}
        renderItem={({ item }) => (
          <TouchableWithoutFeedback
            onPress={() => {
              navigation.navigate("Info", {
                trailName: item.properties.name,
                length: item.properties.lengthmiles,
                coordLat: item.geometry.coordinates[0][1],
                coordLong: item.geometry.coordinates[0][0],
                maintainer: item.properties.primarytrailmaintainer,
                trailId: item.id,
              });
            }}
          >
            <View style={{ paddingVertical: 5 }}>
              <View style={styles.item}>
                <View style={{ flexShrink: 1 }}>
                  <Text style={styles.name}>{item.properties.name}</Text>
                  <Text style={styles.length}>
                    {item.properties.lengthmiles
                      ? item.properties.lengthmiles.toFixed(2)
                      : "?"}{" "}
                    miles
                  </Text>
                </View>
                <View style={styles.iconRow}>
                  {item.properties.hikerpedestrian == "Y" && (
                    <FontAwesome6
                      name="person-hiking"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                  {item.properties.bicycle == "Y" && (
                    <FontAwesome6
                      name="person-biking"
                      size={24}
                      color={colors.primary}
                    />
                  )}
                  {item.properties.packsaddle == "Y" && (
                    <MaterialCommunityIcons
                      name="horse-human"
                      size={28}
                      color={colors.primary}
                    />
                  )}
                  {item.properties.snowshoe == "Y" && (
                    <MaterialIcons
                      name="snowshoeing"
                      size={28}
                      color={colors.primary}
                    />
                  )}
                  {item.properties.crosscountryski == "Y" && (
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
  container: {
    backgroundColor: colors.background,
    marginBottom: 38,
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
