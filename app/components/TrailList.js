import React from "react";
import {
  FlatList,
  StyleSheet,
  Text,
  View,
  TouchableWithoutFeedback,
} from "react-native";
import { useNavigation } from "@react-navigation/native";
import FontAwesome6 from "@expo/vector-icons/FontAwesome6";

import colors from "../config/colors";

const TrailList = () => {
  const navigation = useNavigation();

  return (
    <View style={styles.background}>
      <FlatList
        data={[
          { key: "Newberry Trail", length: 1.75, hiking: true },
          { key: "Hydroelectric Heritage Trailway" },
          { key: "Telulah Park" },
          { key: "Ellen Kort Peace Park" },
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
              });
            }}
          >
            <View style={styles.item}>
              <View>
                <Text style={styles.name}>{item.key}</Text>
                <Text style={styles.length}>{item.length || "?"} miles</Text>
              </View>
              <View style={styles.iconRow}>
                <FontAwesome6
                  name="person-hiking"
                  size={24}
                  color={colors.primary}
                />
                <FontAwesome6
                  name="person-biking"
                  size={24}
                  color={colors.primary}
                />
              </View>
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
    height: 70,
  },
  name: {
    fontSize: 25,
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