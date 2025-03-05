import React, { useEffect, useState } from "react";
import {
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  StatusBar,
  TouchableOpacity,
} from "react-native";
import MapView from "react-native-maps";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { MaterialCommunityIcons } from "@expo/vector-icons";

// Local imports
import colors from "../config/colors";

function TrailInfoScreen({ route }) {
  // Retrieve parameter from navigation object from TrailList.js
  const { trailName, length, coordLat, coordLong, maintainer, trailId } =
    route.params;
  const [isLoading, setIsLoading] = useState(true);
  const [bookmark, setBookmark] = useState(false);

  useEffect(() => {
    getItem();
  }, []);

  // UseEffect hook to check the state of bookmark if loading
  useEffect(() => {
    if (!isLoading) {
      renderBookmark(trailId);
    }
  }, [isLoading]);

  // Run when screen is loaded
  const getItem = () => {
    setIsLoading(false);
  };

  // Runs when user bookmarks current trail
  // itemId is a string
  const saveBookmark = async (itemId) => {
    setBookmark(true);
    await AsyncStorage.getItem("bookmark").then((token) => {
      const result = JSON.parse(token);
      // If it is not the 1st bookmark
      if (result != null) {
        let data = result.find((val) => val == itemId);
        if (data == null) {
          result.push(itemId);
          AsyncStorage.setItem("bookmark", JSON.stringify(result));
        }
      } else {
        let bookmark = [];
        AsyncStorage.setItem("bookmark", JSON.stringify(bookmark));
      }
    });
  };

  const removeBookmark = async (itemId) => {
    setBookmark(false);
    const bookmark = await AsyncStorage.getItem("bookmark").then((token) => {
      const result = JSON.parse(token);
      return result.filter((id) => id != itemId);
    });
    await AsyncStorage.setItem("bookmark", JSON.stringify(bookmark));
  };

  // Detects if trail is bookmarked when screen is rendered
  const renderBookmark = async (itemId) => {
    const bookmark = await AsyncStorage.getItem("bookmark").then((token) => {
      const result = JSON.parse(token);
      if (result != null) {
        let data = result.find((val) => val == itemId);
        return data == null ? setBookmark(false) : setBookmark(true);
      }
    });
  };

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView style={styles.scrollView}>
        <TouchableOpacity
          onPress={() =>
            bookmark ? removeBookmark(trailId) : saveBookmark(trailId)
          }
          style={{ alignItems: "center" }}
        >
          <MaterialCommunityIcons
            name={bookmark ? "bookmark" : "bookmark-outline"}
            size={24}
            color={"black"}
          />
          <Text>{bookmark ? "Saved!" : "Bookmark this Trail"}</Text>
        </TouchableOpacity>
        <Text style={styles.title}>
          {JSON.stringify(trailName).replace(/\"/g, "")}
        </Text>
        <Text style={styles.distance}>
          {length ? length.toFixed(2) : "?"} miles
        </Text>
        <MapView
          style={styles.map}
          region={{
            latitude: coordLat || "?",
            longitude: coordLong || "?",
            latitudeDelta: 0.00922,
            longitudeDelta: 0.00421,
          }}
          mapType="hybrid"
        />
        <Text style={styles.maintainer}>Primary trail maintainer:</Text>
        <Text style={styles.maintainer}>{maintainer}</Text>
      </ScrollView>
    </SafeAreaView>
  );

  // To Do:
  //  - Add address? (Would need to convert from coords to address)
  //  - Add primary maintainer?
  //  - Add icons from list screen?
  //  - Add point/line of trail to map: https://github.com/react-native-maps/react-native-maps/blob/master/docs/geojson.md
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
  distance: {
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
  maintainer: {
    fontSize: 20,
    color: colors.secondary,
  },
});

export default TrailInfoScreen;
