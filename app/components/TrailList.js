import React from 'react';
import {FlatList, StyleSheet, Text, View} from 'react-native';

const TrailList = () => {
  return (
    <View style={styles.container}>
      <FlatList
        data={[
          {key: 'Newberry Trail'},
          {key: 'Hydroelectric Heritage Trailway'},
          {key: 'Telulah Park'},
          {key: 'Ellen Kort Peace Park'},
        ]}
        renderItem={({item}) => <Text style={styles.item}>{item.key}</Text>}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 22,
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
});

export default TrailList;