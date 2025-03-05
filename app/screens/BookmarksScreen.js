import AsyncStorage from "@react-native-async-storage/async-storage";
import React, { useEffect, useState } from "react";
import { StyleSheet, Text, View, FlatList } from "react-native";

// Local imports
import dataList from "../data/TrailData.json";
import TrailList from "../components/TrailList";

/*
Known Bugs List:
 - Fetching list only happens when screen is loaded for the first time (updates don't appear until app is restarted)
 - Clicking into Info Screen brings you to "Search" navStack
*/

function BookmarksScreen() {
  const [bookmarkList, setBookmarkList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetchBookmark();
  }, []);

  const fetchBookmark = async () => {
    await AsyncStorage.getItem("bookmark").then((token) => {
      const result = JSON.parse(token);
      let bookmarks = [];
      if (result) {
        result.forEach((element) => {
          let data = dataList.features.find((val) => val.id == element);
          bookmarks.push(data);
        });
        setBookmarkList(bookmarks);
        setIsLoading(false);
      } else {
        setBookmarkList([]);
        setIsLoading(false);
      }
    });
  };

  return (
    <View style={styles.background}>
      {isLoading ? (
        <Text>Currently Loading</Text>
      ) : (
        <TrailList data={bookmarkList} />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  background: {
    paddingVertical: 50,
  },
});

export default BookmarksScreen;
